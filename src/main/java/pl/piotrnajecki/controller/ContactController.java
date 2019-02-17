package pl.piotrnajecki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.piotrnajecki.domain.Contact;
import pl.piotrnajecki.domain.User;
import pl.piotrnajecki.services.ContactService;

import javax.servlet.http.HttpSession;

@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;

    @RequestMapping(value = "/user/contact_form")
    public String contactForm(Model m) {
        Contact contact = new Contact();
        m.addAttribute("command", m);
        return "contact_form";  // JSP-FORM-VIEW
    }

    @RequestMapping(value = "/user/save_contact")
    public String saveContact(@ModelAttribute("command") Contact c, Model m, HttpSession session) {
        try {Integer userId = (Integer) session.getAttribute("userId");
        c.setUserId(userId);  // FK  logged in userId
        contactService.save(c);
        m.addAttribute("command", m);
        return "redirect:clist?act=save"; } // redirect user to conatc list url }
        catch (Exception e) {
            m.addAttribute("err", "Failed to save contact");
            return "contact_form";
        }
        }


    @RequestMapping(value = "/user/save_contact")
    public String saveOrUpdateContact(@ModelAttribute("command") Contact c, Model m, HttpSession session) {
        Integer contactId = (Integer)session.getAttribute("ContactId");
        if (contactId==null) {
            // save task
            try {Integer userId = (Integer) session.getAttribute("userId");
                c.setUserId(userId);  // FK  logged in userId
                contactService.save(c);
                m.addAttribute("command", m);
                return "redirect:clist?act=save"; } // redirect user to conatc list url }
            catch (Exception e) {
                m.addAttribute("err", "Failed to save contact");
                return "contact_form";
            }
        } else {
            // update task
            try {
                c.setContactId(contactId);  // FK  logged in userId
                contactService.update(c);
                return "redirect:clist?act=save"; } // redirect user to conatact list url }
            catch (Exception e) {
                m.addAttribute("err", "Failed to Edit contact");
                return "contact_form";
            }
        }


    }

    @RequestMapping(value = "/user/clist")
    public String contactList(Model m, HttpSession session) {
        User userObject = (User) session.getAttribute("userId");
        Integer userId = userObject.getUserId();
        m.addAttribute("contactList", contactService.findUserContact(userId));
//        Contact contact = new Contact();
//        m.addAttribute("command", m);
        return "clist";  // JSP Page
    }

    @RequestMapping(value = "/user/del_contact")
    public String deleteContact(@RequestParam("cid") Integer contactId) {
        contactService.delete(contactId);
        return "redirect:clist?act=del";
    }

    @RequestMapping(value = "/user/edit_contact")
    public String prepareEditForm(Model m, HttpSession session, @RequestParam("cid") Integer contactId) {
        session.setAttribute("aContactId", contactId);
        Contact c = contactService.findById(contactId);
        m.addAttribute("command", c);
        return "redirect:clist?act=edit";
    }


}



