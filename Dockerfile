FROM adoptopenjdk/openjdk14:ubi
COPY target/docker-message-server-1.0.0.jar message-server-1.0.0.jar
ENTRYPOINT ["java","-jar","/punchin-server-1.0.0.jar"]
