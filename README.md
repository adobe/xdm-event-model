# xdm-event-model

[![jenkins_jar](https://img.shields.io/badge/jenkins-jar-green.svg?style=flat)](https://cloudaction.ci.corp.adobe.com:12001/job/xdm-event-model/)
[![artifactory_jar](https://img.shields.io/badge/artifactory-jar-green.svg?style=flat)](https://artifactory.corp.adobe.com/artifactory/maven-cloud-action-local/com/adobe/xdm/event/xdm-event-model/)

[![jenkins_osgi](https://img.shields.io/badge/jenkins-osgi-blue.svg?style=flat)](https://cloudaction.ci.corp.adobe.com:12001/job/xdm-event-model-osgi/)
[![artifactory_osgi](https://img.shields.io/badge/artifactory-osgi-blue.svg?style=flat)](https://artifactory.corp.adobe.com/artifactory/maven-cloud-action-local/com/adobe/xdm/event/com.adobe.xdm.event.xdm-event-model/)


`Adobe I/O` Java (Jackson based) Implementation of the XDM event model

## Specification


The XDM event-model is based on [json-ld w3c activity streams spec](https://github.com/w3c/activitystreams/blob/master/ns/activitystreams.jsonld) based

for more detailed specifications, visit
* https://wiki.corp.adobe.com/pages/viewpage.action?spaceKey=AdobeCloudPlatform&title=XDM+Event+Envelope
* https://github.com/adobe/xdm/tree/master/schemas/common


Have a look at the unit tests and you'll have a good understanding of the expected json serialization.

## Builds

This Library is associated with 2 builds:

* one for the standard Java library, with a classic `pom.xml`
* another to build it as an OSGI library ready for use in AEM, with a `pom-bundle.xml` 
  * to trigger this build use the following command line: `mvn -f pom-bundle.xml -s settings.xml clean install`
  
## Contribute
 
* propose update through our spec wiki
* and/or git pull request 
  * Please follow our [coding style guide](https://git.corp.adobe.com/adobeio/ca-common/tree/master/src/main/resources/styleguide/README.md)
 
## Notes, docs and pointers

Note that as we chose to serve the json-ld `@context` through link header [9] and keep fixed json-ld prefixes,
we based this implementation of plain and simple jackson [10] serialization,
otherwise for full-fledged json-ld implementation hydra [0] and jsonld-java [8] could have been used

* [0] http://www.hydra-cg.com/
* [1] https://github.com/dschulten/hydra-java
* [2] https://github.com/dschulten/hydra-java/tree/master/hydra-jsonld
* [3] https://json-ld.org/playground/
* [4] https://github.com/w3c/activitystreams/issues/134#issuecomment-108122077
* [5] https://github.com/w3c/activitystreams/issues/136
* [6] http://livefyre-cdn.s3.amazonaws.com/libs/livefyre-activity-vocabulary/v0.0.0/context.json
* [8] https://github.com/jsonld-java/jsonld-java
* [9] https://www.w3.org/TR/json-ld/#interpreting-json-as-json-ld
* [10] https://github.com/FasterXML/jackson-core
