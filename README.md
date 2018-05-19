# StudentSurvey

This is a 3 tier web application developed using Java technology for University students to provide reviews about their university.Java Server Faces (JSF) is used for presentation tier.
Hibernate framework is the application framework and JDBC driver to interface with Model. To achieve database access, we have used AWS relational database service (RDS). JAX RS is used as REST Webservie to interact between 
UI (Survey page) and remote method hosted on AWS EC2 instance. JAX WS (SOAP Webservice) is used to call Model method from client class (SearchClient.java). 
