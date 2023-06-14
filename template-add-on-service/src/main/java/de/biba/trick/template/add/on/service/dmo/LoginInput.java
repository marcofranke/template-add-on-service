package de.biba.trick.template.add.on.service.dmo;

/**
 * Based on swagger documentation for login by Security Broker
 * @author fma
 *
 */
public class LoginInput {

	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginInput [username=" + username + ", password=" + password + "]";
	}
	



}

