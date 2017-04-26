package com.grupo15.ServiceLayer;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurityController extends WebSecurityConfigurerAdapter {

   /* @Override
    public void configure(HttpSecurity http) throws Exception {
<<<<<<< HEAD
        http.authorizeRequests().antMatchers("/autenticar", "/*").authenticated().anyRequest().permitAll().and().formLogin().loginPage("/login").permitAll().and().logout().permitAll().and().cors().and().csrf().disable();
=======
        http
            .authorizeRequests()
                .antMatchers("/**").permitAll()
                .anyRequest().anonymous()
            .and().cors().disable();
>>>>>>> refs/remotes/origin/master
    }
    
    /*
    @Autowired
    public void configuracionGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("easyFlete").password("admin").roles("USER");
    }*/

}
