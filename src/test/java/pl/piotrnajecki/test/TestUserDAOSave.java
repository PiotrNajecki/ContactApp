package pl.piotrnajecki.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.piotrnajecki.config.SpringRootConfig;
import pl.piotrnajecki.dao.UserDAO;
import pl.piotrnajecki.domain.User;

public class TestUserDAOSave {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserDAO userDAO = ctx.getBean(UserDAO.class);
        // the user details will be taken from Reg-Form
        User u = new User();
        u.setName("Piotr");
        u.setPhone("8080809");
        u.setEmail("piotrek_3000@op.pl");
        u.setLoginName("piotr");
        u.setPassword("lalala");
        u.setRole(1); // AdminRole
        u.setLoginStatus(1); // ActiveRole
        userDAO.save(u);
        userDAO.update(u);
        System.out.println("-------------Data Updated-------------");



    }
}
