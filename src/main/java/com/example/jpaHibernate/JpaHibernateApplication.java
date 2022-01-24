package com.example.jpaHibernate;

import com.example.jpaHibernate.persona.domain.Parametros;
import com.example.jpaHibernate.persona.infrastructure.controller.Credentials;
import com.example.jpaHibernate.persona.infrastructure.controller.dto.JWTAuthorizationFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@EnableFeignClients
@SpringBootApplication
public class JpaHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateApplication.class, args);
	}

	@Bean
	Parametros retornanueva() {
		return new Parametros();
	}



	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter
	{

		@Override
		protected void configure(HttpSecurity http) throws Exception {

			http.headers().frameOptions().disable(); //Para que funcione "/h2-console" (tras acceder, mostraba otro error)

			http
			        .csrf().disable()
					.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
					.authorizeRequests()

					// Para permitir acceder a la consola de H2 (sino, retorna 403 - Forbidden)
					.antMatchers("/").permitAll()
					.antMatchers("/h2-console/**").permitAll()

					// Indico que, de entrada, esta URL sí que está permitida (.../login").permitAll() ), sino, me
					// retornaría un "403 - Forbidden". Ver "LoginController".
					// Con, por ejemplo: http://localhost:8085/login?usuario=usuario8&password=pass8 , me retorna un
					// token JWT (busca "token" en la clase "LoginController")
					.antMatchers(HttpMethod.POST, "/login").permitAll()  //Permite acceder a esta url
					.antMatchers(HttpMethod.GET, "/hello").permitAll()   //A esta también

					.anyRequest().authenticated(); //El resto de peticiones, deben estár autenticadas con el "token"


		}



	}



}