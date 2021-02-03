package com.mtp.demo.app;

import org.apache.camel.Exchange;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.spring.SpringRouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class SimpleRoute extends SpringRouteBuilder {

	@Override
	public void configure() throws Exception {
		
		restConfiguration().component("servlet").bindingMode(RestBindingMode.json).host("localhost")
        // and output using pretty print
        //.dataFormatProperty("prettyPrint", "true").
        // setup context path and port number that Apache Tomcat will deploy
        // this application with, as we use the servlet component, then we
        // need to aid Camel to tell it these details so Camel knows the url
        // to the REST services.
        // Notice: This is optional, but needed if the RestRegistry should
        // enlist accurate information. You can access the RestRegistry
        // from JMX at runtime
        .port(8080);
		
		rest().get("/camelTest")
		/*.produces(MediaType.APPLICATION_JSON_VALUE)
		.route().setBody(constant("Hi This is test"));*/
		.to("direct:ba1Info");
		
		from("direct:ba1Info")
	    .marshal().json(JsonLibrary.Jackson)
	    .setHeader("Content-Type", constant("application/json"))
	    .setHeader("Accept", constant("application/json"))
	    .setHeader(Exchange.HTTP_METHOD, constant("GET"))
	    .removeProperty("uri")
	    .removeHeader(Exchange.HTTP_URI)
	    .removeHeader(Exchange.HTTP_URL)
	    .removeHeader(Exchange.HTTP_BASE_URI)
	    .removeHeader(Exchange.HTTP_PATH)
	    .recipientList(simple("http://localhost:8083/getBA1Info"))
	    .unmarshal().json(JsonLibrary.Jackson);
		
		
		from("direct:ba2Info")
	    .marshal().json(JsonLibrary.Jackson)
	    .setHeader("Content-Type", constant("application/json"))
	    .setHeader("Accept", constant("application/json"))
	    .setHeader(Exchange.HTTP_METHOD, constant("GET"))
	    .removeProperty("uri")
	    .removeHeader(Exchange.HTTP_URI)
	    .removeHeader(Exchange.HTTP_URL)
	    .removeHeader(Exchange.HTTP_BASE_URI)
	    .removeHeader(Exchange.HTTP_PATH)
	    .recipientList(simple("http://localhost:8083/getBA2Info"))
	    .unmarshal().json(JsonLibrary.Jackson);
		
		
		/*
		 * from("direct:add") //.id("add-direct-route") .setHeader("id", simple("aa"))
		 * .setHeader(Exchange.HTTP_METHOD, simple("GET")).log("Calling BA1")
		 * .to("http://localhost:8083/getBA1Info").process();
		 * //from("{{simpleRoute.start}}").setHeader("name",simple("nene")).bean(
		 * "simpleProcessor").to("{{simpleRoute.end}}");
		 */	}

}
