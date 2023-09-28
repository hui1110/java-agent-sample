# java-agent-sample

This sample shows how to use the Java Agent.

## Run locally

### In the same project

**Premain**:

```shell
java -javaagent:target\java-agent-sample-0.0.1-SNAPSHOT.jar -jar target\java-agent-sample-0.0.1-SNAPSHOT.jar
```

The return value of the access http://localhost:8081/origin method has changed.

**Agentmain**:

```shell
mvn clean spring-boot:run
```

First access `http://localhost:8081/attach`. The return value of the access `http://localhost:8081/origin` method has changed.

### In different projects

**Premain**:

```shell
./mvnw clean install

java -javaagent:target/java-agent-sample-0.0.1-SNAPSHOT.jar -jar asa-components-spring-boot-admin-0.0.1-SNAPSHOT.jar
```

The return value of the access http://localhost:8081/index method has changed.
