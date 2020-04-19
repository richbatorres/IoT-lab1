package lab1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapHandler;
import org.eclipse.californium.core.CoapObserveRelation;
import org.eclipse.californium.core.CoapResponse;

public class CoAPClient3 {

	public static void main(String[] args) {
		
		CoapClient client = new CoapClient("coap://localhost/sensors/temp").useCONs();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("OBSERVE (press enter to exit)");
		
		CoapObserveRelation relation = client.observe(
				new CoapHandler() {
					public void onLoad(CoapResponse response) {
						String content = response.getResponseText();
						System.out.println("NOTIFICATION: " + content);
					}
					
					public void onError() {
						System.err.println("OBSERVING FAILED (press enter to exit)");
					}
				});
		
		// wait for user
		try { br.readLine(); } catch (IOException e) { }
		
		System.out.println("CANCELLATION");
		
		relation.proactiveCancel();

	}

}
