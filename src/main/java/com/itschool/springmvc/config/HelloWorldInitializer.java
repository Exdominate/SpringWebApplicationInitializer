
package com.itschool.springmvc.config;

import java.awt.Container;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


public class HelloWorldInitializer implements WebApplicationInitializer{

    public void onStartup(ServletContext sc) throws ServletException {
        AnnotationConfigWebApplicationContext ctx=new AnnotationConfigWebApplicationContext();
        ctx.register(HelloWorldConfiguration.class);
        ctx.setServletContext(sc);
        
        ServletRegistration.Dynamic servlet=sc.addServlet("dispatcher", 
                new DispatcherServlet(ctx));
        
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
    }
    
}
