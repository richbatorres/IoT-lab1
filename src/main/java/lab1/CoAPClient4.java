package lab1;

import java.io.IOException;

import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.core.coap.MediaTypeRegistry;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.elements.exception.ConnectorException;
import org.eclipse.californium.core.coap.CoAP.Code;

public class CoAPClient4 {

	public static void main(String[] args) {
		CoapClient client = new CoapClient("coap://localhost/zad6").useCONs();
		Request req = new Request(Code.GET);
		req.getOptions().setContentFormat(MediaTypeRegistry.APPLICATION_OCTET_STREAM);
		
		CoapResponse response;
		try {
			response = client.advanced(req);

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
