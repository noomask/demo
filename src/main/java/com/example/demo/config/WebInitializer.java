package com.example.demo.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
		ac.register(RootConfig.class);
		ac.register(MvcConfig.class);
		ac.setServletContext(servletContext);
		
		Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(ac));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/api/*");
	}

}
