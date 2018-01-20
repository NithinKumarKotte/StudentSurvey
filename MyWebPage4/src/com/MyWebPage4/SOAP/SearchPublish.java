package com.MyWebPage4.SOAP;
import javax.xml.ws.Endpoint;


public class SearchPublish {
	public static void main(String[] args) {
		Endpoint ep= Endpoint.create(new StudentModel());	
		   ep.publish("http://localhost:9999/Search");
 }
}
