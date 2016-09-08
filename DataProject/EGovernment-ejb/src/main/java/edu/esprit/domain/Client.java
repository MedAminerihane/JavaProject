package edu.esprit.domain;


import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;


import javax.persistence.*;

/**
 * Entity implementation class for Entity: Client
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="role")
public class Client implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idClient;
	private String login;
	private String password;
	
	
	
	
	private static final long serialVersionUID = 1L;

	public Client() {
		super();
	}   
	public Integer getIdClient() {
		return this.idClient;
	}

	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}   
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}   
	   

   
}
