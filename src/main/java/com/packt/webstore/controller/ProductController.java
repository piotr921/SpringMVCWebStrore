package com.packt.webstore.controller;

import com.packt.webstore.domain.Product;
import com.packt.webstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping()
    public String list(Model model) {
        model.addAttribute("products", productService.getAllProducts());

        return "products";
    }

    @RequestMapping("/all")
    public String allProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());

        return "products";
    }

    @RequestMapping("/{category}")
    public String getProductsByCategory(Model model,
                                        @PathVariable("category") String productCategory) {
        model.addAttribute("products", productService.getProductsByCategory(productCategory));
        return "products";
    }

    @RequestMapping("/filter/{ByCriteria}")
    public String getProductsByFilter(@MatrixVariable(pathVar = "ByCriteria")
                                              Map<String, List<String>> filterParams, Model model) {
        model.addAttribute("products", productService.getProductByFilter(filterParams));
        return "products";
    }

    @RequestMapping("/{category}/{price}")
    public String filterProducts(Model model,
                                 @PathVariable("category") String productCategory,
                                 @MatrixVariable(pathVar = "price") Map<String, List<String>> pricesRange,
                                 @RequestParam("manufacturer") String manufacturer) {

        Set<Product> productsInPriceRange = new HashSet<>();
        productsInPriceRange.addAll(productService.getProductByPriceFilter(pricesRange));

        Set<Product> filteredProducts = productsInPriceRange.stream()
                .filter(product -> productService.getProductsByCategory(productCategory).contains(product))
                .filter(product -> productService.getProductsByManufacturer(manufacturer).contains(product))
                .collect(Collectors.toSet());

        model.addAttribute("products", filteredProducts);

        return "products";
    }

    @RequestMapping("/product")
    public String getProductById(@RequestParam("id") String productId, Model model) {
        model.addAttribute("product", productService.getProductById(productId));
        return "product";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddNewProductForm(Model model) {
        Product newProduct = new Product();
        model.addAttribute("newProduct", newProduct);
        return "addProduct";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddNewProductForm(@ModelAttribute("newProduct") Product newProduct,
                                           BindingResult result,
                                           RedirectAttributes attributes) {
        String[] suppressedFields = result.getSuppressedFields();
        if (suppressedFields.length > 0) {
            throw new RuntimeException("Attempt of binding suppressed fields: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
        }
        productService.addProduct(newProduct);
        attributes.addAttribute("productId", newProduct.getProductId());
        return "redirect:/products/upload";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String getUploadNewPictureForm(@ModelAttribute("productId") String productId,
                                          Model model){
        Product update = new Product();
        model.addAttribute("productId", productId);
        model.addAttribute("update", update);
        return "upload";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String getAddNewUploadPictureForm(@ModelAttribute("productId") String productId,
                                             @ModelAttribute("update") Product update,
                                             BindingResult result,
                                             HttpServletRequest request) {

        MultipartFile picture = update.getPicture();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        System.out.println(rootDirectory + "resources/images/" + productId + ".png");
        if (picture != null && !picture.isEmpty()) {
            try {
                picture.transferTo(new File(rootDirectory + "resources/images/" + productId + ".png"));
            } catch (IOException e) {
                throw new RuntimeException("Failed during saving picture.", e);
            }
        }
        productService.updateProductPicture(productId, picture);
        return "redirect:/products";
    }

//    @RequestMapping(value = "/upload", method = RequestMethod.POST)
//    public String processUploadPicture(@ModelAttribute("productToUpdate") Product product,
//                                       HttpServletRequest request) {
//
//        MultipartFile picture = product.getPicture();
//        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
//        if (picture != null && !picture.isEmpty()) {
//            try {
//                picture.transferTo(new File(rootDirectory + "resources\\images\\" + product.getProductId() + ".png"));
//            } catch (IOException e) {
//                throw new RuntimeException("Failed during saving picture.", e);
//            }
//        }
//        productService.updateProductPicture(product.getProductId(), picture);
//        return "redirect:/products";
//    }

    @InitBinder
    public void initializeBinder(WebDataBinder binder) {
        binder.setDisallowedFields("unitsInOrder", "discontinued");
    }
}
