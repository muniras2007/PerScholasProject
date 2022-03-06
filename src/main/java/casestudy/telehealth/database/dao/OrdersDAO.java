package casestudy.telehealth.database.dao;

import casestudy.telehealth.database.entity.Orders;
import casestudy.telehealth.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import javax.persistence.criteria.Order;

public interface OrdersDAO extends JpaRepository<Orders, Integer> {



    public Orders findByUserAndStatus(@Param("User") User user, @Param("status") String status);

    Orders findByUserIdAndStatus(Integer id, String cart);
}
