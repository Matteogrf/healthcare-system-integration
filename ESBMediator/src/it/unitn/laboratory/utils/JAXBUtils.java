package it.unitn.laboratory.utils;

import it.unitn.laboratory.mappedData.DwhSchemaType;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;

public class JAXBUtils {
	
	public static DwhSchemaType getDWHClassesFromXML(Source xml){
		try {
			
			JAXBContext jc = JAXBContext.newInstance( "it.unitn.laboratory.mappedData" );
			Unmarshaller u = jc.createUnmarshaller();
			
			JAXBElement<DwhSchemaType> root = u.unmarshal(xml, DwhSchemaType.class);		
			
			DwhSchemaType dwh= root.getValue();

			
			return dwh;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

}
