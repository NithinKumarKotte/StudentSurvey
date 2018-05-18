/**
 * StudentModelServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.MyWebPage4.SOAP;

public class StudentModelServiceLocator extends org.apache.axis.client.Service implements com.MyWebPage4.SOAP.StudentModelService {

    public StudentModelServiceLocator() {
    }


    public StudentModelServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public StudentModelServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for StudentModelPort
    private java.lang.String StudentModelPort_address = "http://ec2-54-144-228-42.compute-1.amazonaws.com:80/MyWebPage4/Search";

    public java.lang.String getStudentModelPortAddress() {
        return StudentModelPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String StudentModelPortWSDDServiceName = "StudentModelPort";

    public java.lang.String getStudentModelPortWSDDServiceName() {
        return StudentModelPortWSDDServiceName;
    }

    public void setStudentModelPortWSDDServiceName(java.lang.String name) {
        StudentModelPortWSDDServiceName = name;
    }

    public com.MyWebPage4.SOAP.SearchInterface getStudentModelPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(StudentModelPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getStudentModelPort(endpoint);
    }

    public com.MyWebPage4.SOAP.SearchInterface getStudentModelPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.MyWebPage4.SOAP.StudentModelPortBindingStub _stub = new com.MyWebPage4.SOAP.StudentModelPortBindingStub(portAddress, this);
            _stub.setPortName(getStudentModelPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setStudentModelPortEndpointAddress(java.lang.String address) {
        StudentModelPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.MyWebPage4.SOAP.SearchInterface.class.isAssignableFrom(serviceEndpointInterface)) {
                com.MyWebPage4.SOAP.StudentModelPortBindingStub _stub = new com.MyWebPage4.SOAP.StudentModelPortBindingStub(new java.net.URL(StudentModelPort_address), this);
                _stub.setPortName(getStudentModelPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("StudentModelPort".equals(inputPortName)) {
            return getStudentModelPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://SOAP.MyWebPage4.com/", "StudentModelService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://SOAP.MyWebPage4.com/", "StudentModelPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("StudentModelPort".equals(portName)) {
            setStudentModelPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
