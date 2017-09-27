package com.singletonapps.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebAppInitializer implements WebApplicationInitializer {


    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        /* xml equivalent
		<servlet>
		   <servlet-name>dispatcher</servlet-name>
		   <servlet-class>
		     org.springframework.web.servlet.DispatcherServlet
		   </servlet-class>
		   <init-param>
		     <param-name>contextConfigLocation</param-name>
		     <param-value>/WEB-INF/spring/dispatcher-config.xml</param-value>
		   </init-param>
		   <load-on-startup>1</load-on-startup>
		 </servlet>

		 <servlet-mapping>
		   <servlet-name>dispatcher</servlet-name>
		   <url-pattern>/</url-pattern>
		 </servlet-mapping>
		*/

        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(WebConfig.class);

        /* Manage the lifecycle of rootContext */
        servletContext.addListener(new ContextLoaderListener(rootContext));

        DelegatingFilterProxy filterProxy = new DelegatingFilterProxy("springSecurityFilterChain");

        servletContext.addFilter("springSecurityFilterChain", filterProxy)
                .addMappingForUrlPatterns(null, false, "/*");

        /* Creates DispatcherServlet */
        DispatcherServlet dispatcherServlet = new DispatcherServlet(rootContext);

        ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcherServlet", dispatcherServlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }
}
