package org.simon.pascal.domain;

import java.util.Collection;

import org.simon.pascal.api.Role;
import org.simon.pascal.model.Utilisateur;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;

public class CurrentUser extends User {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Getter
    private final Utilisateur utilisateur;
	
	public CurrentUser(Utilisateur utilisateur) {		
		super(utilisateur.getUsername(), utilisateur.getPassword()
				, utilisateur.getActif()
				, true, true, true, AuthorityUtils.createAuthorityList(utilisateur.getRole().toString()));
		this.utilisateur=utilisateur; 
	}
	
	 
  public Role getRole(){
	return utilisateur.getRole();
  }
	

}
