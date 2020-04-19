package lab1;

import java.io.IOException;
import java.net.URI;

import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.core.coap.MediaTypeRegistry;
import org.eclipse.californium.elements.exception.ConnectorException;

public class CoAPClient1 {

	public static void main(String[] args) {
		CoapClient client = new CoapClient("coap://localhost/sensors/temp").useCONs();
//		CoapClient client = new CoapClient("coap://localhost/sensors/temp").useNONs();
		
		try {
			//CoapResponse response = client.put("ya faken did it", MediaTypeRegistry.TEXT_PLAIN);
			CoapResponse response = client.get();
//			CoapResponse response = client.delete();
			
			System.out.println(response.getCode());
			System.out.println(response.getOptions());
			System.out.println(response.getResponseText());
		} catch (ConnectorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
