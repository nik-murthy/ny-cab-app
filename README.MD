
# Ny Cab Data API

This repository contains data from NY cab trips and attempts to expose that information in the form of an API. The constituents of this app are - 

- MySql database which contains the data.
- Spring boot database client [db-api].
- Redis cache to store results from database queries.
- Spring boot redis client [redis-api].
- Spring boot front controller to handle all incoming requests [web-api].
- A commons project which holds POJOs and methods shared by the 3 projects.

The web-api acts like a front controller and distributes requests between cache and database. The web controller exposes 3 endpoints - 

- Get cab trip summary by medallion and date. This accepts multiple medallions and a single date.
- Same as above, but explicitly from DB and avoids cache.
- Cache flush.

Unless explicitly requested, all requests are sent to the cache. If an entry is found, it is returned. Otherwise, the required information is fetched from the database, populated in the cache and returned.

# Steps To Run
- Clone repo.
- At the root of the repo, where the docker-compose.yml file is present, create a .env file. Entries are private and shared in an email.
- ny-cab-commons project is required by the other projects. It needs to be 'jar'-ed.
- Navigate to ny-cab-api/ny-cab-commons in a terminal window and run ```mvn clean install```.
- That should create the SNAPSHOT jar in the target folder and will be picked up by builds of other projects.
- Run ```docker-compose build``` at the root where docker-compose.yml is located.
- Run ```docker-compose up``` to bring up all services.
- Run ```docker-compose down``` to bring down all services.

When the services are up on your machine, use postman/curl with the following url - 
http://localhost:7002/trips/medallions/67C2B72EB78E36BF7A24B7D432686767,91EDB0A9EEFD7D9169432897F12E4E8C/date/2013-12-30

The API response is an array of cab trip summaries. There is one entry for each medallion and the entry contains the medallion number, the total rides, and the details of all rides (as an array).

# Project Structure Advantages
The API project is a multi-module Spring boot project consisting of 4 modules.

### Scalability
By breaking the API project into 4 modules, it allows each one to containerized independently. Each application can be scaled up and down as required. For example, since this is a read heavy application, it would be advantageous to have more redis instances than database instances. 

### Separation Of Concerns
Another advantage is the separation of concerns. 4 modules may seem like a lot for a simple API, but the design follows the principle of high cohesion and loose coupling. Each module does one thing and does it well. The database module can be easily extended without impacting the rest of the application and the same applies to the other modules.

### Maintainability & Extensibility
All API response objects are segregated in a separate project, all database operations are in a separate project etc. Web security configs such as CORS enabled origins can be configured in the web-api project.

# Areas of Improvement
- Cache clear functionality needs to be properly implemented.
- Input validation in the ny-cab-web-api project is necessary.
- API documentation is necessary.
- docker-compose.yml can be augmented with wait-for-it scripts for better orchestration.
- A central repository for artifacts, such as the commons project, will speed up build time as currently the commons project is being manually installed for each project.
- API can be made secure through Spring Security. For example, cross origin requests can be limited and database methods can be protected by roles.
- The solution consists of minimal test cases as most of the logic deals with translation of data between objects.
- Docker images can be further investigated for optimizations in size.

While there is room for improvement, this project provides a good starting point to building and enhancing an API.

# Assumptions
The API is designed to query the underlying data based on medallion and date. The API should "also" accept multiple medallions. The assumption here is that there is no endpoint which accepts only multiple medallions and no date. 

Hence, instead of creating two endpoints for one and many, there is a single endpoints that works for both the cases of one medallion plus date, and multiple medallions plus date.

The data has duplicate entries. Hence, in the ny-cab-db-api project, the entity class overrides the equals method, and set of unique trips is returned.