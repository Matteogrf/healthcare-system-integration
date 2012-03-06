package it.unitn.laboratory.utils;

import java.io.FileInputStream;
import java.io.InputStream;

import it.unitn.laboratory.mappedData.DwhSchemaType;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class JAXBUtils {
	
	public static DwhSchemaType getDWHClassesFromXML(InputStream xml){
		try {
			
			JAXBContext jc = JAXBContext.newInstance( "it.unitn.laboratory.mappedData" );
			Unmarshaller u = jc.createUnmarshaller();
			DwhSchemaType dwh = (DwhSchemaType)u.unmarshal(xml);
			
			return dwh;
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

}
