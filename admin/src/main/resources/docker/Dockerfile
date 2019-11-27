FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD  mod-admin.jar mod-admin.jar
#WORKDIR /app/ucc/
ENTRYPOINT ["java", "-jar", "mod-admin.jar"]