From openjdk:11
Expose 8090
Add target/covid-phase5-release_1.0.jar covid-phase5-release_1.0.jar
ENTRYPOINT ["java","-jar","/covid-phase5-release_1.0.jar"]