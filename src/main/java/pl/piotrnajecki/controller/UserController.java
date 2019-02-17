package pl.piotrnajecki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.piotrnajecki.command.LoginCommand;
import pl.piotrnajecki.command.UserComand;
import pl.piotrnajecki.domain.User;
import pl.piotrnajecki.exception.UserBlockedException;
import pl.piotrnajecki.services.UserService;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/","/index"} )
    public String index(Model model) {
        model.addAttribute("command", new LoginCommand());
        return "index"; // JSP - /WEB-INF/view/index.jsp  -> prefix and suffix provided by ViewResolver
    }

    @RequestMapping(value = "/logout", method=RequestMethod.POST )
    public String handleLogout(HttpSession session) {
        session.invalidate();
        return "index"; // JSP - /WEB-INF/view/index.jsp  -> prefix and suffix provided by ViewResolver
    }


    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String handleLogin(@ModelAttribute("command") LoginCommand cmd, Model m) {
        try {
            User loggedInUser = userService.login(cmd.getLoginName(), cmd.getPassword());
            if (loggedInUser==null) {
                m.addAttribute("err", "Login Failed! Enter valid credentials.");
                return "redirect:index?act=logout";
            } else {
                // SUCCESS
                // Check the role and redirect to a appropriate dashboard
                if (loggedInUser.getRole().equals(UserService.ROLE_ADMIN)) {
                    //TODO: add user detail in session (assign session to logged in user)
                    return "redirect:admin/dashboard";
                } else if(loggedInUser.getRole().equals(UserService.ROLE_ADMIN)) {
                    //TODO: add user detail in session (assign session to logged in user)
                    return "redirect:user/dashboard";
                } else {
                    // add error message and go back to login-form
                    m.addAttribute("err", "Invalid User Role");
                    return "index";
                }

            }
        } catch (UserBlockedException e) {
            // add error message and go back to login-form
            m.addAttribute("err", e.getMessage());
            return "index";
        }
    }

    @RequestMapping(value = "/user/dashboard" )
    public String userDashboard() {
        return "dashboard_user"; // JSP - /WEB-INF/view/index.jsp  -> prefix and suffix provided by ViewResolver
    }

    @RequestMapping(value = "/admin/dashboard" )
    public String adminDashboard() {
        return "dashboard_admin"; // JSP - /WEB-INF/view/index.jsp  -> prefix and suffix provided by ViewResolver
    }

    @RequestMapping(value="/register")
    public String registerUser(@ModelAttribute("command") UserComand cmd, Model m) {
        try {User user = cmd.getUser();
        user.setRole(UserService.ROLE_USER);
        user.setLoginStatus(UserService.LOGIN_STATUS_ACTIVE);
        userService.register(user);
        return "redirect:index?act=reg"; } // JSP  -> LOGIN PAGE
        catch (DuplicateKeyException e) {
            // return to FORM AGAIN
            m.addAttribute("err", "UserName is already registered. Please select another username.");
            return "reg_form";
        }
    }

    @RequestMapping(value="/reg_form")
    public String registrationForm(Model m) {
        //TODO command
        UserComand cmd = new UserComand();
        m.addAttribute("command", cmd);
        return "reg_form"; // JSP
        }


    private void addUserInSession(User u, HttpSession session) {
        session.setAttribute("user", u);
        session.setAttribute("userId", u.getUserId());
        session.setAttribute("user", u.getRole());
    }
}
