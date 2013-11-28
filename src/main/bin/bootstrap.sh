#!/usr/bin/env bash

_base="$(pwd)"
_resources_url="https://raw.github.com/tubav/fiteagle_osgi/master/src/main/resources/"

_xmpp_type="openfire"
_xmpp_version="3_8_2"
_xmpp_file="${_xmpp_type}_${_xmpp_version}.tar"
_xmpp_folder="${_base}/server"
_xmpp_url="http://download.igniterealtime.org/${_xmpp_type}/${_xmpp_file}.gz"
_xmpp_config="openfire.xml"
_xmpp_config_path="conf/"
_xmpp_config_url="${_resources_url}/${_xmpp_type}/${_xmpp_config_path}/${_xmpp_config}"
_xmpp_db_props="openfire.properties"
_xmpp_db_props_path="embedded-db/"
_xmpp_db_props_url="${_resources_url}/${_xmpp_type}/${_xmpp_db_props_path}/${_xmpp_db_props}"
_xmpp_db_values="openfire.script"
_xmpp_db_values_path="embedded-db/"
_xmpp_db_values_url="${_resources_url}/${_xmpp_type}/${_xmpp_db_values_path}/${_xmpp_db_values}"
_xmpp_keystore="keystore"
_xmpp_keystore_path="resources/security/"
_xmpp_keystore_url="${_resources_url}/${_xmpp_type}/${_xmpp_keystore_path}/${_xmpp_keystore}"
_xmpp_root="${_xmpp_folder}/${_xmpp_type}"

_container_type="wildfly"
_container_version="8.0.0.Beta1"
_container_file="${_container_type}-${_container_version}.zip"
_container_url="http://download.jboss.org/${_container_type}/${_container_version}/${_container_file}"
_container_folder="${_base}/server"
_container_config="standalone-fiteagle.xml"
_container_config_url="${_resources_url}//wildfly/standalone/configuration/standalone-fiteagle.xml"
_container_root="${_container_folder}/${_container_type}-${_container_version}"

_osgi_file="jbosgi-installer-2.1.0.jar"
_osgi_url="http://sourceforge.net/projects/jboss/files/JBossOSGi/2.1.0/${_osgi_file}/download"
_osgi_config="autoinstall.xml"
_osgi_config_url="${_resources_url}//jbosgi/autoinstall.xml"

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

function installXMPP() {
    echo "Downloading XMPP server..."
    mkdir -p "${_installer_folder}"
    curl -fsSSkL -o "${_installer_folder}/${_xmpp_file}" "${_xmpp_url}"
    echo "Installing XMPP server..."
    mkdir -p "${_xmpp_folder}"
    tar xzf "${_installer_folder}/${_xmpp_file}" -C "${_xmpp_folder}"
}

function configXMPP() {
    echo "Configuring XMPP server..."
    curl -fsSSkL -o "${_installer_folder}/${_xmpp_config}" "${_xmpp_config_url}"
    curl -fsSSkL -o "${_installer_folder}/${_xmpp_db_props}" "${_xmpp_db_props_url}"
    curl -fsSSkL -o "${_installer_folder}/${_xmpp_db_values}" "${_xmpp_db_values_url}"
    curl -fsSSkL -o "${_installer_folder}/${_xmpp_keystore}" "${_xmpp_keystore_url}"
    mkdir -p "${_xmpp_root}/${_xmpp_config_path}"
    cp "${_installer_folder}/${_xmpp_config}" "${_xmpp_root}/${_xmpp_config_path}"
    mkdir -p "${_xmpp_root}/${_xmpp_db_props_path}"
    cp "${_installer_folder}/${_xmpp_db_props}" "${_xmpp_root}/${_xmpp_db_props_path}"
    mkdir -p "${_xmpp_root}/${_xmpp_db_values_path}"
    cp "${_installer_folder}/${_xmpp_db_values}" "${_xmpp_root}/${_xmpp_db_values_path}"
    mkdir -p "${_xmpp_root}/${_xmpp_keystore_path}"
    cp "${_installer_folder}/${_xmpp_keystore}" "${_xmpp_root}/${_xmpp_keystore_path}"
}

function startXMPP() {
    echo "Starting XMPP server in background..."
    export OPENFIRE_HOME="${_xmpp_root}"
    export OPENFIRE_LIB="${OPENFIRE_HOME}/lib"
    export OPENFIRE_OPTS="-Xmx256m -DopenfireHome=${OPENFIRE_HOME} -Dopenfire.lib.dir=${OPENFIRE_LIB}"
    export OPENFIRE_CLASS="-classpath ${OPENFIRE_LIB}/startup.jar"
    export OPENFIRE_JAR="-jar ${OPENFIRE_LIB}/startup.jar"
    export OPENFIRE_ARGS="-server ${OPENFIRE_OPTS} ${OPENFIRE_CLASS} ${OPENFIRE_JAR}"
    java $OPENFIRE_ARGS &
    _xmpp_pid=$!
    sleep 10
    echo "$_xmpp_pid" > ${_base}/xmpp.pid
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
    curl -fsSkL -o "${_installer_folder}/${_osgi_file}" "${_osgi_url}"
    echo "Installing OSGi..."
    mkdir -p "${_installer_folder}"
    curl -fsSSkL -o "${_installer_folder}/${_osgi_config}" "${_osgi_config_url}"
    java -jar "${_installer_folder}/${_osgi_file}" "${_installer_folder}/${_osgi_config}"
}


function installWebconsole {
  echo "Downloading OSGi web console..."
  curl -fsSkL -o "${_installer_folder}/${_osgi_console_file}" "${_osgi_console_url}"
  echo "Installing OSGi web console..."
  cp "${_installer_folder}/${_osgi_console_file}" "${_osgi_console_folder}"
}


function configContainer() {
    echo "Configuring container..."
    curl -fsSSkL -o "${_installer_folder}/${_container_config}" "${_container_config_url}"
    cp "${_installer_folder}/${_container_config}" "${_container_root}/standalone/configuration"
    cd "${_container_root}"
    ./bin/add-user.sh -u "${_wildfly_admin_user}" -p "${_wildfly_admin_pwd}"
    ./bin/add-user.sh -a -g "${_wildfly_app_group}" -u "${_wildfly_app_user}" -p "${_wildfly_app_pwd}"
}


function startContainer() {
    echo "Starting container in background..."
    cd "${_container_root}"
    ./bin/standalone.sh -b 0.0.0.0 -c "${_container_config}" &
    _container_pid=$!
    sleep 10
    echo "$_container_pid" > ${_base}/container.pid
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
  
  echo "OK"
}

function startFITeagle {
    cd "${_src_folder}"
    mvn -DskipTests clean install wildfly:deploy
}

checkEnvironment
installXMPP
configXMPP
startXMPP

installContainer
installOSGi
installWebconsole
configContainer
startContainer

installFITeagle
startFITeagle

echo -n "Press enter to stop all servers..."; read

kill $_xmpp_pid
pkill -P $_container_pid