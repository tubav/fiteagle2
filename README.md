FITeagle 2
==========

FITeagle implementation based on OSGi modules and JMS messaging within a J2EE container.

Current build status:
[![Build Status](https://travis-ci.org/tubav/fiteagle_osgi.png?branch=master)](https://travis-ci.org/tubav/fiteagle_osgi)
[![Coverage Status](https://coveralls.io/repos/tubav/fiteagle_osgi/badge.png?branch=master)](https://coveralls.io/r/tubav/fiteagle_osgi?branch=master)

Bootstrapping
-------------

Get everything up and running within a minute:

```
bash -c "$(curl -fsSkL http://fiteagle.org/bootstrap2)"
```

After the bootstrap all software components have been downloaded, configured, compiled and installed:
 * ```server```: the J2EE+OSGi container (WildFly) and XMPP server (OpenFire)
 * ```src```: the FITeagle sources
 * ```tmp```: the downloaded binaries
 
Deployment
----------

If you want to (re-)deploy a new component, run ```cd src/PATH/TO/MODULE; mvn clean install package wildfly:deploy```.

GUI
---

 * WildFly: [http://localhost:8080](http://localhost:8080)
 * WildFly backend: [http://localhost:8080/console](http://localhost:8080/console) (user "admin", password "admin")
 * OSGi: [http://localhost:8080/system/console](http://localhost:8080/system/console) (user "admin", password "admin")
 * FITeagle Backend: [http://localhost:8080/admin](http://localhost:8080/admin)

CLI
---

 * REST: curl http://localhost:8080/rest/configuration/json/getVersion
 * WebSockets (use e.g. tyrus): ws-client ws://localhost:8080/ws/configuration # type 'send getVersion'
