package casestudy.telehealth.controller;



import casestudy.telehealth.database.dao.UserRoleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import org.springframework.security.access.prepost.PreAuthorize;


@PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
@Controller
public class UserController {

    @Autowired
    private UserRoleDAO userRoleDAO;

    @RequestMapping(value = "/loginSuccess", method = RequestMethod.GET)
    public ModelAndView onAuthenticationSuccess(HttpServletRequest request,
                                                Authentication authentication) throws ServletException, IOException {
        ModelAndView response = new ModelAndView();

        Authentication off = SecurityContextHolder.getContext().getAuthentication();

        boolean hasUserRole = authentication.getAuthorities().stream()
                .anyMatch(r -> r.getAuthority().equals("ADMIN"));

        if (hasUserRole) {
            response.setViewName("/admin/home");
        } else {
            response.setViewName("/user/home");
        }

        return response;
    }
}





