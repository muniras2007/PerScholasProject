package casestudy.telehealth.form;


import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.Length;



@Getter
@Setter
public class ProductFormBean {

    private Integer id;

    @Length(min = 1, max = 50)
    private String productName;

    @Length(min = 1, max = 100)
    private String productDescription;


    private Integer price;

    private String imageUrl;


    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }


}






