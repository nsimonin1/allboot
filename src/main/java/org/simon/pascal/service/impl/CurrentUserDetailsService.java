package org.simon.pascal.service.impl;

import java.util.Optional;
import java.util.function.Consumer;

import org.simon.pascal.domain.CurrentUser;
import org.simon.pascal.model.Utilisateur;
import org.simon.pascal.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.google.common.base.Function;

/**
 * 
 * @author simon.pascal.ngos
 *
 */
@Service
public class CurrentUserDetailsService implements UserDetailsService{
   
   private UtilisateurRepository repository;
   
    @Autowired
	public CurrentUserDetailsService(UtilisateurRepository repository) {	
	this.repository = repository;
   }


	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		final Optional<Utilisateur> utilisateur=repository.findOneByUsername(login);
		return new CurrentUser(utilisateur.get());
	}

}
