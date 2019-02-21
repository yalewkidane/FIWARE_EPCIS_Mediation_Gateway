package com.oliot.mediation.service.epcis;


public class Utility {
	
	
	public static String coordinta_sgln_converter(Double lati, Double longt) {
		String sgln="urn:epc:id:sgtin:88000269.0001.";
		if(lati>0) {
			sgln+="1";
			String[] latitude=lati.toString().split("\\.");
			if(latitude[0].length()==1) {
				latitude[0]="00"+latitude[0];
			}else if(latitude[0].length()==2) {
				latitude[0]="0"+latitude[0];
			}
			sgln+=latitude[0]+latitude[1];
		}else {
			sgln+="0";
			String[] latitude=lati.toString().split("\\.");
			latitude[0]=latitude[0].substring(1, latitude[0].length());
			if(latitude[0].length()==1) {
				latitude[0]="00"+latitude[0];
			}else if(latitude[0].length()==2) {
				latitude[0]="0"+latitude[0];
			}
			sgln+=latitude[0]+latitude[1];
		}
		
		if(longt>0) {
			sgln+="1";
			String[] longtiud=longt.toString().split("\\.");
			if(longtiud[0].length()==1) {
				longtiud[0]="00"+longtiud[0];
			}else if(longtiud[0].length()==2) {
				longtiud[0]="0"+longtiud[0];
			}
			sgln+=longtiud[0]+longtiud[1];
		}else {
			sgln+="0";
			String[] longtiud=longt.toString().split("\\.");
			longtiud[0]=longtiud[0].substring(1, longtiud[0].length());
			if(longtiud[0].length()==1) {
				longtiud[0]="00"+longtiud[0];
			}else if(longtiud[0].length()==2) {
				longtiud[0]="0"+longtiud[0];
			}
			sgln+=longtiud[0]+longtiud[1];
		}
		
		
		return sgln;
	}

}
