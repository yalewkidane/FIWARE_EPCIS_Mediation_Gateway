FROM openjdk:8
ADD target/fiware_oiliot_mediation_1_0.jar fiware_oiliot_mediation_1_0.jar
EXPOSE 8025
ENTRYPOINT ["java", "-jar", "fiware_oiliot_mediation_1_0.jar"] 