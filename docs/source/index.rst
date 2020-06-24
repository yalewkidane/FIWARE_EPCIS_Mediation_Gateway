.. fiware-epcis-gateway documentation master file, created by
   sphinx-quickstart on Mon May 18 23:34:00 2020.
   You can adapt this file completely to your liking, but it should at least
   contain the root `toctree` directive.

FIWARE EPCIS Mediation Gateway
==============================

  |FIWAREThirdParty|_
  |License|_
  |OFSupportBadge|_ 

  |DocumentationBadge|_
  |Status|_

.. |FIWAREThirdParty| image:: https://nexus.lab.fiware.org/static/badges/chapters/third-party.svg
.. _FIWAREThirdParty: https://www.fiware.org/developers/catalogue/

.. |License| image:: https://img.shields.io/github/license/yalewkidane/FIWARE_EPCIS_Mediation_Gateway.svg
.. _License: https://opensource.org/licenses/Apache-2.0

.. |OFSupportBadge| image:: https://nexus.lab.fiware.org/repository/raw/public/badges/stackoverflow/fiware.svg
.. _OFSupportBadge: http://stackoverflow.com/questions/tagged/fiware



.. |DocumentationBadge| image:: https://img.shields.io/readthedocs/fiware-epcis-gateway.svg
.. _DocumentationBadge: https://opensource.org/licenses/Apache-2.0

.. |Status| image:: https://nexus.lab.fiware.org/static/badges/statuses/incubating.svg
.. _Status: https://nexus.lab.fiware.org/static/badges/statuses/incubating.svg


Oliot-MG is a mediation gateway which translates information from NGSI based IoT platform to EPCIS based IoT platform. This enables capturing state change in FIWARE context broker in the form of EPCIS Event.

.. image:: ../img/FIware_EPCIS_Mediation_Gateway.png

Background
----------

To solve the issue of interoperability, multiple companies, organizations, and consortia have started to join and create standards. Currently, the two of the major standards that are widely being considered in the IoT sector are EPCIS and NGSI. Nevertheless, the two standards differ both in data encoding and service interface which create fragmentation from the point of view of data consumers application. Moreover, the two platforms differ in the underlying philosophy of representing and storing IoT data; namely, NGSI is entity-based and EPCIS is event-based. This creates an overhead to analyze and process data coming from the two platforms.

FIWARE - EPCIS mediation gateway is developed to solve the interoperability between NGSI and EPCIS. It translates the entity based data from Orion context broker to EPCIS event. Moreover, enables traceability by capturing state change in FIWARE context broker in the form of EPCIS Event.





.. toctree::
   :maxdepth: 2

   install

.. toctree::
   :maxdepth: 2

   usage


   
The mediation gateway is licensed under :download:`Apache 2.0 <../../LICENSE>`.  





