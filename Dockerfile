FROM eclipse-temurin:8-jdk-focal
ADD target/test-mysql-1.0.jar test-mysql-1.0.jar
ENTRYPOINT ["java", "-jar", "test-mysql-1.0.jar"]