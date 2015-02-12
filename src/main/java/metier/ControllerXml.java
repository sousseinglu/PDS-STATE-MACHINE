package metier;


import generatedClasses.*;

import java.io.File;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

public class ControllerXml {
	
	public void validateAndDecod(String from, String xml){
		
		
		
		ModelUser user = new ModelUser();
		user.setId("Muthu");
		user.setPassword("pass");
		
		//ModelStateMachine sm = new ModelStateMachine(1, "statemachine1", user);
		//new ControllerPublisher().sendMessage("persistance", xml);
	try {
		//File file = new File("C:\\file.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(ModelUser.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		
		StringWriter sw = new StringWriter();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		//jaxbMarshaller.marshal(sm, file);
		
		QName qName = new QName("test.pds.namespace", "user");
		JAXBElement<ModelUser> root = new JAXBElement<ModelUser>(qName, ModelUser.class, user);
        jaxbMarshaller.marshal(root, sw);
        
		//jaxbMarshaller.marshal(user, sw);
		//System.out.println(sw.toString());
		new ControllerPublisher().sendMessage("persistance", sw.toString());
		
		
	} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public void encodeXml(String xml){
		
	}

}
