FROM openjdk
WORKDIR /app
COPY ./target/payments-0.0.1-SNAPSHOT.jar /app
EXPOSE 8080
CMD ["java", "-jar", "payments-0.0.1-SNAPSHOT.jar"]