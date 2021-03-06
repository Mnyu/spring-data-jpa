## Spring-Data-JPA

### Basic Theory : 

- JDBC : API provided by Java to connect to DB.
- Problem with JDBC :
    - Java works on the concepts of Objects and Classes.
    - DB works on the concepts of Tables.
    - Traditional way : Get records from table in DB and convert them into objects.
- Ideally, we should not be doing this conversion, there has to be a system which defines how a particular class/object represents a particular table in DB.
- For this reason, there are different frameworks available that give us this functionality called ORM - Object Relationship Mapping.
- ORM frameworks : Hibernate, Apache iBATIS etc. 
- These frameworks have their own implementation of ORM, so switching between these frameworks is difficult.
- Hence, as always, a STANDARD specification was built and that specification had to be used by the 3rd party ORM providers to ease the switching/replacement.
- Java provides ---> JPA SPECIFICATION.
- Hibernate, Apache iBATIS, etc ---> use this specification and create their implementations of JPA/ORM specification.
- Spring data jpa uses Hibernate as ORM tool by default.

### Example Class Diagram of Entities :
![Image1](https://github.com/Mnyu/spring-data-jpa/blob/main/src/main/resources/static/entities.png)


### Topics covered :
1. Mapping Entities with DB.
2. Different JPA Annotations.
3. Understanding Repositories and their methods.
4. @Embeddable and @Embedded Annotation.
5. @Query Annotation.
6. Native Queries.
7. Query Named Params.
8. @Transactional and @Modifying Annotation.
9. JPA One-To-One Relationship.
10. Cascade Types.
11. Fetch Types.
12. Uni & Bi directional relationship.
13. JPA One-To-Many Relationship.
14. JPA Many-To-One Relationship.
15. Paging and Sorting.
16. JPA Many-To-Many Relationship.

Reference : https://www.youtube.com/watch?v=XszpXoII9Sg