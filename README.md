FITeagle 2
==========

FITeagle implementation based on OSGi modules and JMS messaging within a WildFly container.

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
 
Setup
-----

Go to the ```src``` folder and run ```mvn clean package jboss-as:deploy``` and the open [https://localhost:8443](http://localhost:8443).

This is ongoing work.
