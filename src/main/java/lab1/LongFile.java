package lab1;

import java.util.Random;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.coap.CoAP.ResponseCode;
import org.eclipse.californium.core.coap.MediaTypeRegistry;
import org.eclipse.californium.core.coap.Response;
import org.eclipse.californium.core.server.resources.CoapExchange;

public class LongFile extends CoapResource{

	byte[] file = new byte[2048];
	
	public LongFile(String name) {
		super(name);		
		getAttributes().addContentType(MediaTypeRegistry.APPLICATION_OCTET_STREAM);
		
		new Random().nextBytes(file);
	}

	@Override
	public void handleGET(CoapExchange exchange) {
		if (exchange.getRequestOptions().getContentFormat() != MediaTypeRegistry.APPLICATION_OCTET_STREAM) {
			exchange.respond(ResponseCode.NOT_ACCEPTABLE);
			return;
		}
		
		Response response = new Response(ResponseCode.CONTENT);
		response.setPayload(file);
		response.getOptions().setContentFormat(MediaTypeRegistry.APPLICATION_OCTET_STREAM);

		exchange.respond(response);
	}
}
