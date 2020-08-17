#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build

ENV HOME=/home/usr/app

RUN mkdir -p $HOME

WORKDIR $HOME

#First copy and install the commons dependency
RUN mkdir ny-cab-commons 

COPY ny-cab-commons/target/commons-0.0.1-SNAPSHOT.jar $HOME/ny-cab-commons

COPY ny-cab-commons/pom.xml $HOME/ny-cab-commons

RUN mvn install:install-file -Dfile=$HOME/ny-cab-commons/commons-0.0.1-SNAPSHOT.jar -DpomFile=$HOME/ny-cab-commons/pom.xml

#Now install the package the db api app
COPY ny-cab-db-api/src $HOME/src 

COPY ny-cab-db-api/pom.xml $HOME

RUN mvn package -DskipTests

#
# Package stage
#
FROM openjdk:11-jre-slim
ENV HOME=/home/usr/app
COPY --from=build $HOME/target/db.api-0.0.1-SNAPSHOT.jar /usr/local/lib/db-api.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/db-api.jar"]