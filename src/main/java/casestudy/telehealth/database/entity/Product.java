package casestudy.telehealth.database.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.criteria.Order;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="product_name")
    private String productName;


    @Column(name="price")
    private Integer  price;

    @Column(name="productDescription")
    private String productDescription;

    @Column(name="image_url")
    private String imageUrl;

}
