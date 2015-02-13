package metier;


import generatedClasses.*;

import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class ControllerXml {
	
	public void decodeAndSendXML(String from, String xml){
		
		
		
		Scxml scxml = new Scxml();
		State state = new State();
		state.setId("s1");
		scxml.setInitialstate(state);
		
		//ModelStateMachine sm = new ModelStateMachine(1, "statemachine1", user);
		//new ControllerPublisher().sendMessage("persistance", xml);
	try {
		//File file = new File("C:\\file.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Scxml.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		
		StringWriter sw = new StringWriter();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbMarshaller.marshal(scxml, sw);
		
		/*QName qName = new QName("test.pds.namespace", "user");
		JAXBElement<Scxml> root = new JAXBElement<Scxml>(qName, Scxml.class, scxml);
        jaxbMarshaller.marshal(root, sw);*/
        
		//jaxbMarshaller.marshal(user, sw);
		//System.out.println(sw.toString());
        
		new ControllerPublisher().sendMessage("persistance", sw.toString());
		
		
	} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public void encodeXml(String xml){
		
		 try {
			 
				//File file = new File("src/xsd/SCXML_presentation.xml");
				JAXBContext jaxbContext = JAXBContext.newInstance(Scxml.class);
		 
				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				// using xmlStreamReader in the place of File  
				Scxml scxml = (Scxml) jaxbUnmarshaller.unmarshal(convertStringtoXMLStreamReader(xml));
				
				System.out.println("contient: " + scxml.getState().size() +" états\n");
				System.out.println(scxml.getState().get(0).getId() + " et " + scxml.getState().get(1).getId());
				Transition transition = (Transition) scxml.getState().get(0).getOnentryOrInvokeOrTransition().get(0);
				State state = (State) transition.getTarget();
				System.out.println(transition.getEvent() +" " + state.getId());
				
				
		 
			  } catch (JAXBException e) {
				e.printStackTrace();
				
			  } catch (XMLStreamException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	
	public XMLStreamReader convertStringtoXMLStreamReader(final String xmlContent) throws XMLStreamException {
		
	    final XMLInputFactory inputFactory = XMLInputFactory.newInstance();
	    final StringReader reader = new StringReader(xmlContent);
	    return inputFactory.createXMLStreamReader(reader);
	}

}
