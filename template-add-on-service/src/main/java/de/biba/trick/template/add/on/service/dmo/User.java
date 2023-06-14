package de.biba.trick.template.add.on.service.dmo;

/**
 * It is the response of the Security Broker to tell the details of an user
 */
import java.util.ArrayList;
import java.util.List;

public class User {

	private String firstName;
	private String lastName;
	private String email;
	private String username;
	private String organization;
	
	private List<String> roles = new ArrayList<String>();
	private String address;
	private String city;
	private String country;
	private String postalcode;
	private String aboutme;
	
	public User() {
		super();
	}

	public User(String firstName, String lastName, String email, String username, String organization,
			List<String> roles, String address, String city, String country, String postalcode, String aboutme) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.organization = organization;
		this.roles = roles;
		this.address = address;
		this.city = city;
		this.country = country;
		this.postalcode = postalcode;
		this.aboutme = aboutme;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getAboutme() {
		return aboutme;
	}

	public void setAboutme(String aboutme) {
		this.aboutme = aboutme;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", username=" + username
				+ ", organization=" + organization + ", roles=" + roles + ", address=" + address + ", city=" + city
				+ ", country=" + country + ", postalcode=" + postalcode + ", aboutme=" + aboutme + "]";
	}
	
	
	
}
