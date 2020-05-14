# Appendix

## GS1 Key proposal for farming

| Objects to be identified | FIWARE Key | GS1 Key | Comment |
| --- | --- | --- | --- |
| Farm|  `urn:entity:farm:<farmId>` | `urn:epc:id:sgln:{companyPrefix}:{locationReference}:{extensionComponent}` | SGLN is used here (GIAI can be used)<br>Example: Farm->100<br>`urn:epc:id:sgln:88000269:100:<farmId>` |
| Building | `urn:entity:building:<buildingId>` | `urn:epc:id:sgln:{companyPrefix}:{locationReference}:{extensionComponent}` | SGLN is used here (GIAI can be used)<br>Example: building ->101<br>`urn:epc:id:sgln:88000269:101:<buildingId >` |
| Pen | `urn:entity:pen:<penId>` | `urn:epc:id:sgln:{companyPrefix}:{locationReference}:{extensionComponent}` | SGLN is used here (GIAI can be used)<br>Example: building ->102<br>`urn:epc:id:sgln:88000269:101:<penId >` |
|Pig | `urn:entity:pig:<pigId>`|` urn:epc:id:sgtin:{companyPrefix}:{ItemReference}:{SerialNumber}`| GTIN is used here<br>Example: building ->103<br> `urn:epc:id:sgtin:88000269:101:<pigId >`|
|slaughterhouse | `urn:entity:slaughterhouse:<slaughterhouseId>` |`urn:epc:id:sgln:{companyPrefix}:{locationReference}:{extensionComponent}`| SGLN is used here (GIAI can be used)<br>Example: building ->104<br>`urn:epc:id:sgln:88000269:104:<slaughterhouseId >` |


### FIWARE Pig Farming Examples

#### Pig example

```json
 {
 "id": "Pig-b5b4da51-373d-444c-ab74-fe27109f3d83",
 "type": "Pig",
 "additionalInfo": {
 "type": "T",
 "value": {
 "ILVOPenId": "7",
 "feed_intake": "329",
 "visit_time": "2018-05-08 19:53:14",
 "ILVOPeriod": "2",
 "weight": "31500",
 "responder": "984000100625782",
 "ILVONRstation": "5782",
 "ILVOLFtag": "984000100625782",
 "duration": "717",
 "ILVOPigId": "10",
 "DEBUG-filename": "tempRealIlvoNedapVelosvelos_ilvo.vpu-online.com_ppt_location0-9999_2018-05-
08.csv",
 "ILVOHFtagLeft": "E00401005BA42B5A",
 "lifenumber": "10",
 "location": "7",
 "state": "0",
 "DEBUG-currentLine": "552",
 "ILVOHFtagRight": "E00401005BA42C4F",
 "ILVOSanitel": "70148"
 },
 "metadata": {}
 },
 "arrivalTimestamp": {
 "type": "Text",
 "value": "",
 "metadata": {}
 },
 "buildingId": {
 "type": "Text",
 "value": "",
 "metadata": {}
 },
 "companyId": {
 "type": "Text",
 "value": "8b6e0aa4-08fc-4f6f-960d-5a65a748b0e7",
 "metadata": {}
 },
 "compartmentId": {
 "type": "Text",
 "value": "",
 "metadata": {}
 },
 "endTimestampAcquisition": {
 "type": "Number",
 "value": 1534895999,
 "metadata": {}
 },
 "endTimestampMonitoring": {
 "type": "Number",
 "value": 1534895999,
 "metadata": {}
 },
 "farmId": {
 "type": "Text",
 "value": "9a68ea4e-348e-424e-9346-6e9fefaf18db",
 "metadata": {}
 },
 "lastUpdate": {
 "type": "DateTime",
 "value": "2018-05-08T19:53:14.00Z",
 "metadata": {}
 },
 "penId": {
 "type": "Text",
 "value": "b1d7f4b0-2d8f-4c6d-b7f4-ed03e4ed25ee",
 "metadata": {}
 },
 "pigId": {
 "type": "Text",
 "value": "b5b4da51-373d-444c-ab74-fe27109f3d83",
 "metadata": {}
 },
 "serialNumber": {
 "type": "Text",
 "value": "",
 "metadata": {}
 },
 "sex": {
 "type": "Text",
 "value": "B",
 "metadata": {}
 },
 "startTimestampAcquisition": {
 "type": "Number",
 "value": 1519430400,
 "metadata": {}
 },
 "startTimestampMonitoring": {
 "type": "Number",
 "value": 1519430400,
 "metadata": {}
 },
 "totalConsumedFood": {
 "type": "Number",
 "value": 329,
 "metadata": {}
 },
 "totalConsumedWater": {
 "type": "Text",
 "value": "",
 "metadata": {}
 },
 "totalTimeConsumedFood": {
 "type": "Number",
 "value": 717,
 "metadata": {}
 },
 "totalTimeConsumedWater": {
 "type": "Text",
 "value": "",
 "metadata": {}
 },
 "weight": {
 "type": "Number",
 "value": 31500,
 "metadata": {}
 }
 }
```

