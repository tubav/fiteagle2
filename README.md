FITeagle 2
==========

FITeagle implementation based on OSGi modules and JMS messaging within a WildFly container.

Current build status: [![Build Status](https://travis-ci.org/tubav/fiteagle_osgi.png?branch=master)](https://travis-ci.org/tubav/fiteagle_osgi)

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

Go to ```src/core/logging``` and run ```mvn clean package jboss-as:deploy```. Now you should have deployed the first JMS enabled FITeagle OSGi component.


GUI
---

 * WildFly: [http://localhost:8080](http://localhost:8080)
 * WildFly backend: [http://localhost:8080/console](http://localhost:8080/console) (user "admin", password "admin")
 * OSGi: [http://localhost:8080/system/console](http://localhost:8080/system/console) (user "admin", password "admin")
 * FITeagle: [https://localhost:8443](https://localhost:8443) (to be implemented)
