FROM amazoncorretto:21-alpine-jdk
LABEL authors="win"
COPY target/category-service.jar category-service.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "category-service.jar"]