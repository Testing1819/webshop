package domain.model;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User extends DatabaseModel {
	private String username;
	private String email;
	private String password;
	private String firstName;
	private String lastName;

	private Role role;

	public User(String username, String email, String password, String firstName, String lastName, Role role) {
		setUsername(username);
		setEmail(email);
		setPassword(password);
		setFirstName(firstName);
		setLastName(lastName);
		setRole(role);
	}
	
	public User() {
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername (String username) {
		this.username = username;
	}

	public void setEmail(String email) {
		if(email == null || email.isEmpty()){
			throw new IllegalArgumentException("No email given");
		}
		String USERID_PATTERN = 
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern p = Pattern.compile(USERID_PATTERN);
		Matcher m = p.matcher(email);
		if (!m.matches()) {
			throw new IllegalArgumentException("Email not valid");
		}
		this.email = email;
	}

	
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String hashedPassword) {
		if(hashedPassword == null || hashedPassword.isEmpty()){
			throw new IllegalArgumentException("No password given");
		}
		this.password = hashedPassword;
	}

	public void setUnhashedPassword(String password) {
		if(password == null || password.isEmpty()){
			throw new IllegalArgumentException("No password given");
		}
		this.password = hashPassword(password);
	}

	private String hashPassword(String password) {
		try {
			MessageDigest crypt = MessageDigest.getInstance("SHA-512");
			crypt.reset();
			byte[] passwordBytes = password.getBytes("UTF-8");
			crypt.update(passwordBytes);
			byte[] digest = crypt.digest();
			BigInteger digestAsBigInteger = new BigInteger(1, digest);
			return digestAsBigInteger.toString(16);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DomainException();
		}
	}

	public boolean isPasswordCorrect(String password) {
		return hashPassword(password).equals(this.password);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if(firstName == null || firstName.isEmpty()){
			throw new IllegalArgumentException("No firstname given");
		}
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if(lastName == null || lastName.isEmpty()){
			throw new IllegalArgumentException("No last name given");
		}
		this.lastName = lastName;
	}

	public String getRole() {
		return this.role.name();
	}

    public void setRole(String role) {
        this.role = Role.valueOf(role);
    }
	public void setRole(Role role) {
		this.role = role;
	}
	
	@Override
	public String toString(){
		return getFirstName() + " " + getLastName() + ": " + getUsername() + ", " + getEmail() + ", " + getRole();
	}	
}
