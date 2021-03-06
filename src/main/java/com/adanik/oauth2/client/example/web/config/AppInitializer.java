package com.adanik.oauth2.client.example.web.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author s Khalili
 */
public class AppInitializer implements WebApplicationInitializer {
  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
    context.register(WebMvcConfig.class);
    context.setServletContext(servletContext);

    ServletRegistration.Dynamic servlet = servletContext.addServlet(
            "dispatcher", new DispatcherServlet(context));

    servlet.setLoadOnStartup(1);
    servlet.addMapping("/");
  }
}
