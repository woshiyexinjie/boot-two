FROM openjdk:8-jdk-alpine
COPY target /opt/target
WORKDIR /opt/target
RUN find -type f -name "*.jar" | xargs -I{} mv {} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]