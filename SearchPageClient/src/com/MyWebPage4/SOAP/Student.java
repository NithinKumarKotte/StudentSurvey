package com.MyWebPage4.SOAP;
//Nithin Kumar Kotte G01035945
/* Following class is a managed bean which used handle fields of "SeachSurvey.xhtml". Along with this we have an action controller method known as "SearchRecord" 
* to instantiate web methods (i.e. SearchRecord) of  deployed Webservice "StudentModel" of project "MyWebPage4" */
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.xml.rpc.ServiceException;

@ManagedBean(name = "student")
@ApplicationScoped
public class Student implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String city;
	private String state;
	private ArrayList<ArrayList<String>> Totallist = new ArrayList<ArrayList<String>>();
	
	String[][] mylist;
	SearchInterface si;
	
	
	public ArrayList<ArrayList<String>> getTotallist() {
		return Totallist;
	}
	public void setTotallist(ArrayList<ArrayList<String>> totallist) {
		for (ArrayList<String> i : totallist) {
			this.Totallist.add(i);
		}
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
	public String SearchRecord(){
		this.Totallist.clear();
		 ArrayList<ArrayList<String>> finallist= new ArrayList<ArrayList<String>>();
		StudentModelServiceLocator se= new StudentModelServiceLocator();
		
		try {
			si = se.getStudentModelPort();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			mylist = si.searchRecord(getFirstName(),getLastName(),getCity(),getState());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<mylist.length;i++){
			ArrayList<String> list = new ArrayList<String>();
			for(int j=i;j<mylist[i].length;j++){
				list.add(mylist[i][j]);
			}
		finallist.add(list);	
		}
		setTotallist(finallist);
		return "SearchSurvey.xhtml";
		
	}
	
	

}
