/**
 * CrearJsonServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.jayktec.test;

public class CrearJsonServiceServiceLocator extends org.apache.axis.client.Service implements com.jayktec.test.CrearJsonServiceService {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CrearJsonServiceServiceLocator() {
    }


    public CrearJsonServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CrearJsonServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CrearJsonService
    private java.lang.String CrearJsonService_address = "http://localhost:8080/OlimpusWebServices/services/CrearJsonService";

    public java.lang.String getCrearJsonServiceAddress() {
        return CrearJsonService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CrearJsonServiceWSDDServiceName = "CrearJsonService";

    public java.lang.String getCrearJsonServiceWSDDServiceName() {
        return CrearJsonServiceWSDDServiceName;
    }

    public void setCrearJsonServiceWSDDServiceName(java.lang.String name) {
        CrearJsonServiceWSDDServiceName = name;
    }

    public com.jayktec.test.CrearJsonService getCrearJsonService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CrearJsonService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCrearJsonService(endpoint);
    }

    public com.jayktec.test.CrearJsonService getCrearJsonService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.jayktec.test.CrearJsonServiceSoapBindingStub _stub = new com.jayktec.test.CrearJsonServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getCrearJsonServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCrearJsonServiceEndpointAddress(java.lang.String address) {
        CrearJsonService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.jayktec.test.CrearJsonService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.jayktec.test.CrearJsonServiceSoapBindingStub _stub = new com.jayktec.test.CrearJsonServiceSoapBindingStub(new java.net.URL(CrearJsonService_address), this);
                _stub.setPortName(getCrearJsonServiceWSDDServiceName());
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
        if ("CrearJsonService".equals(inputPortName)) {
            return getCrearJsonService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://DefaultNamespace", "CrearJsonServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://DefaultNamespace", "CrearJsonService"));
        }
    
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("CrearJsonService".equals(portName)) {
            setCrearJsonServiceEndpointAddress(address);
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
