package okcode.service.standard.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import okcode.service.standard.enums.UserGroup;
import okcode.service.standard.util.StandardConstants;

@Entity
@Table(name = StandardConstants.TABLE_PREFIX_NAMING + "identity_user_auth")
public class UserAuth implements Serializable {

	private static final long serialVersionUID = -441280225512165188L;

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "credential_name", unique = true)
	private String credentialName;
	
	@Column(name = "credential_email", unique = true)
	private String credentialEmail;
	
	@Column(name = "credential_mobile", unique = true)
	private String credentialMobile;
	
	@Enumerated
	@Column(name = "user_group", nullable = false)
	private UserGroup userGroup;
	
	@Column(name = "password", nullable = false)
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCredentialName() {
		return credentialName;
	}

	public void setCredentialName(String credentialName) {
		this.credentialName = credentialName;
	}

	public String getCredentialEmail() {
		return credentialEmail;
	}

	public void setCredentialEmail(String credentialEmail) {
		this.credentialEmail = credentialEmail;
	}

	public String getCredentialMobile() {
		return credentialMobile;
	}

	public void setCredentialMobile(String credentialMobile) {
		this.credentialMobile = credentialMobile;
	}

	public UserGroup getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
