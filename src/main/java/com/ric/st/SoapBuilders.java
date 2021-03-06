package com.ric.st;

import javax.xml.ws.BindingProvider;

import com.ric.st.excp.CantSendSoap;
import com.sun.xml.ws.developer.WSBindingProvider;

public interface SoapBuilders {

	public void makeRndMsgGuid();
	public void setSign(boolean sign);
	public void setTrace(boolean trace);
	public void setUp(BindingProvider port, WSBindingProvider port2, boolean sign) throws CantSendSoap;
	public String getPpGuid();
	public void setPpGuid(String ppGuid);
	public void closeResource() throws CantSendSoap;
}
