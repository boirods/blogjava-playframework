FROM openjdk:8-jre-alpine

EXPOSE 9000
COPY . .
ENTRYPOINT ["sbt", "run"]