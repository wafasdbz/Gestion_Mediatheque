package com.example.gestionMed.securityConfig;



import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
		http
		 .csrf().disable()
		 .authorizeRequests() // ACLs
		 .antMatchers(HttpMethod.GET,"/api/items/**").permitAll()
//		 .antMatchers("/emprunt/**").authenticated()
		 .anyRequest().authenticated()
		 .and()
		 .formLogin()// Page de login
		 .permitAll()
		 .and()
		 .logout()
		 .logoutUrl("/logout")
		.logoutSuccessUrl("/api/utilisateurs")
		 .invalidateHttpSession(true);
		 
	}
	
	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception {
	 * 
	 * 
	 * // Ici on utilise un realm mémoire, AuthenticationManagerBuilder permet //
	 * également de facilement de se connecter à un annuaire LDAP ou une bd
	 * 
	 * auth.inMemoryAuthentication().withUser("user").password("{noop}"+ "password")
	 * .roles("USER") .and().withUser("admin").password("{noop}"+ "password")
	 * .roles("USER", "ADMIN"); }
	 */
}
