FROM adoptopenjdk/openjdk15:alpine-jre
ADD target/EmployeeManagementSystem.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]