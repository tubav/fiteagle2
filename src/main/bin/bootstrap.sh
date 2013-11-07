#!/usr/bin/env bash

_base="$(pwd)"

_container_type="wildfly"
_container_version="8.0.0.Beta1"
_container_file="${_container_type}-${_container_version}.zip"
_container_url="http://download.jboss.org/${_container_type}/${_container_version}/${_container_file}"
_container_folder="${_base}/container"
_container_config="wildfly-standalone.xml"
_container_config_url="https://raw.github.com/tubav/fiteagle_osgi/master/src/main/resources/wildfly-standalone.xml"
_container_root="${_container_folder}/${_container_type}-${_container_version}"

_osgi_file="jbosgi-installer-2.1.0.jar"
_osgi_url="http://sourceforge.net/projects/jboss/files/JBossOSGi/2.1.0/${_osgi_file}/download"
_osgi_config="jbosgi-autoinstall.xml"
_osgi_config_url="https://raw.github.com/tubav/fiteagle_osgi/master/src/main/resources/jbosgi-autoinstall.xml"

_osgi_console_file="org.apache.felix.webconsole-4.2.0-all.jar"
_osgi_console_url="http://mirror.switch.ch/mirror/apache/dist/felix/${_osgi_console_file}"
_osgi_console_folder="${_container_root}/standalone/deployments"

_installer_folder="${_base}/tmp"

_src_folder="${_base}/src"

_wildfly_admin_user="admin"
_wildfly_admin_pwd="admin"
_wildfly_app_user="fiteagle"
_wildfly_app_pwd="fiteagle"
_wildfly_app_group="guest"

function checkBinary {
  echo -n " * Checking for '$1'..."
  if command -v $1 >/dev/null 2>&1; then
     echo "OK"
     return 0
   else
     echo >&2 "FAILED."
     return 1
   fi
}

function installContainer() {
    echo "Downloading container..."
    mkdir -p "${_installer_folder}"
    curl -C - -fsSSkL -o "${_installer_folder}/${_container_file}" "${_container_url}"
    echo "Installing container..."
    mkdir -p "${_installer_folder}"
    unzip -qu "${_installer_folder}/${_container_file}" -d "${_container_folder}"
}

function installOSGi() {
    echo "Downloading OSGi..."
    mkdir -p "${_installer_folder}"
    curl -C - -fsSkL -o "${_installer_folder}/${_osgi_file}" "${_osgi_url}"
    echo "Installing OSGi..."
    mkdir -p "${_installer_folder}"
    curl -C - -fsSSkL -o "${_installer_folder}/${_osgi_config}" "${_osgi_config_url}"
    java -jar "${_installer_folder}/${_osgi_file}" "${_installer_folder}/${_osgi_config}"
}


function installWebconsole {
  echo "Downloading OSGi web console..."
  curl -C - -fsSkL -o "${_installer_folder}/${_osgi_console_file}" "${_osgi_console_url}"
  echo "Installing OSGi web console..."
  cp "${_installer_folder}/${_osgi_console_file}" "${_osgi_console_folder}"
}


function configContainer() {
    echo "Configuring container..."
    curl -C - -fsSSkL -o "${_installer_folder}/${_container_config}" "${_container_config_url}"
    cp "${_installer_folder}/${_container_config}" "${_container_root}/standalone/configuration"
    cd "${_container_root}"
    ./bin/add-user.sh -u "${_wildfly_admin_user}" -p "${_wildfly_admin_pwd}"
    ./bin/add-user.sh -a -g "${_wildfly_app_group}" -u "${_wildfly_app_user}" -p "${_wildfly_app_pwd}"
}


function startContainer() {
    echo "Starting container..."
    cd "${_container_root}"
    ./bin/standalone.sh -c "${_container_config}"
}

function checkEnvironment {
  _error=0
  echo "Checking environment..."
  checkBinary java; _error=$(($_error + $?))
  checkBinary javac; _error=$(($_error + $?))
  checkBinary mvn; _error=$(($_error + $?))
  checkBinary git; _error=$(($_error + $?))
  checkBinary curl; _error=$(($_error + $?))
  checkBinary unzip; _error=$(($_error + $?))
  if [ "0" != "$_error" ]; then
    echo >&2 "FAILED. Please install the above mentioned binaries."
    exit 1
  fi
}


function installFITeagle {
  repo="fiteagle_osgi"
  git_url="git://github.com/tubav/${repo}"
  
  if [ -d "${_src_folder}/.git" ]; then
    echo -n "Updating FITeagle sources..."
    (cd "${_src_folder}" && git pull -q)
  else
    echo -n "Getting FITeagle sources..."
    git clone -q --recursive --depth 1 ${git_url} ${_src_folder}
  fi
  if [ "0" != "$?" ]; then
    echo >&2 "FAILED. Please have a look above."
    exit 2
  fi
  
  echo "OK"
}

checkEnvironment

installContainer
installOSGi
installWebconsole
configContainer
installFITeagle
startContainer
