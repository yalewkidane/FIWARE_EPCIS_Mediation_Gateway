## FIWARE server

Use the following page to  install FIWARE

https://github.com/telefonicaid/fiware-orion/blob/master/doc/manuals/admin/yum.md

## EPCIS server
- Option 1:
    -  Make sure you have installed mongodb/mysql whichever you are using
    -  Download epcis war file from [here](https://github.com/yalewkidane/FIWARE_EPCIS_Mediation_Gateway/tree/master/targ
et)
    -  Download the apache tomcat 8 from here https://tomcat.apache.org
    -  After extracting the apache tomcat file put the epcis war file in to
`path/to/your_tomcat_download/apache-tomact-8.x.xx/` webapps
    -  For Linux On terminal go `path/to/your_tomcat_download/apache-tomact-8.x.xx/bin/`
    -  For Linux 
    ```bash
      sh ./catalina.sh run
    ```
    -  [for Window] use `.bat` file
- Option 2:
    -  Follow the instruction the original EPCIS [GitHub](https://github.com/JaewookByun/epcis
)

## Mediation gateway server

### Status of FIWARE to  EPCIS mediation gateway

-  Current implementation only include test models (Car and Room) and Pig farming
-  In the near future a more general translation module will be introduced
-  Anyone interested in other data models can follow the same principle used in farm model
implementation to  extend to  other domains
