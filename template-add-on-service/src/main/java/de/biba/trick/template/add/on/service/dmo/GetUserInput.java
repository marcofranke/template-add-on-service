package de.biba.trick.template.add.on.service.dmo;

/**
 * It is the data structure to retrieve user details from the Security Broker
 * @author fma
 *
 */
public class GetUserInput {

	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "GetUserInput [username=" + username + "]";
	}

	
	
	
}
