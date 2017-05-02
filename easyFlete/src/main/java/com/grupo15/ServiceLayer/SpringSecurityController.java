package com.grupo15.ServiceLayer;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurityController extends WebSecurityConfigurerAdapter {
    

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/**").permitAll()
                .anyRequest().anonymous()
            .and().cors().disable().csrf().disable();
    }
    
    /*
    @Autowired
    public void configuracionGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("easyFlete").password("admin").roles("USER");
    }*/

}
