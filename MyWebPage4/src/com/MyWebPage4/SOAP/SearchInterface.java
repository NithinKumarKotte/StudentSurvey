//The following class is an Sevice endpoint interface and gives abstract Web service method SearchRecord(). 
//Abstract method is implement in Webservice interface class StudentModel()

package com.MyWebPage4.SOAP;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

//Service Endpoint Interface
@WebService
@SOAPBinding(style = Style.RPC)
public interface SearchInterface{

	@WebMethod public ArrayList<ArrayList<String>>  SearchRecord(String Firstname,String LastName,String City, String State);

}