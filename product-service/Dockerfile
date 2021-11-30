FROM adoptopenjdk:11-jre-hotspot

COPY target/spring-boot-docker.jar spring-boot-docker.jar

ENTRYPOINT ["java", "-jar", "spring-boot-docker.jar"]