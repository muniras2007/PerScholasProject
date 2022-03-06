package casestudy.telehealth.controller;

import casestudy.telehealth.database.dao.ProductDAO;
import casestudy.telehealth.database.entity.Product;
import casestudy.telehealth.form.ProductFormBean;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;



@Controller
public class ProductController {


    @Autowired

    private ProductDAO productDAO;

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public ModelAndView addProduct() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("product/product");
        return response;
    }

    @RequestMapping(value = "/productSubmit", method = {RequestMethod.POST})
    public ModelAndView productSubmit(@Valid ProductFormBean pform) throws Exception {
        ModelAndView response = new ModelAndView();

        System.out.println(pform);


        response.addObject("productBeanKey", pform);
        response.setViewName("redirect:/productList");


        // the id is not present in the form bean so we know this is a create
        Product product = new Product();

        product.setId(pform.getId());
        product.setProductName(pform.getProductName());
        product.setPrice(pform.getPrice());
        product.setProductDescription(pform.getProductDescription());
        product.setImageUrl(pform.getImageUrl());


        productDAO.save(product);


        return response;
    }

    @RequestMapping(value = "/productList", method = RequestMethod.GET)
    public ModelAndView Listproduct() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("product/productList");

        List<Product> productList = productDAO.findAll();

        response.addObject("productList", productList);
        return response;
    }

    @RequestMapping(value = "/productDisplay", method = RequestMethod.GET)
    public ModelAndView displayProduct(@RequestParam(required = false) String search) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("product/productDisplay");

        if (!StringUtils.isEmpty(search)) {
            List<Product> products = productDAO.findByProductNameContainingIgnoreCase(search);
            response.addObject("productListKey", products);
            response.addObject("searchInput", search);
        }else{
            List<Product> productDisplay = productDAO.findAll();

            response.addObject("productDisplay", productDisplay);
        }


        return response;


    }


    @RequestMapping(value = "/productListSearch", method = RequestMethod.GET)
   public ModelAndView userList(@RequestParam(required = false) String search) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("product/productDisplay");

        if (!StringUtils.isEmpty(search)) {
            List<Product> products = productDAO.findByProductNameContainingIgnoreCase(search);
            response.addObject("productListKey", products);
            response.addObject("searchInput", search);
        }

        return response;
    }


    @RequestMapping(value="/totalProductDisplay/show", method=RequestMethod.GET)

    public ModelAndView totalProductDisplay(Model model, @RequestParam(required = false) Integer productId)throws Exception{
        ModelAndView response = new ModelAndView();

        System.out.println("Product Id = " + productId);

        Product product = productDAO.findById(productId);
        model.addAttribute("product", product);

        response.setViewName("product/totalProductDisplay");
        //System.out.println("we are working");

        return response;
    }

    @RequestMapping(value = "/deleteProduct", method = RequestMethod.GET)
    public ModelAndView delete(@RequestParam(required = false) Integer id ) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("redirect:/productList");

        Product delete = productDAO.findById(id);

        if ( delete != null ) {
            productDAO.delete(delete);
        }
        return response;
    }


    @RequestMapping(value = "/editProduct", method = RequestMethod.GET)
    public ModelAndView edit(@RequestParam(required = false) Integer id,@Valid ProductFormBean pform) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("product/product");

        Product edit = productDAO.findById(id);
        response.addObject("productBeanKey", pform);


        pform.setProductName(edit.getProductName());
        pform.setPrice(edit.getPrice());
        pform.setProductDescription(edit.getProductDescription());
        pform.setImageUrl(edit.getImageUrl());

        return response;
    }

}


