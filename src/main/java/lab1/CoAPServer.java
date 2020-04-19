package lab1;

import java.nio.file.Paths;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.CoapServer;
import org.eclipse.californium.core.coap.CoAP.ResponseCode;
import org.eclipse.californium.core.server.resources.CoapExchange;

public class CoAPServer {

	public static void main(String[] args) {
		// binds on UDP port 5683
        CoapServer server = new CoapServer();
        
//        server.add(new SensorResource("sensors"));
        server.add(new LongFile("zad6"));
        
        
        
//        server.add(new SomeRandomResource());
//        CoapResource path = new CoapResource("putanja");
//        path.add(new AnotherResource());
//        server.add(path);
//        server.add(new RemovableResource(), new TimeResource(), new WritableResource());
        
        server.start();

	}

//	public static class SomeRandomResource extends CoapResource{
//
//		public SomeRandomResource() {
//			super("First");
//			getAttributes().setTitle("First resource");
//		}
//		
//		@Override
//		public void handleGET(CoapExchange exchange) {
//			// TODO Auto-generated method stub
////			super.handleGET(exchange);
//			exchange.respond("You got it");
//		}
//		
//	}
//	
//	public static class AnotherResource extends CoapResource {
//        public AnotherResource() {
//
//            // resource identifier
//            super("Another");
//
//            // set display name
//            getAttributes().setTitle("Another (Second) Resource");
//        }
//
//        @Override
//        public void handleGET(CoapExchange exchange) {
//            exchange.respond(getPath());
//        }
//    }
//
//    public static class RemovableResource extends CoapResource {
//        public RemovableResource() {
//            super("removeme");
//        }
//        @Override
//        public void handleDELETE(CoapExchange exchange) {
//        	// TODO Auto-generated method stub
//        	delete();
//        	exchange.respond(ResponseCode.DELETED);
//        }
//        
//        @Override
//        public void handleGET(CoapExchange exchange) {
//        	exchange.respond("still here bitch");
//        }
//    }
//
//    public static class TimeResource extends CoapResource {
//
//        public TimeResource() {
//            super("time");
//        }
//        @Override
//        public void handleGET(CoapExchange exchange) {
//        	// TODO Auto-generated method stub
//        	exchange.respond(String.valueOf(java.time.LocalTime.now().getSecond()));
//        }
//    }
//
//    public static class WritableResource extends CoapResource {
//
//        public String value = "to be replaced";
//
//        public WritableResource() {
//            super("writeme!");
//        }
//
//        @Override
//        public void handleGET(CoapExchange exchange) {
//            exchange.respond(value);
//        }
//        
//        @Override
//        public void handlePUT(CoapExchange exchange) {
//        	byte[] payload = exchange.getRequestPayload();
//        	
//        	try {
//				value = new String(payload, "UTF-8");
//				exchange.respond(ResponseCode.CHANGED, value);
//			} catch (Exception e) {
//				e.printStackTrace();
//                exchange.respond(ResponseCode.BAD_REQUEST, "Invalid String");
//			}
//        }
//
//    }
}
