package com.example.gestionMed.securityConfig;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.gestionMed.entity.Utilisateur;
import com.example.gestionMed.repository.UtilisateurRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{


	@Autowired private UtilisateurRepository utilisateurRepository;
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Utilisateur utilisateur =utilisateurRepository.findUtilisateurByLogin(username); 
		if ( utilisateur == null ) throw new UsernameNotFoundException("Invalides login/mot de passe");
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		return new User(utilisateur.getLogin(), "{noop}" + utilisateur.getPasseWord(), grantedAuthorities);
	}

}



