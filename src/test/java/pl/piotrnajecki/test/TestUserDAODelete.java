package pl.piotrnajecki.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.piotrnajecki.config.SpringRootConfig;
import pl.piotrnajecki.dao.UserDAO;

public class TestUserDAODelete {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserDAO userDAO = ctx.getBean(UserDAO.class);
        userDAO.delete(2);
        System.out.println("---------------Data Removed-----------------");
    }

}
