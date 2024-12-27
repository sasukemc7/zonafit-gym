Este codigo funciona por medio de una base de datos MySQL, puede configurar las credenciales en src/main/resources/application.properties

Si desea montar la base de datos, puede montarla con este codigo sql:

```sql
CREATE DATABASE zona_fit_db;

CREATE TABLE `cliente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `membresia` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `membresia_UNIQUE` (`membresia`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
```