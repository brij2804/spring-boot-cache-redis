## module
- springboot-cache-redis

### Tech Stack
- java 15
- spring-boot-starter-parent: 2.6.6
- spring-cloud.version: 2021.0.1
- spring-boot-starter-actuator
- spring-boot-starter-cache
- spring-boot-starter-data-jpa
- spring-boot-starter-data-redis
- spring-boot-starter-web
- spring-cloud-starter
- spring-boot-devtools
- h2database
- redis : 6.2.1

### Concepts
- Cacheable
- CacheEvict
- CachePut
- Cacheable conditions

### URLs
- H2 db
  http://localhost:8080/h2-console/
- Intial data load in H2
  http://localhost:8080/initialDataLoad
- User
  |#|Request Type|Url|
  ---|---
  |GET|http://localhost:8080/user/{userid}|
  |PUT|http://localhost:8080/user|java|[Solution](./Algorithms/AddTwoNumbers.java)|
  |DELETE|http://localhost:8080/user/{id}|
### commands
- SpringbootCacheRedisPart1>docker-compose up
- docker logs -f 74b
- spring-boot:build-image -DskipTests -f pom.xml
