# Setup database

**Create a database**
```sh
create database <database_name>;
```
**Use database**
```sh
use <database_name>;
```
**Update persistence.xml**
```xml
 <property name="jakarta.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/<YOUR_DATABASE_NAME>"/>
            <property name="jakarta.persistence.jdbc.user" value="<YOUR_DB_USERNAME>"/>
            <property name="jakarta.persistence.jdbc.password" value="<DB_PASSWORD>"/>
```

**Run the project**

```sh
mvn exec:java -Dexec.mainClass="Main"
```

