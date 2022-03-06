package casestudy.telehealth.database.dao;

import casestudy.telehealth.database.entity.Product;
import casestudy.telehealth.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductDAO extends JpaRepository <Product,Long>{

    public List<Product> findByProductName(@Param("productName") String productName);
    public List<Product> findByProductNameContainingIgnoreCase(@Param("productName") String productName);
    //public Product findById(int productId);
    public Product findById(@Param("id") Integer id);

    @Query(value="Select p.* FROM  Product p inner join order_products op on p.id = op.product_id where op.id=:productId",nativeQuery=true)
    public List<Product> allProductsInCart(@Param("productId") Integer productId);

}
