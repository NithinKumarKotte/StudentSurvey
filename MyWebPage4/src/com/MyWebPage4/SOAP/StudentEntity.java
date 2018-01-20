package com.MyWebPage4.SOAP;
// This class is a pojo class which is linked to database "gmutestdb", table "StudentTable". 
// To configure we have "hibernate.cfg.xml" and "student.hbm.xml". we have used annotations for configution

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="StudentTable")
public class StudentEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	 @Id
	 @Column(name="Serial_id")
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 protected int SerialId;
	 
	public int getSerialId() {
		return SerialId;
	}

	public void setSerialId(int seialId) {
		SerialId = seialId;
	}

	@Column(name="FirstName")
	private String firstName;
	@Column(name="LastName")
	private String lastName;
	@Column(name="StreetAddress")
	private String streetAddress;
	@Column(name="City")
	private String city;
	@Column(name="State")
	private String state;
	@Column(name="Zip")
	private String zip;
//	@Transient
	@Column(name="Telephone")
	private String telephoneNumber;
//	@Transient
	@Column(name="Email")
	private String email;
//	@Transient
	@Column(name="SurveyDate")
	private String date;
	@Transient
	@Column(name="Check")
	private String check;
//	@Transient
	@Column(name="Radio")
	private String radio;
//	@Transient
	@Column(name="Menu")
	private String menu;
	
//	@Transient
	@Column(name="Raffle")
	private String raffle;
	
//	@Transient
	@Column(name="Comments")
	private String comments;
	
//	@Transient
	@Column(name="StartDate")
	private String startdate;
	
	
	public StudentEntity(){
		
	}

	public StudentEntity(String firstName, String lastName, String streetAddress, String city,
			String state, String zip, String telephoneNumber, String email, String date,String startdate,String check,
			String radio, String menu, String raffle, String comments) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.telephoneNumber = telephoneNumber;
		this.email = email;
		this.date = date;
		this.check = check;
		this.radio = radio;
		this.menu = menu;
		this.raffle = raffle;
		this.comments = comments;
		this.startdate = startdate;
	}
	@Transient
	private ArrayList<ArrayList<String>> Totallist = new ArrayList<ArrayList<String>>();
	@Transient
	private Double[] stddevavg;

	

	public Double[] getStddevavg() {
		return stddevavg;
	}

	public void setStddevavg(Double[] stddevavg) {
		this.stddevavg = new Double[2];
		for (int i = 0; i < this.stddevavg.length; i++) {
			this.stddevavg[i] = stddevavg[i];

		}

	}
	
	
	@Transient
	public ArrayList<ArrayList<String>> getTotallist() {
		return Totallist;
	}
	
	
	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {

		this.startdate = startdate;
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
	
	
	public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;

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

	
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}


	
	
	
	

}
