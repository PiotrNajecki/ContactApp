package pl.piotrnajecki.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.piotrnajecki.config.SpringRootConfig;
import pl.piotrnajecki.dao.UserDAO;

public class TestUserDAOFindSingleRecord {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserDAO userDao = ctx.getBean(UserDAO.class);
    }

}
