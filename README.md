FITeagle 2
==========

FITeagle implementation based on OSGi modules and JMS messaging within a WildFly container.

Current build status:
[![Build Status](https://travis-ci.org/tubav/fiteagle_osgi.png?branch=master)](https://travis-ci.org/tubav/fiteagle_osgi)
[![Coverage Status](https://coveralls.io/repos/tubav/fiteagle_osgi/badge.png?branch=master)](https://coveralls.io/r/tubav/fiteagle_osgi?branch=master)

Bootstrapping
-------------

Get everything up and running within 30 seconds:

```
bash -c "$(curl -fsSkL http://fiteagle.org/bootstrap2)"
```

After the bootstrap, a pre-configured WildFly instance is running and you'll see the following structure
 * ```container```: the WildFly container
 * ```src```: the FITeagle sources
 * ```tmp```: the downloaded binaries
 
Deployment
----------

Run ```mvn clean install package jboss-as:deploy```.

GUI
---

 * WildFly: [http://localhost:8080](http://localhost:8080)
 * WildFly backend: [http://localhost:8080/console](http://localhost:8080/console) (user "admin", password "admin")
 * OSGi: [http://localhost:8080/system/console](http://localhost:8080/system/console) (user "admin", password "admin")
 * FITeagle Backend: [http://localhost:8080/admin](http://localhost:8080/admin)
 * FITeagle: [https://localhost:8443](https://localhost:8443) (to be implemented)

CLI
---

 * REST: curl http://localhost:8080/rest/configuration/json/getVersion
 * WebSockets: ws-client ws://localhost:8080/ws/configuration # then send getVersion
