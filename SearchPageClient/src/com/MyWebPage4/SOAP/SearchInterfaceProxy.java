package com.MyWebPage4.SOAP;

public class SearchInterfaceProxy implements com.MyWebPage4.SOAP.SearchInterface {
  private String _endpoint = null;
  private com.MyWebPage4.SOAP.SearchInterface searchInterface = null;
  
  public SearchInterfaceProxy() {
    _initSearchInterfaceProxy();
  }
  
  public SearchInterfaceProxy(String endpoint) {
    _endpoint = endpoint;
    _initSearchInterfaceProxy();
  }
  
  private void _initSearchInterfaceProxy() {
    try {
      searchInterface = (new com.MyWebPage4.SOAP.StudentModelServiceLocator()).getStudentModelPort();
      if (searchInterface != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)searchInterface)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)searchInterface)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (searchInterface != null)
      ((javax.xml.rpc.Stub)searchInterface)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.MyWebPage4.SOAP.SearchInterface getSearchInterface() {
    if (searchInterface == null)
      _initSearchInterfaceProxy();
    return searchInterface;
  }
  
  public java.lang.String[][] searchRecord(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3) throws java.rmi.RemoteException{
    if (searchInterface == null)
      _initSearchInterfaceProxy();
    return searchInterface.searchRecord(arg0, arg1, arg2, arg3);
  }
  
  
}