FROM openjdk:11
ARG GITHUB_ACCOUNT=yalewkidane
ARG GITHUB_REPOSITORY=FIWARE_EPCIS_Mediation_Gateway

SHELL ["/bin/bash", "-o", "pipefail", "-c"]

COPY target/fiware_oiliot_mediation-1.0.0.jar fiware_oiliot_mediation-1.0.0.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "fiware_oiliot_mediation-1.0.0.jar"] 

LABEL "maintainer"="KAIST Oliot-MG"
LABEL "org.opencontainers.image.authors"="yalewkidane"
LABEL "org.opencontainers.image.documentation"="https://fiware-epcis-gateway.readthedocs.io/"
LABEL "org.opencontainers.image.vendor"="KAIST"
LABEL "org.opencontainers.image.licenses"="Apache-2.0"
LABEL "org.opencontainers.image.title"="FIWARE EPCIS Mediation Gateway"
LABEL "org.opencontainers.image.description"="Oliot-MG is a mediation gateway which translates information from NGSI based IoT platform to EPCIS based IoT platform. This enables capturing state change in FIWARE context broker in the form of EPCIS Event."
LABEL "org.opencontainers.image.source"="https://github.com/${GITHUB_ACCOUNT}/${GITHUB_REPOSITORY}"

