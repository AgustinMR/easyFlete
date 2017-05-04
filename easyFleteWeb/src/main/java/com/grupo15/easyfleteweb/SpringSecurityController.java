package com.grupo15.easyfleteweb;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurityController extends WebSecurityConfigurerAdapter {
    
    @Autowired
    DataSource dataSource;
    
    @Bean(name = "dataSource")
	public DriverManagerDataSource dataSource() {
	    DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
	    driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
	    driverManagerDataSource.setUrl("jdbc:postgresql://localhost:5432/easyFleteDB");
	    driverManagerDataSource.setUsername("postgres");
	    driverManagerDataSource.setPassword("postgres");
	    return driverManagerDataSource;
	}

    @Override
    public void configure(HttpSecurity http) throws Exception {
        //http.authorizeRequests().antMatchers("/", "/registrarse").authenticated().anyRequest().permitAll().and().formLogin().loginPage("/login").permitAll().and().logout().permitAll().and().cors().and().csrf().disable();
        http
            .authorizeRequests()
                .antMatchers("/", "/registrarse").permitAll()
                .anyRequest().anonymous()
            .and()
            .formLogin()
                .loginPage("/login").failureUrl("/login?error").usernameParameter("email").passwordParameter("pass").successForwardUrl("/inicio").permitAll()
            .and()
            .logout().logoutSuccessUrl("/logout?success").permitAll();

    }

    @Autowired
    public void configuracionGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("SELECT email,password FROM CLIENTES WHERE email=?").usersByUsernameQuery("SELECT email,password FROM FLETEROS WHERE email=?");
    }
    
}
