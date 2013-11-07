#!/usr/bin/env bash

_target_base="$(pwd)"
_target="${_target_base}/fiteagle"

_container_type="wildfly"
_container_version="8.0.0.Beta1"
_container_file="${_container_type}-${_container_version}.zip"
_container_url="http://download.jboss.org/${_container_type}/${_container_version}/${_container_file}"
_container_folder="${_target_base}/container"
_container_config="wildfly-standalone.xml"

_osgi_file="jbosgi-installer-2.1.0.jar"
_osgi_url="http://sourceforge.net/projects/jboss/files/JBossOSGi/2.1.0/${_osgi_file}/download"
_osgi_config="jbosgi-autoinstall.xml"

_installer_folder="${_target_base}/tmp"
_installer_resources="$(pwd)/src/main/resources"

_wildfly_admin_user="admin"
_wildfly_admin_pwd="admin"
_wildfly_app_user="fiteagle"
_wildfly_app_pwd="fiteagle"

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
    curl -C - -fsSSkL -o "${_installer_folder}/${_container_file}" "${_container_url}"
    echo "Installing container..."
    mkdir -p "${_installer_folder}"
    unzip -qu "${_installer_folder}/${_container_file}" -d "${_container_folder}"
}

function installOSGi() {
    echo "Downloading OSGi..."
    curl -C - -fsSkL -o "${_installer_folder}/${_osgi_file}" "${_osgi_url}"
    echo "Installing OSGi..."
    mkdir -p "${_installer_folder}"
    java -jar "${_installer_folder}/${_osgi_file}" "${_installer_resources}/${_osgi_config}"
}

function configContainer() {
    echo "Configuring container..."
    cp "${_installer_resources}/${_container_config}" "${_container_folder}/${_container_type}-${_container_version}/standalone/configuration"
    cd "${_container_folder}/${_container_type}-${_container_version}"
    ./bin/add-user.sh -u "${_wildfly_admin_user}" -p "${_wildfly_admin_pwd}"
    ./bin/add-user.sh -a -u "${_wildfly_app_user}" -p "${_wildfly_app_pwd}"
}


function startContainer() {
    echo "Starting container..."
    cd "${_container_folder}/${_container_type}-${_container_version}"
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
  repo="fiteagle"
  git_url="git://github.com/tubav/${repo}"
  
  if [ -d "${_target}/.git" ]; then
    echo -n "Updating FITeagle..."
    (cd "${_target}" && git pull -q)
  else
    echo -n "Installing FITeagle..."
    git clone -q --recursive --depth 1 ${git_url} ${_target}
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
configContainer
installFITeagle
startContainer


#cd ${_target}
#./src/main/bin/fiteagle.sh test
#./src/main/bin/fiteagle.sh start


