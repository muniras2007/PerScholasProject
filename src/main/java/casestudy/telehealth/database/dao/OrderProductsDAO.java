package casestudy.telehealth.database.dao;

import casestudy.telehealth.database.entity.OrderProducts;
import casestudy.telehealth.database.entity.Orders;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import java.util.List;

@EnableJpaRepositories
public interface OrderProductsDAO extends JpaRepository<OrderProducts, Long> {
    public List<OrderProducts> findByOrder(Orders order);

    //public OrderProducts findById(@Param("id") Integer id);


}
