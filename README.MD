
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
- Run ```docker-compose build``` at the root where docker-compose.yml is located.
- Run ```docker-compose up``` to bring up all services.
- Run ```docker-compose down``` to bring down all services.

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
- A central repository for artifacts, such as the commons project, will speed up build time as currently the commons project is being manually installed for each project.
- API can be made secure through Spring Security. For example, cross origin requests can be limited and database methods can be protected by roles.
- The solution consists of minimal test cases as most of the logic deals with translation of data between objects.
- Docker images can be further investigated for optimizations in size.