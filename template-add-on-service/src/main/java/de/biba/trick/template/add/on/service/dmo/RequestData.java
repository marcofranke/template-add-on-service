package de.biba.trick.template.add.on.service.dmo;

/**
 * It is the input for the Public Platform API Service. It will be transformed
 * into an JSON String and sent as HTTP Post Body
 * 
 * @author fma
 *
 */
public class RequestData {

	private String oAuthToken; //The token which is provided by the Security Broker  or via a /login
	private String base64Inputdata; //Any TRICK service input

	public String getoAuthToken() {
		return oAuthToken;
	}

	public void setoAuthToken(String oAuthToken) {
		this.oAuthToken = oAuthToken;
	}

	public String getBase64Inputdata() {
		return base64Inputdata;
	}

	public void setBase64Inputdata(String base64Inputdata) {
		this.base64Inputdata = base64Inputdata;
	}

	@Override
	public String toString() {
		return "RequestData [oAuthToken=" + oAuthToken + ", base64Inputdata=" + base64Inputdata + "]";
	}

}
