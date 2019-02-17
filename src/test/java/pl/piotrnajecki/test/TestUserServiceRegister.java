package pl.piotrnajecki.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.piotrnajecki.config.SpringRootConfig;
import pl.piotrnajecki.dao.UserDAO;
import pl.piotrnajecki.domain.User;
import pl.piotrnajecki.services.UserService;

public class TestUserServiceRegister {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserService userService = ctx.getBean(UserService.class);
        // the user details will be taken from Reg-Form
        User u = new User();
        u.setName("Nitin");
        u.setPhone("8089098");
        u.setEmail("piotrek2000@op.pl");
        u.setLoginName("piotr");
        u.setPassword("lalala");
        u.setRole(UserService.ROLE_ADMIN); // AdminRole
        u.setLoginStatus(UserService.LOGIN_STATUS_ACTIVE); // ActiveRole
        userService.register(u);

        System.out.println("-------------User Registered Succesfully-------------");



    }
}
