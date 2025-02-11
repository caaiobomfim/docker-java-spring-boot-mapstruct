# Spring Boot API with Docker and MapStruct 🚀

This repository contains a **Spring Boot API** running inside a **Docker container**, using **MapStruct** for object mapping.

This project aims to deploy a **Java 17** + **Spring Boot 3** container that functions as a **REST API** to **manage books**. The API provides endpoints to create and retrieve books, ensuring clean architecture with DTOs and MapStruct for efficient data transformation.

## 📦 Features
- Built with **Java 17** and **Spring Boot 3**.
- Uses **MapStruct** for DTO-to-Entity mapping.
- Uses **Jakarta Validation** for request validation.
- Uses **Docker & Docker Compose** for easy deployment.
- Automatically removes **null fields** from API responses using **`@JsonInclude(JsonInclude.Include.NON_NULL)`**.
- Uses a **utility class (`DateConverter`)** to format date fields.

## 🔧 Tech Stack
- **Java 17**.
- **Spring Boot 3**.
- **MapStruct**.
- **Jakarta Validation**.
- **Docker & Docker Compose**.
- **Maven**.

## 🚀 Getting Started

### 📥 **Cloning the Repository**
To get started, first **clone the repository**:

```sh
git clone https://github.com/caaiobomfim/docker-java-spring-boot-mapstruct.git
```

### 🔥 Running the Application with Docker Compose
Run the following command to build and start the containers:

```sh
cd docker-java-spring-boot-mapstruct
docker-compose up -d --build
```

This will start:
- ✅ Spring Boot Application (spring-boot-app)

### 🌍 Testing the API
Once the container is running, you can test the API.

📌 Create a New Book:

```sh
curl -X POST "http://localhost:8080/books" \
     -H "Content-Type: application/json" \
     -d '{
           "title": "Clean Code",
           "author": "Robert C. Martin",
           "isbn": "9780132350884",
           "language": "English",
           "publishedDate": "2008-08-01"
         }'
```

Expected response:

```sh
{
  "id": 1,
  "title": "Clean Code",
  "author": "Robert C. Martin",
  "isbn": "9780132350884",
  "publishedDate": "01/08/2008"
}
```

### 📜 Viewing Logs

Monitor the Spring Boot Application logs:

```sh
docker logs -f spring-boot-app
```

Expected logs:

```sh
Book successfully created with ID: 1
Returning response: {id=1, title=Clean Code, author=Robert C. Martin, isbn=9780132350884, language=null, publishedDate=01/08/2008}
```

## 📜 Notes

### 📝 Important: Correct pom.xml Configuration for MapStruct & Lombok
To avoid conflicts between Lombok and MapStruct during compilation with Maven, the order of annotation processors in `maven-compiler-plugin` is crucial.

📌 Ensure that:

1. Lombok is processed first.
2. Lombok MapStruct Binding is processed next.
3. MapStruct Processor is processed last.

Correct configuration in `pom.xml`:

```xml
<!-- Maven Compiler Plugin -->
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-compiler-plugin</artifactId>
    <version>3.8.1</version>
    <configuration>
        <source>${maven.compiler.source}</source>
        <target>${maven.compiler.target}</target>
        <annotationProcessorPaths>
            <!-- ✅ Lombok needs to be processed first -->
            <path>
                <groupId>org.projectlombok</groupId>
                <artifactId>lombok</artifactId>
                <version>1.18.36</version>
            </path>
            <!-- ✅ Binding avoids conflicts between Lombok & MapStruct -->
            <path>
                <groupId>org.projectlombok</groupId>
                <artifactId>lombok-mapstruct-binding</artifactId>
                <version>0.2.0</version>
            </path>
            <!-- ✅ MapStruct Processor should be processed last -->
            <path>
                <groupId>org.mapstruct</groupId>
                <artifactId>mapstruct-processor</artifactId>
                <version>1.5.5.Final</version>
            </path>
        </annotationProcessorPaths>
    </configuration>
</plugin>
```