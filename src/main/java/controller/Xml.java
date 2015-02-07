package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import model.StateMachine;
import model.User;

public class Xml {
	
	public void validateAndDecod(String from, String xml){
		User user = new User();
		user.setId("Muthu");
		
		StateMachine sm = new StateMachine(1, "statemachine1", user);
	try {
		File file = new File("C:\\file.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(StateMachine.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		
		StringWriter sw = new StringWriter();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbMarshaller.marshal(sm, file);
		jaxbMarshaller.marshal(sm, sw);
		System.out.println(sw.toString());
		new Publisher().sendMessage("persistance", sw.toString());
		
		
	} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
