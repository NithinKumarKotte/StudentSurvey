
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.UIViewRoot;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericEntity;
import javax.xml.bind.annotation.XmlRootElement;

import org.dom4j.datatype.DatatypeAttribute;
import org.hibernate.mapping.Component;
import org.primefaces.component.datatable.DataTable;

import com.MyWebPage4.SOAP.StudentModel;
import com.sun.faces.facelets.tag.jsf.core.ViewHandler;
import com.sun.org.apache.bcel.internal.generic.NEW;

//Nithin Kumar Kotte G01035945
/* Following class is a managed bean which used handle fields of "Surveyform.xhtml". Along with this we have an action controller method known as "Submitform" 
 * to instantiate methods of Business logic and perform navigation to desired page (i.e. WinnerAcknowledgement.xhtml or SimpleAcknowledgement.xhtml  
 * It contains autocomplete method and implemented <f:ajax> method for accessing dropdown and RestWebSevices respectively */

@ManagedBean(name = "student")
@ApplicationScoped
public class Student implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String streetAddress;
	private String city;
	private String state;
	private String zip;
	private String telephoneNumber;
	private String email;
	private Date date;
	private ArrayList<String> check;
	private HtmlDataTable datatable;

	public HtmlDataTable getDatatable() {
		return datatable;
	}

	public void setDatatable(HtmlDataTable datatable) {
		this.datatable = datatable;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {

		this.startdate = startdate;
	}

	private String radio;
	private String menu;
	private String raffle;
	private String comments;
	private Date startdate;

	private String[] menuitems = { "Very Likely", "Likely", "Unlikely" };

	private ArrayList<ArrayList<String>> Totallist = new ArrayList<ArrayList<String>>();
	private ArrayList<ArrayList<String>> Listofsurvey = new ArrayList<ArrayList<String>>();

	public ArrayList<ArrayList<String>> getListofsurvey() {
		return Listofsurvey;
	}

	public void setListofsurvey(ArrayList<ArrayList<String>> listofsurvey) {
		for (ArrayList<String> i : listofsurvey) {
			this.Listofsurvey.add(i);

		}
	}

	private Double[] stddevavg;

	static public int count = 0;

	public Double[] getStddevavg() {
		return stddevavg;
	}

	public void setStddevavg(Double[] stddevavg) {
		this.stddevavg = new Double[2];
		for (int i = 0; i < this.stddevavg.length; i++) {
			this.stddevavg[i] = stddevavg[i];

		}

	}

	public ArrayList<ArrayList<String>> getTotallist() {
		return Totallist;
	}

	public void setTotallist(ArrayList<ArrayList<String>> totallist) {

		for (ArrayList<String> i : totallist) {
			this.Totallist.add(i);

		}
	}

	public String getRaffle() {
		return raffle;
	}

	public void setRaffle(String raffle) {
		this.raffle = raffle;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public String getRadio() {
		return radio;
	}

	public void setRadio(String radio) {
		this.radio = radio;
	}

	public ArrayList<String> getCheck() {
		return check;
	}

	public void setCheck(ArrayList<String> check) {
		this.check = new ArrayList<String>();
		for (String i : check) {
			this.check.add(i);

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

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
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

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {

		if (Integer.parseInt(zip) == 2) {
			this.state = "trialstate";
			this.city = "trialcity";

		}
		this.zip = zip;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String Submitform() {
		
		String str="";
	//	String modelcheck="";
		SimpleDateFormat spf = new SimpleDateFormat("MM/dd/yyyy");

		Studentbusiness studentbusiness = new Studentbusiness();
		StudentModel studentModel=new StudentModel();
		
		String date = spf.format(getDate());
		String startdate = spf.format(getStartdate());
		
		for (String j : getCheck()) {
			str=str.concat(j);
			//str.concat(",");
		}
		System.out.println("checkstr &&&&&&&&&& "+str);
		studentbusiness.savefile(getFirstName(), getLastName(), getStreetAddress(), getCity(), getState(), getZip(),
				getTelephoneNumber(), getEmail(), date, startdate, getCheck(), getRadio(), getMenu(), getRaffle(),
				getComments());
		
		studentModel.createrecord(getFirstName(), getLastName(), getStreetAddress(), getCity(), getState(), getZip(),
				getTelephoneNumber(), getEmail(), date, startdate,str, getRadio(), getMenu(), getRaffle(),
				getComments());

		setTotallist(studentbusiness.Totallist);
		System.out.println("Totallist " + Totallist.get(0));
		setStddevavg(studentbusiness.rafflewinner(getRaffle()));
		Double[] result = studentbusiness.rafflewinner(getRaffle());

		if (result[0] >= 90) {

			return "WinnerAcknowledgement.xhtml";

		} else {

			return "SimpleAcknowledgement.xhtml";
		}
	}

	public List<String> autocmp(String menuprefix) {
		List<String> matches = new ArrayList<String>();
		for (int i = 0; i < menuitems.length; i++) {
			if (menuitems[i].toUpperCase().startsWith(menuprefix.toUpperCase())) {
				matches.add(menuitems[i]);
			}
		}
		return (matches);

	}

	public void ajaxEvent() {
		Client client = ClientBuilder.newClient();
		/*List<?> string = client.target("http://ec2-34-203-14-166.compute-1.amazonaws.com/MyWebPage3/Webresources/State").path("{zip}")
				.resolveTemplate("zip", getZip()).request().get(List.class);*/

		List<?> string = client.target("http://localhost:8080/MyWebPage4/Webresources/State").path("{zip}")
				.resolveTemplate("zip", getZip()).request().get(List.class);

		
	System.out.println("webservice :" + string);
	System.out.println("webservice1 :" + string);
	
		if((string==null) || (string==null) ){
			 setCity(""); 
			 setState("");
			
		}else{
			
			 setCity(string.get(0).toString()); 
			 setState(string.get(1).toString());
			
		}
	
	}
	
	
	public void validateBidAmount(FacesContext context,UIComponent component,Object value)
			throws ValidatorException {
		UIInput startComponent = (UIInput) component.getAttributes().get("date");
		Object startComponentValue = startComponent.getValue();
		System.out.println("date "+startComponentValue);
		
		Date surveydate = (Date) startComponentValue;
		Date semdate = (Date) value;
		if (semdate.before(surveydate)) {
			FacesMessage msg = new FacesMessage("",
					"Semester date must not be less than survey date ");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}

	}
	
	public String SearchRecord(){
		this.Totallist.clear();
		StudentModel studentModel=new StudentModel();
		setTotallist(studentModel.SearchRecord(getFirstName(),getLastName(),getCity(),getState()));
		return "SearchSurvey.xhtml";
		
	}
	
	public String DeleteRecord( String user){
	/*	UIInput startComponent = (UIInput) FacesContext.getCurrentInstance().getAttributes().get("table");
		Object startComponentValue = startComponent.getValue();
		System.out.println("row data "+startComponentValue);
		System.out.println("row index "+startComponentValue);*/		
		
	//	System.out.println(getDatatable().getRowIndex());
	//	System.out.println(Totallist);
	//	System.out.println("List "+user);
		
		System.out.println("inside delete record");
		String serialid= user.substring(1,user.indexOf(','));
		StudentModel studentModel = new StudentModel();
		studentModel.deleteRecord(Integer.parseInt(serialid));
		SearchRecord();
		return "SearchSurvey.xhtml";
	}
	
	public String ListSurveys(){
		
		this.Listofsurvey.clear();
		StudentModel studentModel=new StudentModel();
		setListofsurvey(studentModel.SearchRecord("","","",""));
		return "ListSurvey.xhtml";	
	}
	

}