#### Building Example

```json
{
 "id": "Building-319cba0c-773d-4964-b750-136a8d5fb3c1",
 "type": "Building",
 "CO2": {
 "type": "Text",
 "value": "",
 "metadata": {}
 },
 "additionalInfo": {
 "type": "T",
 "value": {
 "SensorState": "null",
 "GatewayID": "904987",
 "CheckDigit": "KOIP",
 "accountID": "16892",
 "PlotValues": "5",
 "monnitApplicationID": "21",
 "powerSourceID": "2",
 "Voltage": "2.89",
 "Battery": "72",
 "lastCommunicationDate": "10/16/2019 2:00:02 PM",
 "applicationID": "21",
 "ApplicationID": "null",
 "batteryLevel": "72",
 "SignalStrength": "94",
 "SensorID": "324246",
 "PlotValue": "5",
 "canUpdate": "True",
 "MessageDate": "10/16/2019 8:00:02 PM",
 "sensorName": "Lux - 324246 - Hok 4 AP",
 "signalStrength": "96",
 "Data": "5",
 "plotLabels": "Lux",
 "sensorID": "324246",
 "currentReading": "10 lux",
 "AlertSent": "null",
 "nextCommunicationDate": "10/16/2019 2:10:02 PM",
 "MetNotificationRequirements": "False",
 "DataValues": "5",
 "CSNetID": "27898",
 "State": "0",
 "alertsActive": "True",
 "DisplayData": "5 lux",
 "lastDataMessageMessageGUID": "7a3b9ec6-db5b-4d84-a254-e7a77bf3f036",
 "status": "0",
 "DataMessageGUID": "75939fd1-51bc-47ce-b69d-9e2faf8fffae",
 "DataTypes": "LuxData"
 },
 "metadata": {}
 },
 "buildingId": {
 "type": "Text",
 "value": "319cba0c-773d-4964-b750-136a8d5fb3c1",
 "metadata": {}
 },
 "companyId": {
 "type": "Text",
 "value": "8b6e0aa4-08fc-4f6f-960d-5a65a748b0e7",
 "metadata": {}
 },
 "farmId": {
 "type": "Text",
 "value": "9a68ea4e-348e-424e-9346-6e9fefaf18db",
 "metadata": {}
 },
 "humidity": {
 "type": "Number",
 "value": 81.39,
 "metadata": {}
 },
 "lastUpdate": {
 "type": "DateTime",
 "value": "2019-10-16T20:00:02.00Z",
 "metadata": {}
 },
 "luminosity": {
 "type": "Number",
 "value": 5,
 "metadata": {}
 },
 "name": {
 "type": "Text",
 "value": "ILVO building 1",
 "metadata": {}
 },
 "temperature": {
 "type": "Number",
 "value": 22.97,
 "metadata": {}
 }
 }
```

### FIWARE data models schema for farm

### Farm Entity

```json
{
 "$id": "https://resl.com/farm.schema.json",
 "$schema": "http://json-schema.org/draft-07/schema#",
 "title": "Farm",
 "type": "object",
 "properties": {
"farmId":{
"type": "Text",
"description": "It represents the id of the Farm Entity (the <farmId> contained in the EntityId)"
 },
"type":{
"type": "Text",
"value": "Farm",
"description": "Entity Type"
 },
 "address": {
 "type": "Text",
 "description": "It represents the address of the farm",
 "metadata":{}
 },
 "name": {
 "type": "Text",
 "description": "It represents the name of the farm",
 "metadata":{}
 },
 "ownerCompany": {
 "type": "Text",
 "description": "It represents the name of the company that owns the farm",
 "metadata":{}
 }
 }
}
```
```json
{
"farmId":"urn:entity:farm:<farmID>",
"type":"Farm",
"address":"La Cañada 04120 Almería Spain",
"name":"Greenhouse agriculture",
"ownerCompany":"Maria"
}
```

#### Building Entity

