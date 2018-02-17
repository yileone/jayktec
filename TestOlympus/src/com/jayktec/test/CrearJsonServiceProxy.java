package com.jayktec.test;

public class CrearJsonServiceProxy implements com.jayktec.test.CrearJsonService {
  private String _endpoint = null;
  private com.jayktec.test.CrearJsonService crearJsonService = null;
  
  public CrearJsonServiceProxy() {
    _initCrearJsonServiceProxy();
  }
  
  public CrearJsonServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initCrearJsonServiceProxy();
  }
  
  private void _initCrearJsonServiceProxy() {
    try {
      crearJsonService = (new com.jayktec.test.CrearJsonServiceServiceLocator()).getCrearJsonService();
      if (crearJsonService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)crearJsonService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)crearJsonService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (crearJsonService != null)
      ((javax.xml.rpc.Stub)crearJsonService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.jayktec.test.CrearJsonService getCrearJsonService() {
    if (crearJsonService == null)
      _initCrearJsonServiceProxy();
    return crearJsonService;
  }
  
  public void llamandoJson(java.lang.String name) throws java.rmi.RemoteException{
    if (crearJsonService == null)
      _initCrearJsonServiceProxy();
    crearJsonService.llamandoJson(name);
  }
  
  
}