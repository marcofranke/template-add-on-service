package de.biba.trick.template.add.on.service.dmo;

/**
 * The result of the Security Broker for a valid login. It is a token
 * @author fma
 *
 */
public class Token {

	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "Token [token=" + token + "]";
	}
	
	
	
}
