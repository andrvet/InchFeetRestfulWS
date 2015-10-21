package com.inch2feet.ws.client;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;




public class ConversionServiceClient {  

    static final String REST_URI = "http://localhost:8080/InchFeetRestfulWS";  
    static final String INCH_TO_FEET = "/ConversionService/InchToFeet/";  
    static final String FEET_TO_INCH = "/ConversionService/FeetToInch/";  
  
    public static void main(String[] args) {  
  
        int inch=12;  
        int feet=2;  
  
        //https://jersey.java.net/documentation/2.4.1/migration.html
        /*
        24.4.2.1. Making a simple client request
        
        Jersey 1.x way:
        Client client = Client.create();
        WebResource webResource = client.resource(restURL).path("myresource/{param}");
        String result = webResource.pathParam("param", "value").get(String.class);
        
        JAX-RS 2.0 way:
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(restURL).path("myresource/{param}");
        String result = target.pathParam("param", "value").get(String.class);
        
*/
        //from jersy 1.7
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);  
        WebResource service = client.resource(REST_URI);  
        
//        Client client = ClientBuilder.newClient();
//        WebTarget target = client.target(REST_URI).path(INCH_TO_FEET+inch);
//        String result = target.path(INCH_TO_FEET).toString();
        
        WebResource addService = service.path("rest").path(INCH_TO_FEET+inch);  
        System.out.println("INCH_TO_FEET Response: " + getResponse(addService));  
        System.out.println("INCH_TO_FEET Output as XML: " + getOutputAsXML(addService));  
        System.out.println("---------------------------------------------------");  
  
        WebResource subService = service.path("rest").path(FEET_TO_INCH+feet);  
        System.out.println("FEET_TO_INCH Response: " + getResponse(subService));  
        System.out.println("FEET_TO_INCH Output as XML: " + getOutputAsXML(subService));  
        System.out.println("---------------------------------------------------");  
  
    }  
  
    private static String getResponse(WebResource service) {  
        return service.accept(MediaType.TEXT_XML).get(ClientResponse.class).toString();  
    }  
  
    private static String getOutputAsXML(WebResource service) {  
        return service.accept(MediaType.TEXT_XML).get(String.class);  
    }  
}  