```json
{
 "$id": "https://resl.com/farm.schema.json",
 "$schema": "http://json-schema.org/draft-07/schema#",
 "title": "Building",
 "type": "object",
 "properties": {
"buildingId":{
"type": "Text",
"description": "It represents the id of the Building Entity (the <buildingId> contained in the
EntityId attribute)"
 },
"type":{
"type": "Text",
"value": "Building",
"description": "Entity Type"
 },
 "name": {
 "type": "Text",
 "description": "It represents the name of the building",
 "metadata":{}
 },
 "lastUpdate": {
 "type": "DateTime",
 "description": "It represents the timestamp of the last update",
 "metadata":{}
 },
 "farmId": {
 "type": "Text",
 "description": "It represents the id of the Farm in which the Building is located (the farmId)",
 "metadata":{}
 },
 "temperature": {
 "type": "Float",
 "description": "It represents the last value of the temperature registered within the Building",
 "metadata":{
 "uom": {
 "type": "string",
 "value": "http://ontology.fiesta-iot.eu/ontologyDocs/m3-lite.owl#DegreeCelsius"
 }
 }
 },
 "humidity": {
 "type": "Float",
 "description": "It represents the last value of the humidity registered within the Building",
 "metadata":{
 "uom": {
 "type": "string",
 "value": "http://ontology.fiesta-iot.eu/ontologyDocs/m3-lite.owl#Humidity"
 }
 }
 },
 "luminosity": {
 "type": "Float",
 "description": "It represents the last value of the luminosity registered within the Building",
 "metadata":{
 "uom": {
 "type": "string",
 "value": "http://ontology.fiesta-iot.eu/ontologyDocs/m3-lite.owl#LuminousIntensity"
 }
 }
 }
 }
}
```

```json
{
"buildingId":"urn:entity:building:<buildingId>",
"type":"Building",
"name":{
 "type": "Text",
 "value": "La Cañada 04120 Almería Spain",
 "metadata": {}
 },
"lastUpdate":{
 "type": "ISO8601",
 "value": "2018-08-22T05:10:58.00Z",
 "metadata": {}
 },
"farmId":"urn:entity:farm:<farmID>",
"temperature":{
 "type": "Float",
 "value": 37.6,
 "metadata": {
"uom": {
 "type": "string",
 "value": "http://ontology.fiesta-iot.eu/ontologyDocs/m3-lite.owl#DegreeCelsius"
}
}
 },
"humidity":{
 "type": "Float",
 "value": 45,
 "metadata": {
"uom": {
 "type": "string",
 "value": "http://ontology.fiesta-iot.eu/ontologyDocs/m3-lite.owl#Humidity"
}
}
 },
"luminosity":{
 "type": "Float",
 "value": 0.6,
 "metadata": {
"uom": {
 "type": "string",
 "value": "http://ontology.fiesta-iot.eu/ontologyDocs/m3-lite.owl#LuminousIntensity"
}
}
 }
}
```

### Pen Entity

