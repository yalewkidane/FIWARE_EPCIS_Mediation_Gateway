ARG GITHUB_ACCOUNT=yalewkidane
ARG GITHUB_REPOSITORY=FIWARE_EPCIS_Mediation_Gateway
ARG DOWNLOAD=latest
ARG SOURCE_BRANCH=master
ARG JAVA_VERSION=11


########################################################################################
#
# This build stage retrieves the source code from GitHub. The default download is the 
# latest tip of the master of the named repository on GitHub.
#
######################################################################################## 

FROM openjdk:${JAVA_VERSION}-jdk-slim AS builder
ARG GITHUB_ACCOUNT
ARG GITHUB_REPOSITORY
ARG DOWNLOAD
ARG SOURCE_BRANCH

SHELL ["/bin/bash", "-o", "pipefail", "-c"]

# As an Alternative for local development, just copy this Dockerfile into file the root of 
# the repository and replace the whole RUN statement below by the following COPY statement 
# in your local source using :
#
# ADD target/fiware_oiliot_mediation-1.0.0.jar /app/fiware_oiliot_mediation.jar
#


# hadolint ignore=DL3008
RUN \
	# Ensure that unzip is installed prior to downloading
	apt-get update && \
	apt-get install -y --no-install-recommends unzip curl && \
	if [ "${DOWNLOAD}" = "latest" ] ; \
	then \
		RELEASE="${SOURCE_BRANCH}"; \
		echo "INFO: Building Latest Development from ${SOURCE_BRANCH} branch."; \
	elif [ "${DOWNLOAD}" = "stable" ]; \
	then \
		RELEASE=$(curl -s https://api.github.com/repos/"${GITHUB_ACCOUNT}"/"${GITHUB_REPOSITORY}"/releases/latest | grep 'tag_name' | cut -d\" -f4); \
		echo "INFO: Building Latest Stable Release: ${RELEASE}"; \
	else \
	 	RELEASE="${DOWNLOAD}"; \
	 	echo "INFO: Building Release: ${RELEASE}"; \
	fi && \
	RELEASE_CONCAT=$(echo "${RELEASE}" | tr / -); \
	curl -s -L https://github.com/"${GITHUB_ACCOUNT}"/"${GITHUB_REPOSITORY}"/archive/"${RELEASE}".zip > source.zip && \
	unzip source.zip -x "*/.settings/**" "*/src/**" "*/docs/**" "*/.*" "*/target/classes/**" "*/target/test-classes/**" "*/target/maven-status/**" && \
	rm source.zip && \
	mv "${GITHUB_REPOSITORY}-${RELEASE_CONCAT}"/target/fiware_oiliot_mediation-1.0.0.jar ./fiware_oiliot_mediation.jar


########################################################################################
#
# This build stage creates an anonymous user to be used with the distroless build
# as defined below.
#
########################################################################################
FROM openjdk:${JAVA_VERSION}-jdk-slim AS anon-user
RUN sed -i -r "/^(root|nobody)/!d" /etc/passwd /etc/shadow /etc/group \
    && sed -i -r 's#^(.*):[^:]*$#\1:/sbin/nologin#' /etc/passwd

########################################################################################
#
# This build stage creates a distroless image for production.
#
########################################################################################

FROM gcr.io/distroless/java:${JAVA_VERSION}
ARG GITHUB_ACCOUNT
ARG GITHUB_REPOSITORY
ARG JAVA_VERSION

LABEL "maintainer"="Yalew Kidane"
LABEL "org.opencontainers.image.authors"="Yalew Kidane"
LABEL "org.opencontainers.image.documentation"="https://fiware-epcis-gateway.readthedocs.io"
LABEL "org.opencontainers.image.vendor"="Yalew Kidane"
LABEL "org.opencontainers.image.licenses"="Apache-2.0"
LABEL "org.opencontainers.image.title"="Oliot-MG (FIWARE EPCIS Mediation Gateway)"
LABEL "org.opencontainers.image.description"="Oliot-MG is a mediation gateway which translates information from NGSI based IoT platform to EPCIS based IoT platform. This enables capturing state change in FIWARE context broker in the form of EPCIS Event."
LABEL "org.opencontainers.image.source"="https://github.com/${GITHUB_ACCOUNT}/${GITHUB_REPOSITORY}"
LABEL "com.java.version"="${JAVA_VERSION}"

COPY --from=anon-user /etc/passwd /etc/shadow /etc/group /etc/
COPY --from=builder /fiware_oiliot_mediation.jar /app/fiware_oiliot_mediation.jar
WORKDIR /app

USER nobody
CMD ["fiware_oiliot_mediation.jar"]
EXPOSE 8081

