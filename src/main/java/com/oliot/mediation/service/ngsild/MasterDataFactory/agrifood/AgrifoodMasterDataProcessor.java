package com.oliot.mediation.service.ngsild.MasterDataFactory.agrifood;

import java.util.List;

import org.gs1.epcglobal.epcis.VocabularyType;

import com.oliot.mediation.service.epcis.CaptureUtility;
import com.oliot.mediation.service.epcis.MasterDataManager;
import com.oliot.mediation.service.ngsild.eventFactory.agrifood.AgrifoodConvertUtility;
import com.oliot.model.ngsi_ld.Agrifood.Animal;

public class AgrifoodMasterDataProcessor extends MasterDataManager{
	
	
	public String animalMasterData(List<Animal> animals) {
		String result="Staus";
		if(animals!=null) {
			VocabularyType vocabulary = new  VocabularyType();
			vocabulary = AgrifoodConvertUtility.animalMasterDataTranslate(animals);
			this.voc=vocabulary;
		}
		
		headerModeling();
		marshaller.make(sbdh, voc);
		String epcdoc = marshaller.marshal();
		int status=CaptureUtility.registerEPCIS(epcdoc);
		System.out.println(epcdoc);
		result="status..." +status;
		
		return result;
		
	}

}
