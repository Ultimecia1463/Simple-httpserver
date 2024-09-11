# Simple HTTP Server

A basic HTTP server implemented in Java, demonstrating essential server functionality such as handling HTTP requests and responses.

## Project Structure


D:.
│   pom.xml
│   README.md
│
├───.vscode
│       settings.json
│
├───src
│   ├───main
│   │   ├───java
│   │   │   └───com
│   │   │       └───ultimecia
│   │   │           └───httpserver
│   │   │               │   Httpserver.java
│   │   │               │
│   │   │               ├───config
│   │   │               │       Configuration.java
│   │   │               │       Configurationmanager.java
│   │   │               │
│   │   │               └───util
│   │   │                       json.java
│   │   │
│   │   └───resources
│   │           http.json
│   │
│   └───test
│       └───java
└───target
    ├───classes
    │   │   http.json
    │   │
    │   └───com
    │       └───ultimecia
    │           └───httpserver
    │               │   Httpserver.class
    │               │
    │               ├───config
    │               │       Configuration.class
    │               │       Configurationmanager.class
    │               │
    │               └───util
    │                       json.class
    │
    ├───generated-sources
    │   └───annotations
    ├───maven-status
    │   └───maven-compiler-plugin
    │       └───compile
    │           └───default-compile
    │                   createdFiles.lst
    │                   inputFiles.lst
    │
    └───test-classes


## Features

- **HTTP Request Handling**: Handles basic HTTP methods.
- **Configuration Management**: Configurable server properties.

## Getting Started

1. **Clone the repository**:
   ```bash
   git clone https://github.com/Ultimecia1463/Simple-httpserver.git

2. **Build the project using Maven**:
   ```bash
    mvn clean install

3. **Run the server**:
   ```bash
    java -jar target/simple-httpserver.jar
