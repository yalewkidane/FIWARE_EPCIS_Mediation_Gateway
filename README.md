# FIWARE EPCIS Mediation Gateway


FIWARE EPCIS Mediation Gateway is mediation gateway wich translates information from NGSI based IoT platform to EPCIS based IoT platform. This enables capturing state chage in FIWARE context broker in the form of EPCIS Event. 

![](./src/main/resources/static/FIware_EPCIS_Mediation_Gateway.png)

## Contents

-   [Background](#background)
-   [Install](#install)
-   [Usage](#usage)
-   [License](#license)


## Background
To solve the issue of interoperability, multiple companies, organizations, and consortia have started to join and create standards. Currently, the two major standards that are widely being considered in the IoT sector are EPCIS and NGSI. Nevertheless, the two standards differ both in data encoding and service interface which create fragmentation from the point of view of data consumers application. Moreover, the two platforms differ in the underlying philosophy of representing and storing IoT data; namely, NGSI is entity-based and EPCIS is event-based. This creates an overhead to analyze and process data coming from the two platforms. 

FIWARE - EPCIS mediation gateway is developed to solve the interoperability between NGSI and EPCIS. It translates the entity based data from Orion context broker to EPCIS event. Morever enables treaceability by capturing state chage in FIWARE context broker in the form of EPCIS Event. 

## Install
A jar file is included. To run the mediation gateway the following command can be used. 
```console
java -jar path/to/the_jar_file/fiware_oiliot_mediation-1.0.0.jar
```

A 'Dockerfile' is availble. The following code can be used build and run the mediation gateway

```console
docker build -t fiware_oiliot_mediation .
docker run -p 8081:8081 fiware_oiliot_mediation
```

## Usage

Detail information about how to use the mediation gatway is provide in [FIWARE-EPCIS MEDIATION GATEWAY DEVELOPER GUIDE](./src/main/resources/templates/Guide.pdf)

## License

The mediation gateway is licenced under [Apache 2.0](./LICENSE).

© 2020 




