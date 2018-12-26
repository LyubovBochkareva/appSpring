package spring.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class AppInitializer implements WebApplicationInitializer {

    public void onStartup(ServletContext container) throws ServletException {

        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(appContext));
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");

        ContextLoaderListener contextLoaderListener = new ContextLoaderListener(appContext);
        container.addListener(contextLoaderListener);
    }

}
