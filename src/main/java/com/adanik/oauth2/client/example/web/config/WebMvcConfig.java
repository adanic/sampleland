package com.adanik.oauth2.client.example.web.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperFactoryBean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.adanik")
@PropertySource(value = "classpath:adanalas.properties")
public class WebMvcConfig extends WebMvcConfigurerAdapter {

  /*
   * Configure ContentNegotiationManager
   */
  @Override
  public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
    configurer.ignoreAcceptHeader(true).defaultContentType(
            MediaType.TEXT_HTML);
  }

  /*
   * Configure ContentNegotiatingViewResolver
   */
  @Bean
  public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
    ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
    resolver.setContentNegotiationManager(manager);
    // Define all possible view resolvers
    List<ViewResolver> resolvers = new ArrayList<ViewResolver>();
    resolvers.add(jspViewResolver());
    resolver.setViewResolvers(resolvers);
    return resolver;
  }

  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/image/**").addResourceLocations("classpath:image/");
    registry.addResourceHandler("/css/**").addResourceLocations("classpath:css/");
  }

  @Bean
  public static PropertySourcesPlaceholderConfigurer propertyPlaceHolderConfigurer() {
    return new PropertySourcesPlaceholderConfigurer();
  }

  /*
   * Configure View resolver to provide HTML output This is the default format
   * in absence of any type suffix.
   */
  @Bean
  public ViewResolver jspViewResolver() {
    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    viewResolver.setViewClass(JstlView.class);
    viewResolver.setPrefix("/WEB-INF/jsp/");
    viewResolver.setSuffix(".jsp");
    return viewResolver;
  }

  private ObjectMapper objectMapper() {
    Jackson2ObjectMapperFactoryBean bean = new Jackson2ObjectMapperFactoryBean();
    bean.setIndentOutput(true);
    bean.setSimpleDateFormat("yyyyMMddHHmmss");
    bean.afterPropertiesSet();
    return bean.getObject();
  }

  private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
    MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
    converter.setObjectMapper(objectMapper());
    return converter;
  }

  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    converters.add(mappingJackson2HttpMessageConverter());
  }
}
