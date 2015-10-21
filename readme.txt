http://www.java2blog.com/2013/04/create-restful-web-servicesjax-rs-using.html

Create RESTful web services in java(JAX-RS) using jersey

Java API for RESTful Web Services (JAX-RS), is a set if APIs to developer REST service. J
AX-RS is part of the Java EE6, and make developers to develop REST web application easily.

Jersey is the reference implementation for this specification. 
Jersey contains basically a REST server and a REST client. 
The core client can communicate with the server using jersey lib.

On the server side Jersey uses a servlet which scans predefined classes to identify RESTful resources. 
Via the web.xml configuration file for your web application.

---
1) Open eclipse. 2) Create new dynamic web project named "RESTfulWebServiceExample"
3) Now go to location where you have download jersey and go to jersey-archive-1.17->lib
folder. You can have all jars but for now you can copy following jars
asm-3.1
jersey-client-1.17
jersey-core-1.17
jersey-server-1.17
jersey-servlet-1.17
jsr311-api-1.1.1
Paste all above copied jars to WebContent->WEB-INF->lib
Add all these jars to eclipse build path.
4) Create new package named "org.arpit.javapostsforlearning.webservice"
5)Create  FeetToInchAndInchToFeetConversionService.java
6)Now you need to create web.xml and put it under /RESTfulWebserviceExample/WebContent/WEB-INF/
8) Run project:right click on project->run as ->run on server
9) Test your REST service under: "http://localhost:8080/RESTfulWebServiceExample/rest/ConversionService/FeetToInch/2"

-----------------------
The base URL of this servlet is:
http://your_domain:port/display-name/url-pattern/path_from_rest_class 

http://localhost:8080/InchFeetRestfulWS/rest/ConversionService/InchToFeet/2

<display-name>InchFeetRestfulWS</display-name>
 <url-pattern>/rest/*</url-pattern>
ConversionService = path_from_rest_class = 	@Path("ConversionService")  
	public class FeetToInchAndInchToFeetConversionService {  
InchToFeet/2:	
	 @GET  
	     @Path("/InchToFeet/{i}")  
	      @Produces(MediaType.TEXT_XML)  
	      public String convertInchToFeet(@PathParam("i") int i) {  
	      
This servlet analyzes the incoming HTTP request and selects the correct class and method depending on  request. 
This selection is based on annotations provided in the class and methods. 

@Path(/your_path_at_class_level) : Sets the path to base URL + /your_path_at_class_level. 
The base URL is based on your application name, the servlet and the URL pattern from the web.xml" configuration file.

@Path(/your_path_at_method_level): Sets path to base URL + /your_path_at_class_level+ /your_path_at_method_level

@Produces(MediaType.TEXT_XML [, more-types ]): @Produces defines which MIME type is delivered by a method annotated with @GET. 
In the example text ("text/XML") is produced.

@PathParam: Used to inject values from the URL into a method parameter.
This way you inject inch in convertFeetToInch method and convert that to feet.

6)Now you need to create web.xml and put it under /RESTfulWebserviceExample/WebContent/WEB-INF

==============
create client
Create ConversionServiceClient.java under org.arpit.javapostsforlearning.websevices.client

===

https://jersey.java.net/documentation/2.4.1/migration.html

https://jersey.java.net/documentation/1.19/client-api.html  (1.1)

https://jersey.java.net/documentation/latest/client.html

