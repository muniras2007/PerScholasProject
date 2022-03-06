package casestudy.telehealth.controller;


import casestudy.telehealth.database.dao.OrderProductsDAO;
import casestudy.telehealth.database.dao.OrdersDAO;
import casestudy.telehealth.database.dao.ProductDAO;
import casestudy.telehealth.database.dao.UserDAO;
import casestudy.telehealth.database.entity.OrderProducts;
import casestudy.telehealth.database.entity.Orders;
import casestudy.telehealth.database.entity.Product;
import casestudy.telehealth.database.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
public class CartController {

    @Autowired
    ProductDAO productDAO;

    @Autowired
    UserDAO userDAO;

    @Autowired
    OrdersDAO ordersDAO;

    @Autowired
    OrderProductsDAO orderProductsDAO;

    @RequestMapping(value = "/addToCart/{productId}", method = RequestMethod.GET)
    public ModelAndView addToCart(@PathVariable("productId") Integer productId) throws Exception {

        ModelAndView response = new ModelAndView();

        Product product = new Product();

        product = productDAO.findById(productId);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User user = userDAO.findByEmail(currentPrincipalName);
        System.out.println("I am "+user);
        Orders orders = ordersDAO.findByUserAndStatus(user, "cart");

       if (orders==null) {
           orders = new Orders();
           orders.setStatus("cart");

           orders.setUser(user);
           orders = ordersDAO.save(orders);
           Integer orderId = orders.getId();
       }


            OrderProducts orderProducts=new OrderProducts();
            orderProducts.setProduct(product);
            orderProducts.setOrder(orders);
           orderProducts  =orderProductsDAO.save(orderProducts);

            List<OrderProducts> orderProductsList = orderProductsDAO.findByOrder(orders);
            response.addObject("listProducts",orderProductsList);

            response.setViewName("/cart/cart");

        return response;
    }

    @RequestMapping(value = "/checkout", method = RequestMethod.GET)
    public ModelAndView checkout() throws Exception {

        ModelAndView response = new ModelAndView();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User user = userDAO.findByEmail(currentPrincipalName);
          Orders orders = ordersDAO.findByUserIdAndStatus(user.getId(), "cart");
          orders.setStatus("checkedout");
          ordersDAO.save(orders);
          response.setViewName("cart/checkedout");

       return response;

    }

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
   public ModelAndView cartReady() throws Exception {

        ModelAndView response = new ModelAndView();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User user = userDAO.findByEmail(currentPrincipalName);
        System.out.println("I am "+user);
        if(user!=null) {
            Orders orders = ordersDAO.findByUserAndStatus(user, "cart");
            System.out.println("I'm buying"+ orders);
           if(orders!=null) {
               List<OrderProducts> orderProductsList = orderProductsDAO.findByOrder(orders);
               System.out.println("I'm "+ orderProductsList);

               response.addObject("listProducts", orderProductsList);
           }
        }

        response.setViewName("/cart/cart");
        return response;
    }
}







