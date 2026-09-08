# EOSCnode
## EOSC Node Finland Service Catalog

This java program is a copy of the CSC Service catalog which is running at https://data.csc.fi and source code is available https://github.com/CSCfi/servicecatalog. As CSC External Service catalog shows only metadata of services for research provided or owned by CSC, EOSC Node Finland Service Catalog shows metadata of services provided by other organisations.

- There is minimal documentation of the database in docs folder, but documentation will be enhanced. 
- The program itself is a simple API of the service catalog database.
- The program is running in https://data.eosc.fi/ .
- The program setting are src/main/resources/application.properties file.
- Unlike CSC Service catalog implementation, EOSC Node Finland implementation uses some controlled vocabularies attached to some fields.

### Differences between different Service Catalog APIs and endPoints:

#### CSC External Service catalog
- Shows only metadata of services for research provided or owned by CSC.
- Main focus groups are researchers affiliated in Finland and Finnish research organisations, because of the terms of use or other conditions related to some services.
- Service data model is compliant with Finnish National Data Model.
- API endPoint is found in https://data.eosc.fi/ and a public user interface of the Service Catalog in https://research.csc.fi/.

#### EOSC Node Finland Service Catalog
There are two API end points:
##### Federated services from EOSC Node Finland: https://data.eosc.fi/v1/services
- Curated list of Finnish services available for users outside of Finland (Open Access services, services with Open Access functionalities (e.g. discovery) and/or services with federated access (MyAccessID).
- Service Data Model is compliant with EOSC guidelines (Registration of EOSC Service Catalogues, DOI [10.5281/zenodo.17513487](https://doi.org/10.5281/zenodo.17513487)). 
- Services from other EOSC Nodes are excluded from this endPoint and this endPoint is recommended as a harvesting endPoint for other EOSC Nodes
###### EOSC Node Finland Service Catalog https://data.eosc.fi//v1/service
- EOSC Node FInland Service Catalog UI (in [eosc.fi](https://eosc.fi/)) uses this endPoint and it's recommended as a harvesting endPoint for Finnish research organisations.
- Main focus groups are researchers affiliated in Finland and Finnish research organisations, because of the terms of use or other conditions related to some services.

## Used software

### Quarkus framework

- Micrometer Registry Prometheus ([guide](https://quarkus.io/guides/micrometer)): Enable Prometheus support for Micrometer
- JDBC Driver - MariaDB ([guide](https://quarkus.io/guides/datasource)): Connect to the MariaDB database via JDBC
- Hibernate ORM with Panache ([guide](https://quarkus.io/guides/hibernate-orm-panache)): Simplify your persistence code
 for Hibernate ORM via the active record or the repository pattern
- RESTEasy Classic ([guide](https://quarkus.io/guides/resteasy)): REST endpoint framework implementing Jakarta REST and
 more
- Agroal - Database connection pool ([guide](https://quarkus.io/guides/datasource)): Pool JDBC database connections (included in Hibernate ORM)


## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
mvn compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
mvn package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
mvn package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
mvn package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/palvelukatalog-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Building container
```shell script
 podman build -f src/main/docker/Dockerfile.native-micro -t quarkus/node .
```

PS. There are many dockerfiles but my selection is native-micro
You can find the container
```shell script
podman images
```
command and tag and deploy by podman push. 

## Contributing

Pekka Järveläinen

## License

MIT. See the License file.

## Project status

Test
