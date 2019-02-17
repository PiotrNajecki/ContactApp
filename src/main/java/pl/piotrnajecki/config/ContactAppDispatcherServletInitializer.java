package pl.piotrnajecki.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class ContactAppDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringRootConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringWebConfig.class} ;
    }

    //DispathcerServlet is FrontController
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);  // must present, missed will not work
        //You can confiugre here global resources, tasks if required
    }
}