```json
{
 "$id": "https://resl.com/farm.schema.json",
 "$schema": "http://json-schema.org/draft-07/schema#",
 "title": "Pig",
 "type": "object",
 "properties": {
"pigId":{
"type": "Text",
"description": "It represents the id of the Pig Entity (the <pigId> contained in the EntityId
attribute)"
 },
"type":{
"type": "Text",
"value": "Pig",
"description": "Entity Type"
 },
 "serialNumber": {
 "type": "Text",
 "description": "If a serial number is assigned to the pig by the farm, this field contains such a value",
 "metadata":{}
 },
 "lastUpdate": {
 "type": "DateTime",
 "description": "It represents the timestamp of the last update",
 "metadata":{}
 },
 "penId": {
 "type": "Text",
 "description": "It represents the id of the Farm in which the pen is located (the penId)",
 "metadata":{}
 },
 "weight": {
 "type": "Float",
 "description": "It represents the current weight of the pig (the last measured value)",
 "metadata":{
 "uom": {
 "type": "string",
 "value": "http://ontology.fiesta-iot.eu/ontologyDocs/m3-lite.owl#Kilogram"
 }
 }
 },
 "totalConsumedWater": {
 "type": "Float",
 "description": "it represents the amount of water that was consumed between the moment in
which the pig started to drink and the current moment (e.g., if the
pig started
to drink 2 minutes ago and is continuing to drink, this value
contains the
total amount of water that the pig drunk since 2 minutes ago)",
 "metadata":{
 "uom": {
 "type": "string",
 "value": "http://ontology.fiesta-iot.eu/ontologyDocs/m3-lite.owl#Litre"
 }
 }
 },
 "totalConsumedFood": {
 "type": "Float",
 "description": "it represents the amount of food that was consumed between the moment
in which the pig started to eat and the current moment
(e.g., if the
pig started to eat 2 minutes ago and is continuing to eat,
this value
contains the total amount of food that the pig ate since 2
minutes ago)",
 "metadata":{
 "uom": {
 "type": "string",
 "value": "http://ontology.fiesta-iot.eu/ontologyDocs/m3-lite.owl#Kilogram"
 }
 }
 }
 }
}
{
"pigId":"urn:entity:pig:<pigId>",
"type":"Pig",
"serialNumber":{
 "type": "Text",
 "value": "8764321000003",
 "metadata": {}
 },
"lastUpdate":{
 "type": "ISO8601",
 "value": "2018-08-22T05:10:58.00Z",
 "metadata": {}
 },
"penId":"urn:entity:pen:<penId>",
"weight":{
 "type": "Float",
 "value": 37.6,
 "metadata": {
"uom": {
 "type": "string",
 "value": "http://ontology.fiesta-iot.eu/ontologyDocs/m3-lite.owl#Kilogram"
}
}
 },
"totalConsumedWater":{
 "type": "Float",
 "value": 20,
 "metadata": {
"uom": {
 "type": "string",
 "value": "http://ontology.fiesta-iot.eu/ontologyDocs/m3-lite.owl#Litre"
}
}
 },
"totalConsumedFood":{
 "type": "Float",
 "value": 45,
 "metadata": {
"uom": {
 "type": "string",
 "value": "http://ontology.fiesta-iot.eu/ontologyDocs/m3-lite.owl#Kilogram"
}
}
 }
}
Pig Entity
{
 "$id": "https://resl.com/farm.schema.json",
 "$schema": "http://json-schema.org/draft-07/schema#",
 "title": "Pig",
 "type": "object",
 "properties": {
"pigId":{
"type": "Text",
"description": "It represents the id of the Pig Entity (the <pigId> contained in the EntityId
attribute)"
 },
"type":{
"type": "Text",
"value": "Pig",
"description": "Entity Type"
 },
 "serialNumber": {
 "type": "Text",
 "description": "If a serial number is assigned to the pig by the farm, this field contains such a value",
 "metadata":{}
 },
 "lastUpdate": {
 "type": "DateTime",
 "description": "It represents the timestamp of the last update",
 "metadata":{}
 },
 "penId": {
 "type": "Text",
 "description": "It represents the id of the Farm in which the pen is located (the penId)",
 "metadata":{}
 },
 "weight": {
 "type": "Float",
 "description": "It represents the current weight of the pig (the last measured value)",
 "metadata":{
 "uom": {
 "type": "string",
 "value": "http://ontology.fiesta-iot.eu/ontologyDocs/m3-lite.owl#Kilogram"
 }
 }
 },
 "totalConsumedWater": {
 "type": "Float",
 "description": "it represents the amount of water that was consumed between the moment in
which the pig started to drink and the current moment (e.g., if the
pig started
to drink 2 minutes ago and is continuing to drink, this value
contains the
total amount of water that the pig drunk since 2 minutes ago)",
 "metadata":{
 "uom": {
 "type": "string",
 "value": "http://ontology.fiesta-iot.eu/ontologyDocs/m3-lite.owl#Litre"
 }
 }
 },
 "totalConsumedFood": {
 "type": "Float",
 "description": "it represents the amount of food that was consumed between the moment
in which the pig started to eat and the current moment
(e.g., if the
pig started to eat 2 minutes ago and is continuing to eat,
this value
contains the total amount of food that the pig ate since 2
minutes ago)",
 "metadata":{
 "uom": {
 "type": "string",
 "value": "http://ontology.fiesta-iot.eu/ontologyDocs/m3-lite.owl#Kilogram"
 }
 }
 }
 }
}
{
"pigId":"urn:entity:pig:<pigId>",
"type":"Pig",
"serialNumber":{
 "type": "Text",
 "value": "8764321000003",
 "metadata": {}
 },
"lastUpdate":{
 "type": "ISO8601",
 "value": "2018-08-22T05:10:58.00Z",
 "metadata": {}
 },
"penId":"urn:entity:pen:<penId>",
"weight":{
 "type": "Float",
 "value": 37.6,
 "metadata": {
"uom": {
 "type": "string",
 "value": "http://ontology.fiesta-iot.eu/ontologyDocs/m3-lite.owl#Kilogram"
}
}
 },
"totalConsumedWater":{
 "type": "Float",
 "value": 20,
 "metadata": {
"uom": {
 "type": "string",
 "value": "http://ontology.fiesta-iot.eu/ontologyDocs/m3-lite.owl#Litre"
}
}
 },
"totalConsumedFood":{
 "type": "Float",
 "value": 45,
 "metadata": {
"uom": {
 "type": "string",
 "value": "http://ontology.fiesta-iot.eu/ontologyDocs/m3-lite.owl#Kilogram"
}
}
 }
}

#### Slaughteredpig Entity

```json
{
 "$id": "https://resl.com/farm.schema.json",
 "$schema": "http://json-schema.org/draft-07/schema#",
 "title": "SlaughteredPig",
 "type": "object",
 "properties": {
"lastSlaughteredPigId":{
"type": "Text",
"description": "It represents the id of the last Pig that was slaughtered"
 },
"type":{
"type": "Text",
"value": "SlaughteredPig",
"description": "Entity Type"
 },
 "serialNumber": {
 "type": "Text",
 "description": "It represents the serialNumber (if it exists) of the last Pig that was slaughtered",
 "metadata":{}
 },
 "lastUpdate": {
 "type": "DateTime",
 "description": "It represents the timestamp of the last update",
 "metadata":{}
 },
 "slaughterhouseId": {
 "type": "Text",
 "description": "It represents the id of the slaughterehouse in which the Pig was slaughtered",
 "metadata":{}
 }
 }
}
{
"lastSlaughteredPigId":"urn:entity:pig:<pigId>",
"type":"Pig",
"serialNumber":{
 "type": "Text",
 "value": "8764321000003",
 "metadata": {}
 },
"lastUpdate":{
 "type": "ISO8601",
 "value": "2018-08-22T05:10:58.00Z",
 "metadata": {}
 },
"slaughterhouseId":"urn:entity:slaughterhouse:<slaughterhouseId>",
}
Slaughterhouse Entity
{
 "$id": "https://resl.com/farm.schema.json",
 "$schema": "http://json-schema.org/draft-07/schema#",
 "title": "slaughterhouse",
 "type": "object",
 "properties": {
"slaughterhouseId":{
"type": "Text",
"description": "it represents the id of the slaughterhouse Entity (the <slaughterhouseId>
contained in the EntityId attribute)"
 },
"type":{
"type": "Text",
"value": "Slaughterhouse",
"description": "Entity Type"
 },
"address:": {
 "type": "Text",
 "description": "It represents the address of the slaughterhouse",
 "metadata":{}
 },
"name": {
 "type": "Text",
 "description": "It represents the name of the building",
 "metadata":{}
 }
 }
}
{
"slaughterhouseId":"urn:entity:slaughterhouse:<slaughterhouseId>",
"type":"Slaughterhouse",
"address":{
 "type": "Text",
 "value": "La Cañada 04120 Almería Spain",
 "metadata": {}
 },
"name":{
 "type": "Text",
 "value": "pig slaughterhouse",
 "metadata": {}
 }
}
```

#### Entity List

```json
{
 "$id": "https://resl.com/farm.schema.json",
 "$schema": "http://json-schema.org/draft-07/schema#",
 "title": "EntityList",
 "type": "object",
 "properties": {
"list":{
"type": "array",
"maxItems": 3,
"items": {
 "type": "string"
 }
},
"type":{
"type": "Text",
"value": "EntityList",
"description": "Entity Type"
 },
"lastUpdate": {
 "type": "DateTime",
 "description": "It represents the timestamp of the last update",
 "metadata":{}
 },
"lastAddedItem": {
 "type": "Text",
 "description": "It contains the <id> of the last added <Entity> entity",
 "metadata":{}
 },
"lastRemovedItem": {
 "type": "Text",
 "description": "It contains the <id> of the last removed <Entity> entity",
 "metadata":{}
 }
 }
}
{
"list":["urn:entity:pen:<penId1>", "urn:entity:pen:<penId2>", "urn:entity:pen:<penId3>"],
"type":"EntityList",
"lastUpdate":{
 "type": "ISO8601",
 "value": "2018-08-22T05:10:58.00Z",
 "metadata": {}
 },
"lastAddedItem":{
 "type": "Text",
 "value": "urn:entity:pen:<penId3>",
 "metadata": {}
 },
"lastRemovedItem":{
 "type": "Text",
 "value": "urn:entity:pen:<penId0>",
 "metadata": {}
 }
}
```
EPCIS data model schema for farm
On progress ….