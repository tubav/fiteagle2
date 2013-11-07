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

Go to ```core/logging``` and run ```mvn clean package jboss-as:deploy```. Now you should have deployed the first OSGi+JMS FITeagle component.
