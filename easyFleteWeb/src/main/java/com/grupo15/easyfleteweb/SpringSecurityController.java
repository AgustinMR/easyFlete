package com.grupo15.easyfleteweb;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurityController extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        //http.authorizeRequests().antMatchers("/", "/*").authenticated().anyRequest().permitAll().and().formLogin().loginPage("/login").permitAll().and().logout().permitAll().and().cors().and().csrf().disable();
        http
            .authorizeRequests()
                .antMatchers("/", "/registrarse").permitAll()
                .anyRequest().anonymous()
            .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
            .and()
            .logout().permitAll();

    }

    /*@Autowired
    public void configuracionGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource);
    }*/
    
}
