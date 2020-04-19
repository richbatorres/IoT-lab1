package lab1;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.coap.CoAP.ResponseCode;
import org.eclipse.californium.core.coap.CoAP.Type;
import org.eclipse.californium.core.server.resources.CoapExchange;

public class SensorResource extends CoapResource{
	
	Random r = new Random();
	private int temperature;

	public SensorResource(String name) {
		super(name);
		setObservable(true); // enable observing
		setObserveType(Type.CON); // configure the notification type to CONs
		getAttributes().setObservable(); // mark observable in the Link-Format 
		
		this.temperature = r.nextInt((40 - 0) + 1);
		
		Timer timer = new Timer();
		timer.schedule(new UpdateTask(), 0, 1000);
		
	}
	
	private class UpdateTask extends TimerTask {
		@Override
		public void run() {
			temperature = r.nextInt((40 - 0) + 1);
			changed(); // notify all observers
		}
	}
	
	@Override
	public void handlePOST(CoapExchange exchange) {
		String resourceName = exchange.getRequestText();
		SensorResource childResource = new SensorResource(resourceName);
		this.add(childResource);
		childResource.setPath("/" + childResource.getParent().getName() + "/");
		exchange.respond(ResponseCode.CREATED);
	}
	
//	@Override
//	public void handleGET(CoapExchange exchange) {
//		exchange.respond(ResponseCode.METHOD_NOT_ALLOWED);
//	}
	
	@Override
	public void handleGET(CoapExchange exchange) {
		exchange.accept();
		
		exchange.setMaxAge(1);
		exchange.respond(String.valueOf(temperature));
	}
}
