# EOSCnode
## EOSC Finnish Service catalog

This program is a copy of the CSC Service catalog which is running as https://data.csc.fi and sources are available https://github.com/CSCfi/servicecatalog.
There are minimal documentation of the database in docs folder. This program is simple API of the database.

The differance of the CSC  Service catalog is that it has no vocabulary but this one has some.

The program is running as https://data-test.eosc.fi/ and target address to prodaction is https://data.eosc.fi/ which don't exist yet.

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

 podman build -f src/main/docker/Dockerfile.native-micro -t quarkus/node .

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
