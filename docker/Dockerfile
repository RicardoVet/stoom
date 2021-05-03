FROM openjdk:8-jre-alpine


COPY target/stoom-0.0.1-SNAPSHOT.jar /app/stoom-0.0.1-SNAPSHOT.jar


ENTRYPOINT java -jar -DDB_HOST=mysql -Dspring.profiles.active=docker /app/stoom-0.0.1-SNAPSHOT.jar