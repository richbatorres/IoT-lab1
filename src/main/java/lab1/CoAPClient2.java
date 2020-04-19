package lab1;

import java.io.IOException;

import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.core.coap.MediaTypeRegistry;
import org.eclipse.californium.elements.exception.ConnectorException;

public class CoAPClient2 {

	public static void main(String[] args) {
		CoapClient client1 = new CoapClient("coap://localhost/sensors").useCONs();
		
		try {
			//CoapResponse response = client.put("ya faken did it", MediaTypeRegistry.TEXT_PLAIN);
//			CoapResponse response = client.get();
//			CoapResponse response = client.delete();
			CoapResponse response = client1.post("temp", MediaTypeRegistry.TEXT_PLAIN);
			
			System.out.println(response.getCode());
			System.out.println(response.getOptions());
			System.out.println(response.getResponseText());
			
			
//			CoapClient client2 = new CoapClient("coap://localhost/sensors/temp").useCONs();
//			response = client2.get();
//			
//			System.out.println(response.getCode());
//			System.out.println(response.getOptions());
//			System.out.println(response.getResponseText());
			
		} catch (ConnectorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
