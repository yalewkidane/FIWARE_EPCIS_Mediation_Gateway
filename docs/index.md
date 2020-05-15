# Oliot-MG (FIWARE EPCIS Mediation Gateway)

Oliot-MG is a mediation gateway which translates information from NGSI based IoT
platform to EPCIS based IoT platform. This enables capturing state change in
FIWARE context broker in the form of EPCIS Event.

![](./img/FIware_EPCIS_Mediation_Gateway.png)

## Background

To solve the issue of interoperability, multiple companies, organizations, and
consortia have started to join and create standards. Currently, the two of the
major standards that are widely being considered in the IoT sector are EPCIS and
NGSI. Nevertheless, the two standards differ both in data encoding and service
interface which create fragmentation from the point of view of data consumers
application. Moreover, the two platforms differ in the underlying philosophy of
representing and storing IoT data; namely, NGSI is entity-based and EPCIS is
event-based. This creates an overhead to analyze and process data coming from
the two platforms.

FIWARE - EPCIS mediation gateway is developed to solve the interoperability
between NGSI and EPCIS. It translates the entity based data from Orion context
broker to EPCIS event. Moreover, enables traceability by capturing state change
in FIWARE context broker in the form of EPCIS Event.
