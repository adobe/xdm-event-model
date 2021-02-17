# xdm-event-model

`Adobe I/O Event` Java (Jackson based) Implementation of the `Adobe XDM Event Model`

## Specification

The `Adobe XDM Event Model` is based on [json-ld w3c activity streams spec](https://github.com/w3c/activitystreams/blob/master/ns/activitystreams.jsonld) based

for more detailed specifications, visit
* https://github.com/adobe/xdm/tree/master/schemas/common

## Unit tests

Have a look at our [JUnit](https://junit.org/) [tests](./src/test) 
and you'll have a good understanding of the expected json serialization.

## Builds

This Library is associated with 2 [maven](https://maven.apache.org/) builds (they also run the unit tests):

* one to build a standard Java library, using a standard `pom.xml`
  * to trigger this build locally, use the following command line: `mvn clean install`
* another to build a Java OSGI library (ready for use in [AEM](https://www.adobe.com/marketing/experience-manager.html)), with a `pom-bundle.xml` 
  * to trigger this build locally, use the following command line: `mvn -f pom-bundle.xml clean install`


### Contributing

Contributions are welcomed! Read the [Contributing Guide](./.github/CONTRIBUTING.md) for more information.

### Licensing

This project is licensed under the Apache V2 License. See [LICENSE](LICENSE.md) for more information.

## Other Misc Notes, docs and pointers

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
