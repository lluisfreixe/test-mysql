CREATE TABLE `individuo` (
  `id_individuo` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `edad` int DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `correo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_individuo`)
) ENGINE=InnoDB AUTO_INCREMENT=8441 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;