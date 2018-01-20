package com.MyWebPage4.SOAP;
// Following is service class to perform CRUD operation on database.
// In this case it has 2 methods "createrecord" and "search record"
// for creating new survey record and searching for record
// This class also acts as SOAP webservice having webmethod to be SearchRecord()



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.jws.WebService;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
@WebService(endpointInterface="com.MyWebPage4.SOAP.SearchInterface")
public class StudentModel implements SearchInterface {
	// @SuppressWarnings("deprecation")
	//private static final SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
	
	public ArrayList<ArrayList<String>> Totallist = new ArrayList<ArrayList<String>>();
	
	 public void createrecord(String Firstname, String Lastname, String StreetAddress, String City,
				String State, String Zip, String telephone, String email, String date, String startdate,
				String check, String radio, String menu, String raffle, String comments){
		 
		 Configuration con= new Configuration();
			con.configure("hibernate.cfg.xml");
			SessionFactory SF= con.buildSessionFactory();
		 
		 

		 Session session = SF.openSession();
		 	Transaction TR= session.beginTransaction();
		 	StudentEntity studentEntity=new StudentEntity(Firstname,Lastname,StreetAddress,City,State,Zip,telephone,email,date,startdate,check,radio,menu,raffle,comments);
		 	Integer i=(Integer)session.save(studentEntity);
		 	System.out.println("Generated identifier "+i);
		 	System.out.println("Inserted Successfully");
		 	TR.commit();
		 	session.close();
		 	
		 
				 
	 }
	 
