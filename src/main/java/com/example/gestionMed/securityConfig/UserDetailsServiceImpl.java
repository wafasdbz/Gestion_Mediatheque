package com.example.gestionMed.securityConfig;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.gestionMed.repository.UtilisateurRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
//	@Autowired
//	private UtilisateurRepository utilisateurRepository;
//	@Transactional(readOnly = true)
//	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
//		Account account = accountRepository.findByLogin(login);
//		if ( account == null )
//			throw new UsernameNotFoundException("Invalides login/mot de passe");
//		Set grantedAuthorities = new HashSet<>();
//		for (Role role : account.getRoles()){ 
//			grantedAuthorities.add(new SimpleGrantedAuthority(role.getLibelle())); }
//		return new User(account.getLogin(), account.getPassword(), grantedAuthorities); }
	}