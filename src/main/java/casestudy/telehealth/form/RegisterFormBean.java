package casestudy.telehealth.form;

import casestudy.telehealth.validation.TwoFieldsAreEqual;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@TwoFieldsAreEqual(fieldOneName = "confirmPassword", fieldTwoName = "password", message = "Password and Confirm Password must be the same.")
public class RegisterFormBean {
    // this is a hidden data value and is only needed to distinguish an edit from a create
    private Integer id;

    // making sure the email is not null and is not empty as in ""
    @NotEmpty(message = "Email is required.")
    @Pattern(regexp = "^.+@.+$" , message = "Invalid email format")
    //@EmailUnique(message = "Email must be unique")
    private String email;

    @Length(min = 1, max = 50,
            message = "First Name must be between 1 and 5 characters in length.")
    private String firstName;

    @NotEmpty(message = "Last Name is required.")
    private String lastName;


    @NotEmpty(message = "Username is required")
    private String username;

    private String password;
    private String confirmPassword;

    // this list is populated by the controller with all error messages
    // in the binding result.
    private List<String> errorMessages = new ArrayList<>();



    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }


}
