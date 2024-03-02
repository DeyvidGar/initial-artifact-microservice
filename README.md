# Object Proxy

## Description

<p>This spring boot project is created fot to use in microservice local projects, that contains an initial configuration
that all microservice should to have</p>

<p>To start to use this microservice is recommended to refactor->rename values of:</p>

1. project root this value is actually: **initial-artifact-ms**
2. container spring boot package this value is actually: **com.deyvis.initialartifactms**
3. Main class of spring boot application root this value is actually: **InitialArtifactMsApplication.java**

## Configuration

<p>You should modify or add new values of configuration for use the microservice.
The values to modify are:</p>

- **Interceptor**

<p>desc.</p>

- **RestControllerAdvice**

<p>desc.</p>

## What i need?

<p>You need to have installed:<p>

- Java 17 or >
- Maven.
- Intellij IDE.
- Eclipse or STS IDE.
- Enable Lombok annotation.

## What run the application?

### For Git bash windows console

<p>We can run the application in console following the next steps:</p>

<p>First ensure the path variable in JAVA_HOME should be 17.</p>

1. To find all paths environment variables. 

```console
env
```

2. Of only get the JAVA_HOME value.

```console
echo JAVA_HOME
```

3. Now set the route of your jdk-17.

```console
export JAVA_HOME='C:\Program Files\Java\jdk-17'
```

4. Recommended execute the next command to ensure that the correct running.

```console
mvn clean install
```

5. Finally execute the command to start spring boot application.

```console
mvn spring-boot:run
```

### For Intellij IDE

<p>We can run the application in intellij following the next steps:</p>

```console
1. Find the main class in com.deyvis.initialartifactms.InitialArtifactMsApplication.java
```

```console
2. Right click and Run 'InitialArtifactMsApplication.main()'
```

### For Eclipse or STS IDE

<p>We can run the application in Eclipse following the next steps:</p>

```console
1. Find in the package explorer this proyect
```

```console
2. Right click and Run as -> Spring boot application.
```