	 @Override
	 public ArrayList<ArrayList<String>>  SearchRecord(String Firstname,String LastName,String City, String State){
		 
		 System.out.println("firstname "+Firstname);
		 System.out.println("lastname "+LastName);
		 System.out.println("cityname "+City);
		 System.out.println("statename "+State);
		 Totallist.clear();
		// ArrayList<String> list =new ArrayList<String>();
		 
		 Configuration con= new Configuration();
			con.configure("hibernate.cfg.xml");
			SessionFactory SF= con.buildSessionFactory();
			 Session session = SF.openSession();
			 Transaction TR= session.beginTransaction();
			 
			 if(Firstname.equals("") && LastName.equals("") && City.equals("") && State!="" ){
				 
				
				 
				 Query query = session.createQuery("from StudentEntity where State = :state ");
				 query.setParameter("state", State);
				 List<Object> stud=query.list();
				 
				 for (Iterator<Object> iterator = stud.iterator(); iterator.hasNext();) {
					 ArrayList<String> list1 =new ArrayList<String>();
		                StudentEntity stud1 = (StudentEntity) iterator.next();
		               /* System.out.println(stud1.getFirstName()+ "  "
		                        + stud1.getCity() + "  " + stud1.getEmail()
		                        + "   " + stud1.getRadio());*/
		              //  list.add(stud1);
					  //List<StudentEntity> stud1 = (List<StudentEntity>) iterator.next();
		                	list1.add(stud1.getSerialId()+"");
		                	list1.add(stud1.getFirstName());	list1.add(stud1.getLastName());list1.add(stud1.getStreetAddress());
		                	list1.add(stud1.getCity()); list1.add(stud1.getState());
		                	list1.add(stud1.getZip()); list1.add(stud1.getDate());
		                	list1.add(stud1.getEmail()); list1.add(stud1.getTelephoneNumber());
		                	list1.add(stud1.getStartdate()); list1.add(stud1.getRadio());
		                	list1.add(stud1.getRaffle()); list1.add(stud1.getComments());
		                	 Totallist.add(list1);
		            }
				
				 TR.commit();
				 session.close();
				 
				 
			 }
			 
			 else if(Firstname.equals("") && LastName.equals("") && State.equals("") && City!=""){
				// ArrayList<StudentEntity> list =new ArrayList<StudentEntity>();
				 
				 Query query = session.createQuery("from StudentEntity where City = :city ");
				 query.setParameter("city", City);
				 List<Object> stud=query.list();
				 
				 for (Iterator<Object> iterator = stud.iterator(); iterator.hasNext();) {
					 ArrayList<String> list1 =new ArrayList<String>();
		                StudentEntity stud1 = (StudentEntity) iterator.next();
		               /* System.out.println(stud1.getFirstName()+ "  "
		                        + stud1.getCity() + "  " + stud1.getEmail()
		                        + "   " + stud1.getRadio());*/
		              //  list.add(stud1);
					  //List<StudentEntity> stud1 = (List<StudentEntity>) iterator.next();
		                list1.add(stud1.getSerialId()+"");
		                	list1.add(stud1.getFirstName());	list1.add(stud1.getLastName());list1.add(stud1.getStreetAddress());
		                	list1.add(stud1.getCity()); list1.add(stud1.getState());
		                	list1.add(stud1.getZip()); list1.add(stud1.getDate());
		                	list1.add(stud1.getEmail()); list1.add(stud1.getTelephoneNumber());
		                	list1.add(stud1.getStartdate()); list1.add(stud1.getRadio());
		                	list1.add(stud1.getRaffle()); list1.add(stud1.getComments());
		                	 Totallist.add(list1);
		            }
				
				 TR.commit();
				 session.close();
				 
				 
			 }
			 
			 else if(Firstname.equals("") && City.equals("") && State.equals("") && LastName!="" ){
				// ArrayList<StudentEntity> list =new ArrayList<StudentEntity>();
				 
				 Query query = session.createQuery("from StudentEntity where LastName = :lname ");
				 query.setParameter("lname", LastName);
				 List<Object> stud=query.list();
				 
				 
				 for (Iterator<Object> iterator = stud.iterator(); iterator.hasNext();) {
					 ArrayList<String> list1 =new ArrayList<String>();
		                StudentEntity stud1 = (StudentEntity) iterator.next();
		               /* System.out.println(stud1.getFirstName()+ "  "
		                        + stud1.getCity() + "  " + stud1.getEmail()
		                        + "   " + stud1.getRadio());*/
		              //  list.add(stud1);
					  //List<StudentEntity> stud1 = (List<StudentEntity>) iterator.next();
		                list1.add(stud1.getSerialId()+"");
		                	list1.add(stud1.getFirstName());	list1.add(stud1.getLastName());list1.add(stud1.getStreetAddress());
		                	list1.add(stud1.getCity()); list1.add(stud1.getState());
		                	list1.add(stud1.getZip()); list1.add(stud1.getDate());
		                	list1.add(stud1.getEmail()); list1.add(stud1.getTelephoneNumber());
		                	list1.add(stud1.getStartdate()); list1.add(stud1.getRadio());
		                	list1.add(stud1.getRaffle()); list1.add(stud1.getComments());
		                	 Totallist.add(list1);
		            }
				
				 TR.commit();
				 session.close();
				 
				 
			 }
			 
			 else if(City.equals("") && LastName.equals("") && State.equals("") && Firstname!=""){
				// ArrayList<StudentEntity> list =new ArrayList<StudentEntity>();
				 
				 Query query = session.createQuery("from StudentEntity where FirstName = :fname ");
				 query.setParameter("fname", Firstname);
				 List<Object> stud=query.list();
				 
				 for (Iterator<Object> iterator = stud.iterator(); iterator.hasNext();) {
					 ArrayList<String> list1 =new ArrayList<String>();
		                StudentEntity stud1 = (StudentEntity) iterator.next();
		               /* System.out.println(stud1.getFirstName()+ "  "
		                        + stud1.getCity() + "  " + stud1.getEmail()
		                        + "   " + stud1.getRadio());*/
		              //  list.add(stud1);
					  //List<StudentEntity> stud1 = (List<StudentEntity>) iterator.next();
		                list1.add(stud1.getSerialId()+"");
		                	list1.add(stud1.getFirstName());	list1.add(stud1.getLastName());list1.add(stud1.getStreetAddress());
		                	list1.add(stud1.getCity()); list1.add(stud1.getState());
		                	list1.add(stud1.getZip()); list1.add(stud1.getDate());
		                	list1.add(stud1.getEmail()); list1.add(stud1.getTelephoneNumber());
		                	list1.add(stud1.getStartdate()); list1.add(stud1.getRadio());
		                	list1.add(stud1.getRaffle()); list1.add(stud1.getComments());
		                	 Totallist.add(list1);
		            }
				
				 TR.commit();
				 session.close();
				 
				 
			 }	 else if(City.equals("") && LastName.equals("") && State.equals("") && City.equals("")){
				 
				// ArrayList<StudentEntity> list =new ArrayList<StudentEntity>();
				 
				 Query query = session.createQuery("from StudentEntity");
				 List<Object> stud=query.list();
				 
				 for (Iterator<Object> iterator = stud.iterator();  iterator.hasNext();) {
					 ArrayList<String> list1 =new ArrayList<String>();
		                StudentEntity stud1 = (StudentEntity) iterator.next();
		               /* System.out.println(stud1.getFirstName()+ "  "
		                        + stud1.getCity() + "  " + stud1.getEmail()
		                        + "   " + stud1.getRadio());*/
		              //  list.add(stud1);
					  //List<StudentEntity> stud1 = (List<StudentEntity>) iterator.next();
		                list1.add(stud1.getSerialId()+"");
		                	list1.add(stud1.getFirstName());	list1.add(stud1.getLastName());list1.add(stud1.getStreetAddress());
		                	list1.add(stud1.getCity()); list1.add(stud1.getState());
		                	list1.add(stud1.getZip()); list1.add(stud1.getDate());
		                	list1.add(stud1.getEmail()); list1.add(stud1.getTelephoneNumber());
		                	list1.add(stud1.getStartdate()); list1.add(stud1.getRadio());
		                	list1.add(stud1.getRaffle()); list1.add(stud1.getComments());
		                	 Totallist.add(list1);
		            }
				
				
				 TR.commit();
				 session.close();
				 
				 
			 }
			 
			 else if(Firstname!="" && LastName!="" && State.equals("") && City.equals("") ){
					 System.out.println("Inside fname and lname");
					 
					 Query query =  session.createQuery("from StudentEntity where FirstName = :fname AND LastName = :lname");
					 query.setParameter("fname", Firstname);
					 query.setParameter("lname", LastName);
					 List<Object> stud=query.list();
					 
					 
				 for (Iterator<Object> iterator = stud.iterator(); iterator.hasNext();) {
					
					 ArrayList<String> list1 =new ArrayList<String>();
		                StudentEntity stud1 = (StudentEntity) iterator.next();
		               /* System.out.println(stud1.getFirstName()+ "  "
		                        + stud1.getCity() + "  " + stud1.getEmail()
		                        + "   " + stud1.getRadio());*/
		              //  list.add(stud1);
					  //List<StudentEntity> stud1 = (List<StudentEntity>) iterator.next();
		                list1.add(stud1.getSerialId()+"");
		                	list1.add(stud1.getFirstName());	list1.add(stud1.getLastName());list1.add(stud1.getStreetAddress());
		                	list1.add(stud1.getCity()); list1.add(stud1.getState());
		                	list1.add(stud1.getZip()); list1.add(stud1.getDate());
		                	list1.add(stud1.getEmail()); list1.add(stud1.getTelephoneNumber());
		                	list1.add(stud1.getStartdate()); list1.add(stud1.getRadio());
		                	list1.add(stud1.getRaffle()); list1.add(stud1.getComments());
		                	 Totallist.add(list1);
		            }
				 
				 TR.commit();
				 session.close();		 
				 }
			 else if(Firstname.equals("") && LastName.equals("") && State!="" && City!="" ){
				 System.out.println("Inside fname and lname");
				 
				 Query query =  session.createQuery("from StudentEntity where City = :city AND State = :state");
				 query.setParameter("city", City);
				 query.setParameter("state", State);
				 List<Object> stud=query.list();
				 
				 
			 for (Iterator<Object> iterator = stud.iterator(); iterator.hasNext();) {
				
				 ArrayList<String> list1 =new ArrayList<String>();
	                StudentEntity stud1 = (StudentEntity) iterator.next();
	               /* System.out.println(stud1.getFirstName()+ "  "
	                        + stud1.getCity() + "  " + stud1.getEmail()
	                        + "   " + stud1.getRadio());*/
	              //  list.add(stud1);
				  //List<StudentEntity> stud1 = (List<StudentEntity>) iterator.next();
	                list1.add(stud1.getSerialId()+"");
	                	list1.add(stud1.getFirstName());	list1.add(stud1.getLastName());list1.add(stud1.getStreetAddress());
	                	list1.add(stud1.getCity()); list1.add(stud1.getState());
	                	list1.add(stud1.getZip()); list1.add(stud1.getDate());
	                	list1.add(stud1.getEmail()); list1.add(stud1.getTelephoneNumber());
	                	list1.add(stud1.getStartdate()); list1.add(stud1.getRadio());
	                	list1.add(stud1.getRaffle()); list1.add(stud1.getComments());
	                	 Totallist.add(list1);
	            }
			 
			 TR.commit();
			 session.close();		 
			 
			 }	 else if(Firstname!="" && LastName!="" && City!="" && State.equals("") ){
				 System.out.println("Inside fname and lname");
				 
				 Query query =  session.createQuery("from StudentEntity where FirstName = :fname AND LastName = :lname AND City = :city");
				 query.setParameter("fname", Firstname);
				 query.setParameter("lname", LastName);
				 query.setParameter("city", City);
				 List<Object> stud=query.list();
				 
				 
			 for (Iterator<Object> iterator = stud.iterator(); iterator.hasNext();) {
				
				 ArrayList<String> list1 =new ArrayList<String>();
	                StudentEntity stud1 = (StudentEntity) iterator.next();
	               /* System.out.println(stud1.getFirstName()+ "  "
	                        + stud1.getCity() + "  " + stud1.getEmail()
	                        + "   " + stud1.getRadio());*/
	              //  list.add(stud1);
				  //List<StudentEntity> stud1 = (List<StudentEntity>) iterator.next();
	                list1.add(stud1.getSerialId()+"");
	                	list1.add(stud1.getFirstName());	list1.add(stud1.getLastName());list1.add(stud1.getStreetAddress());
	                	list1.add(stud1.getCity()); list1.add(stud1.getState());
	                	list1.add(stud1.getZip()); list1.add(stud1.getDate());
	                	list1.add(stud1.getEmail()); list1.add(stud1.getTelephoneNumber());
	                	list1.add(stud1.getStartdate()); list1.add(stud1.getRadio());
	                	list1.add(stud1.getRaffle()); list1.add(stud1.getComments());
	                	 Totallist.add(list1);
	            }
			 
			 TR.commit();
			 session.close();		 
			 }
		
				 else{
				System.out.println("Inside all");
				Query query =  session.createQuery("from StudentEntity where FirstName = :fname AND LastName = :lname AND City = :city AND State = :state");
				 query.setParameter("fname", Firstname);
				 query.setParameter("lname", LastName);
				 query.setParameter("city", City);
				 query.setParameter("state", State);
				 
				 List<Object> stud=query.list();
				 
				 
			 for (Iterator<Object> iterator = stud.iterator(); iterator.hasNext();) {
				
				 ArrayList<String> list1 =new ArrayList<String>();
	                StudentEntity stud1 = (StudentEntity) iterator.next();
	               /* System.out.println(stud1.getFirstName()+ "  "
	                        + stud1.getCity() + "  " + stud1.getEmail()
	                        + "   " + stud1.getRadio());*/
	              //  list.add(stud1);
				  //List<StudentEntity> stud1 = (List<StudentEntity>) iterator.next();
	                list1.add(stud1.getSerialId()+"");
	                	list1.add(stud1.getFirstName());	list1.add(stud1.getLastName());list1.add(stud1.getStreetAddress());
	                	list1.add(stud1.getCity()); list1.add(stud1.getState());
	                	list1.add(stud1.getZip()); list1.add(stud1.getDate());
	                	list1.add(stud1.getEmail()); list1.add(stud1.getTelephoneNumber());
	                	list1.add(stud1.getStartdate()); list1.add(stud1.getRadio());
	                	list1.add(stud1.getRaffle()); list1.add(stud1.getComments());
	                	 Totallist.add(list1);
	            }
			 
			 TR.commit();
			 session.close();
			 }
			 
			 return Totallist;		 
	 
	 }

			
	 
 
	 
	 public void deleteRecord(int id ){
		 
		 System.out.println("deleted"+id);
		 Configuration con= new Configuration();
			con.configure("hibernate.cfg.xml");
			SessionFactory SF= con.buildSessionFactory();
			 Session session = SF.openSession();
			 	Transaction TR= session.beginTransaction();
			 	StudentEntity student = (StudentEntity) session.get(StudentEntity.class, id);
			 	session.delete(student);
			
			 	System.out.println("Deleted successfully");
			 	TR.commit();
			 	session.close();
			 	
			 	
	 }
	 
}
