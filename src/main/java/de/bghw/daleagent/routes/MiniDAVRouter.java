package de.bghw.daleagent.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.zipkin.ZipkinTracer;
import org.springframework.stereotype.Component;

@Component
public class MiniDAVRouter extends RouteBuilder {

	private ZipkinTracer zipkin = new ZipkinTracer();

	private void configureZipkin() {
		// create zipkin
		zipkin.setEndpoint("http://localhost:9411/api/v2/spans");
		// set the service name
		zipkin.setServiceName("MiniDAVRouter");
		// capture 100% of all the events
		zipkin.setRate(1.0f);
		
		// include message bodies in the traces (not recommended for production)
		zipkin.setIncludeMessageBodyStreams(true);
		// add zipkin to CamelContext
		zipkin.init(getContext());
	}

	@Override
	public void configure() throws Exception {
		// Zipkin zum Camelcontext verbinden
		configureZipkin();
	    
	    // Route 1 :Dokumente einlesen und in Queue ablegen
//		from("file:input?delay=1000").id("minidav").
//		process(new Processor() {
//			@Override
//			public void process(Exchange exchange) throws Exception {
//				System.out.println("Dokument angenommen");
//			}
//		}).
//		to("file:output").to("jms:queue:daledokument?requestTimeout=30s");
//		
//
//		// Route 2: Dokumente aus der Queue holen, verarbeiten
//		from("jms:queue:daledokument").
//		process(new Processor() {
//			@Override
//			public void process(Exchange exchange) throws Exception {
//				System.out.println("Dokumentverarbeitung gestartet");
//			}
//		});
		
	}

}
