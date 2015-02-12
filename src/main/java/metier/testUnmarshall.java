package metier;

import generatedClasses.Scxml;
import generatedClasses.State;
import generatedClasses.Transition;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class testUnmarshall {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try {
			 
				File file = new File("src/xsd/SCXML_presentation.xml");
				JAXBContext jaxbContext = JAXBContext.newInstance(Scxml.class);
		 
				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				Scxml scxml = (Scxml) jaxbUnmarshaller.unmarshal(file);
				System.out.println("contient: " + scxml.getState().size() +" états\n");
				System.out.println(scxml.getState().get(0).getId() + " et " + scxml.getState().get(1).getId());
				Transition transition = (Transition) scxml.getState().get(0).getOnentryOrInvokeOrTransition().get(0);
				State state = (State) transition.getTarget();
				System.out.println(transition.getEvent() +" " + state.getId());
				
				
		 
			  } catch (JAXBException e) {
				e.printStackTrace();
				
			  }

	}

}
