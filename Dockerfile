# Build client first
FROM node:23 AS build_angular

WORKDIR /src

COPY client/*.json .
# No public folder in this assessment
# COPY client/public public
COPY client/src src

# Run npm to install node_modules -> package.json
RUN npm ci 
RUN npm i -g @angular/cli 
# Produce dist/client/browser
RUN ng build

FROM eclipse-temurin:23-jdk AS builder_java

WORKDIR /src

COPY server/mvnw .
COPY server/pom.xml .
COPY server/src src
COPY server/.mvn .mvn

# Copy the angular application over to static directory
COPY --from=build_angular /src/dist/client/* src/main/resources/static

# Make mvnw executable
RUN chmod a+x mvnw
# produce target/server-0.0.1-SNAPSHOT.jar
RUN ./mvnw package -Dmaven.test.skip=true

# Deployment container
# jdk has compilers which is not needed in the third stage
FROM eclipse-temurin:23-jre 

WORKDIR /app

COPY --from=builder_java /src/target/server-0.0.1-SNAPSHOT.jar app.jar

# Set Env Variables
ENV PORT=8080

EXPOSE ${PORT}
ENTRYPOINT SERVER_PORT=${PORT} java -jar app.jar