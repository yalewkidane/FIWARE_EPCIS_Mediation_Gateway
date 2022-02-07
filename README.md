# Oliot-MG (FIWARE EPCIS Mediation Gateway)

[![FIWARE Third Party](https://nexus.lab.fiware.org/static/badges/chapters/third-party.svg)](https://www.fiware.org/developers/catalogue/)
[![License: Apache](https://img.shields.io/github/license/yalewkidane/FIWARE_EPCIS_Mediation_Gateway.svg)](https://opensource.org/licenses/Apache-2.0)
[![SOF support badge](https://nexus.lab.fiware.org/repository/raw/public/badges/stackoverflow/fiware.svg)](http://stackoverflow.com/questions/tagged/fiware)
<br/>
[![Documentation badge](https://img.shields.io/readthedocs/fiware-epcis-gateway.svg)](https://fiware-epcis-gateway.readthedocs.io/en/latest/?badge=latest)
![Status](https://nexus.lab.fiware.org/static/badges/statuses/incubating.svg)
[![CII Best Practices](https://bestpractices.coreinfrastructure.org/projects/5324/badge)](https://bestpractices.coreinfrastructure.org/projects/5324)

 Oliot-MG is a mediation gateway which translates information from NGSI based IoT platform to EPCIS based IoT platform. This enables capturing state change in FIWARE context broker in the form of EPCIS Event.

![](./src/main/resources/static/FIware_EPCIS_Mediation_Gateway.png)

This project is part of [FIWARE](https://www.fiware.org/). For more information check the FIWARE Catalogue entry for
[Third Party Tools](https://github.com/Fiware/catalogue/tree/master/third-party).

| :books: [Documentation](https://fiware-epcis-gateway.readthedocs.io) |
| -------------------------------------------------------------------- |

## Contents

-   [Background](#background)
-   [Install](#install)
-   [Usage](#usage)
-   [License](#license)


## Background
To solve the issue of interoperability, multiple companies, organizations, and consortia have started to join and create standards. Currently, the two of the major standards that are widely being considered in the IoT sector are EPCIS and NGSI. Nevertheless, the two standards differ both in data encoding and service interface which create fragmentation from the point of view of data consumers application. Moreover, the two platforms differ in the underlying philosophy of representing and storing IoT data; namely, NGSI is entity-based and EPCIS is event-based. This creates an overhead to analyze and process data coming from the two platforms.

FIWARE - EPCIS mediation gateway is developed to solve the interoperability between NGSI and EPCIS. It translates the entity based data from Orion context broker to EPCIS event. Moreover, enables traceability by capturing state change in FIWARE context broker in the form of EPCIS Event.

## Install
A jar file is included. To run the mediation gateway the following command can be used. 
```console
java -jar path/to/the_jar_file/fiware_oiliot_mediation-1.0.0.jar
```

A 'Dockerfile' is also availble. The following code can be used build and run the mediation gateway

```console
docker build -t fiware_oiliot_mediation .
docker run -p 8081:8081 fiware_oiliot_mediation
```

## Usage

Detail information about how to use the mediation gatway is provided in [FIWARE-EPCIS MEDIATION GATEWAY DEVELOPER GUIDE](./src/main/resources/templates/Guide.pdf)


**Paper :** [Towards Interoperability of Entity-Based and Event-Based IoT Platforms: The Case of NGSI and EPCIS Standards](https://ieeexplore.ieee.org/stamp/stamp.jsp?tp=&arnumber=9388690)

**Video :** [How it works](https://drive.google.com/file/d/1TsRI_cbWmLY9gSA2hNP6UzybOGGOx6d_/view?usp=sharing)

## License

The mediation gateway is licenced under [Apache 2.0](./LICENSE).

© 2020 oliot




