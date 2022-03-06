package casestudy.telehealth.controller;

import casestudy.telehealth.database.dao.UserDAO;
import casestudy.telehealth.database.entity.User;
import casestudy.telehealth.form.RegisterFormBean;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/registration-url-path")
public class RegistrationController {

    public static final Logger LOG = LoggerFactory.getLogger(RegistrationController.class);


    @Autowired
    private UserDAO userDAO;


    @Autowired
    private PasswordEncoder passwordEncoder;


    @RequestMapping(value = "/userList", method = RequestMethod.GET)
    public ModelAndView UserList(@RequestParam(required = false) String search, @RequestParam(required = false) String firstName,
                                 @RequestParam(required = false) String lastName) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("registration/userList");

        if ( ! StringUtils.isEmpty(search)) {
            List<User> Users = userDAO.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(search,search);
            response.addObject("UserListKey", Users);
            response.addObject("searchInput", search);
        }

        if ( !StringUtils.isEmpty(firstName) && ! StringUtils.isEmpty(lastName)) {
            List<User> Users = userDAO.findByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(firstName,lastName);
            response.addObject("UserListKey", Users);
        }
        return response;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register(@RequestParam(required = false) Integer id ) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("registration/Register");

        if ( id != null ) {

            Optional<User> optionalUser=  userDAO.findById(id);
            User user = optionalUser.get();

            // populate the form bean with the data loaded from the database
            RegisterFormBean form = new RegisterFormBean();

            form.setEmail(user.getEmail());
            form.setFirstName(user.getFirstName());
            form.setLastName(user.getLastName());
            form.setUsername(user.getUsername());
            form.setPassword(user.getPassword());
            form.setConfirmPassword(user.getPassword());
            // since we loaded this from the database we know the id field
            form.setId(user.getId());

            response.addObject("formBeanKey", form);
        } else {
            // an id has not been passed so it is a create
            // there is no data from the database so give an empty form bean
            RegisterFormBean form = new RegisterFormBean();
            response.addObject("formBeanKey", form);
        }

        return response;
    }


    @RequestMapping(value = "/registerSubmit", method = { RequestMethod.POST, RequestMethod.GET })
    public ModelAndView registerSubmit(@Valid RegisterFormBean form, BindingResult errors) throws Exception {
        ModelAndView response = new ModelAndView();

        System.out.println(form);

        if (errors.hasErrors()) {
            for ( FieldError error : errors.getFieldErrors() ) {
                // add the error message to the errorMessages list in the form bean
                form.getErrorMessages().add(error.getDefaultMessage());
                LOG.debug("error field = " + error.getField() + " message = " + error.getDefaultMessage());
            }

            response.addObject("formBeanKey", form);
            response.setViewName("registration/Register");

        } else {
            // there are no errors on the form submission so this is either a create or an update.

            // no matter what we need to create a new user object
            User user;

            if ( form.getId() == null ) {
                // the id is not present in the form bean so we know this is a create
                user  = new User();
            } else {
                // this is an update so we need to load the user from the database first
                Optional<User> optionalUser=  userDAO.findById(form.getId());
                user = optionalUser.get();
               // user = userDAO.findById(form.getId());
            }

            user.setEmail(form.getEmail());
            user.setFirstName(form.getFirstName());
            user.setLastName(form.getLastName());
            //user.setPassword(form.getPassword());
            user.setUsername(form.getUsername());

            // encrypt password
            String encryptedPassword = passwordEncoder.encode(form.getPassword());
            // set encrypted passwords to user object
            user.setPassword(encryptedPassword);
            //user.setConfirmPassword(encryptedPassword);

            userDAO.save(user);

            // response.setViewName("redirect:/login");
            response.setViewName("redirect:/login/login");
        }

        return response;
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public ModelAndView delete(@RequestParam Integer id ) throws Exception {
        ModelAndView response = new ModelAndView();

        response.setViewName("redirect:/registration-url-path/UserList");
        Optional<User> optionalUser=  userDAO.findById(id);
        User delete = optionalUser.get();
        //User delete = userDAO.findById(id);
        if ( delete != null ) {
            userDAO.delete(delete);
        }

        return response;
    }
}