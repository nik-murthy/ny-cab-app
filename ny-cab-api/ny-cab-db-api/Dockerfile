#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build

#First copy and install the commons dependency
RUN mkdir ny-cab-commons 
COPY ny-cab-commons/target/commons-0.0.1-SNAPSHOT.jar ny-cab-commons
COPY ny-cab-commons/pom.xml ny-cab-commons
RUN ls -lrt ./ny-cab-commons
RUN mvn install:install-file -Dfile=./ny-cab-commons/commons-0.0.1-SNAPSHOT.jar -DpomFile=./ny-cab-commons/pom.xml

#Now install the package the db api app
COPY ny-cab-db-api/src src 
COPY ny-cab-db-api/pom.xml .
#COPY src src
#COPY pom.xml .
RUN mvn dependency:go-offline
RUN mvn -f ./pom.xml clean package

#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build ./target/db.api-0.0.1-SNAPSHOT.jar /usr/local/lib/db-api.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/db-api.jar"]