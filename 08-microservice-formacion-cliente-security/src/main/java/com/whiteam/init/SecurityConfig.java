package com.whiteam.init;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user1").password("{noop}user1") // lo de {noop} se pone para no obligar
																				// a usar mecanismo de encriptación
				.roles("USER").and().withUser("admin").password("{noop}admin").roles("USER", "ADMIN")
				.and().withUser("user2").password("{noop}user2").roles("OPERATOR", "USER");

		
		/*lo siguiente sería para el caso de que
		* quisiéramos encriptar la password:
		String pw1=new BCryptPasswordEncoder().encode("user1");
		System.out.println(pw1);
		auth
		.inMemoryAuthentication()
		.withUser("user1")
		.password("{bcrypt}"+pw1)
		//.password(pw1)
		.roles("USER")
		.and()
		.withUser("admin")
		.password("{bcrypt}"+new BCryptPasswordEncoder().encode("admin"))
		.roles("USER", "ADMIN");
		*/
		
		
		/*
		 * la seguiente configuración será para el caso de usuarios en una base de datos
		 * auth.jdbcAuthentication().dataSource(dataSource)
		 * .usersByUsernameQuery("select username, password, enabled" +
		 * " from users where username=?")
		 * .authoritiesByUsernameQuery("select username, authority " +
		 * "from authorities where username=?");
		 */
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
				// solo los miembros del rol admin podrán realizar altas
				// y para acceder la lista de cursos, tendrán que estar autenticados
		
		//Aqui definimos que el acceso a /curso mediante metodo post necesita de autentificacion como administrador para acceder
				.antMatchers(HttpMethod.POST, "/curso").hasRole("ADMIN")
				//Este antMatchers es totalmente independiente del atnerior. En este definimos que para acceder a /cursos
				//Hace falta autentificarse (cualquier tipo de autentificacion vale)
				.antMatchers("/cursos").authenticated()
				// .antMatchers("/curso/**").authenticated()
				.and().httpBasic();
	}

}
