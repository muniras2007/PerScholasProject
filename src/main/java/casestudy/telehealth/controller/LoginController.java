package casestudy.telehealth.controller;

import casestudy.telehealth.database.dao.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@Controller
public class LoginController {


    @Autowired
    ProductDAO productDAO;
    @RequestMapping(value = "/login/login", method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request, HttpSession session) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("login/login");
        return response;
    }



    @RequestMapping(value = "/login/loginSuccess", method = RequestMethod.GET)
    public ModelAndView onAuthenticationSuccess(HttpServletRequest request,
                                                Authentication authentication ) throws ServletException, IOException {
        ModelAndView response = new ModelAndView();

        Authentication off = SecurityContextHolder.getContext().getAuthentication();

        boolean hasUserRole = authentication.getAuthorities().stream()
                .anyMatch(r -> r.getAuthority().equals("ADMIN"));

        if (hasUserRole){
            response.setViewName("/admin/home");
        } else  {
            response.setViewName("redirect:/productDisplay");
        }

        return response;
    }


    @RequestMapping(value = "/login/logoutSuccess", method = RequestMethod.GET)
    public ModelAndView logoutSuccess(HttpServletRequest request, HttpSession session) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("home/homepage");
        return response;
    }
}
