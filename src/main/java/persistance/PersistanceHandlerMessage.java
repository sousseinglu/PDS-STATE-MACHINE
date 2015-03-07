package persistance;

import generatedClasses.Scxml;

import javax.jms.TextMessage;
import javax.xml.bind.*;
import javax.xml.stream.*;

import java.io.*;
import java.util.*;

// Classe gérant le message au niveau de la persistance 
public class PersistanceHandlerMessage {
	private Scxml scxml;

	@SuppressWarnings("deprecation")
	public PersistanceHandlerMessage(TextMessage textMessage){
		try {
			Reader reader = new StringReader(textMessage.toString());
			XMLInputFactory factory = XMLInputFactory.newInstance();
			XMLStreamReader xmlReader = factory.createXMLStreamReader(reader);
			JAXBContext jc = JAXBContext.newInstance(Scxml.class);
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			
		 scxml = (Scxml) unmarshaller.unmarshal(xmlReader);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Scxml getScxml() {
		return scxml;
	}

	public void setScxml(Scxml scxml) {
		this.scxml = scxml;
	}
	
}


