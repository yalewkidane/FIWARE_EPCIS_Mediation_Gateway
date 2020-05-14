FROM openjdk:11
ADD target/fiware_oiliot_mediation-1.0.0.jar fiware_oiliot_mediation-1.0.0.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "fiware_oiliot_mediation-1.0.0.jar"] 
