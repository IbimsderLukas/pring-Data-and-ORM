# MidEng GK8.1 Spring Data and ORM [GK/EK]

# Step One:

I followed the the website and created all the classes with the code needed.

![](file://C:\Users\lukas.dumbo\AppData\Roaming\marktext\images\2025-04-27-21-42-06-image.png?msec=1745930230212)

After starting up the Aplication, the aplication also created its own MySql Docker Container and this was at first a problem for me since i already got one running.

After fixing that issue, I tried testing the Post and Get Methods and they worked flawlessly.

![](file://C:\Users\lukas.dumbo\AppData\Roaming\marktext\images\2025-04-27-21-44-15-image.png?msec=1745930230213)

200 means it passed.

After using Get we can see all the useres saved in the database.

![](file://C:\Users\lukas.dumbo\AppData\Roaming\marktext\images\2025-04-27-21-44-59-image.png?msec=1745930230220)

```java
 @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }
```

Das ist die Get all users Methode die den Pfad Localhost/dem/all hat

# Theorie:

### 1. What is ORM and how is JPA used?

**ORM** (Object-Relational Mapping) automatically maps your Java classes to database tables so you don’t hand-write every SQL query. **JPA** (Java Persistence API) is the standard interface; Spring Data JPA implements it. You just annotate your classes with `@Entity` and Spring takes care of saving, loading, and linking objects behind the scenes.

---

### 2. What is `application.properties` for and where does it live?

`application.properties` (or `application.yml`) holds your app’s configuration:

- Database URL, username, password
  
- Hibernate settings (e.g. `spring.jpa.hibernate.ddl-auto=update`)
  
- Server port, logging levels, etc.  
  It must sit in `src/main/resources` so Spring Boot can pick it up on startup.
  

---

### 3. Common entity annotations & key points

- `@Entity` marks a class as a table.
  
- `@Table(name="…")` if you need a custom table name.
  
- `@Id` + `@GeneratedValue(strategy=…)` defines the primary key (e.g. `IDENTITY` for MySQL).
  
- `@Column` to tweak column names, lengths, nullability.
  

**Keep in mind:**

1. You need a no-arg constructor (can be `protected`).
  
2. Your primary key must be unique.
  
3. Field names should either match column names or be mapped explicitly.
  

---

### 4. Basic CRUD methods you get “for free”

By extending `CrudRepository<Entity, ID>`, you immediately have:

- `save(entity)` – **Create** & **Update**
  
- `findById(id)` – **Read** one
  
- `findAll()` – **Read** all
  
- `delete(entity)` / `deleteById(id)` – **Delete**
  

Plus, you can define simple finder methods like:

```java
List<User> findByEmail(String email);
```
