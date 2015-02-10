package metier;

import java.io.File;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class ControllerXml {
	
	public void validateAndDecod(String from, String xml){
		ModelUser user = new ModelUser();
		user.setId("Muthu");
		
		ModelStateMachine sm = new ModelStateMachine(1, "statemachine1", user);
		new ControllerPublisher().sendMessage("persistance", xml);
	/*try {
		//File file = new File("C:\\file.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(ModelStateMachine.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		
		StringWriter sw = new StringWriter();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		//jaxbMarshaller.marshal(sm, file);
		jaxbMarshaller.marshal(sm, sw);
		System.out.println(sw.toString());
		new ControllerPublisher().sendMessage("persistance", sw.toString());
		
		
	} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		
	}

}
