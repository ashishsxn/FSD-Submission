FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD  mod-user.jar mod-user.jar
#WORKDIR /app/ucc/
ENTRYPOINT ["java", "-jar", "mod-user.jar"]