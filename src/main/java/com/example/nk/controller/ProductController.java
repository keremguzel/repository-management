package com.example.nk.controller;

import com.example.nk.dto.ProductRequest;
import com.example.nk.entities.Product;
import com.example.nk.service.ProductService;
import com.example.nk.serviceImpl.FileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@RequestMapping(value="/product")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {
  @Autowired
  FileServiceImpl fileService;
  @Autowired
  ProductService productService;

  @RequestMapping(
      value = "/fileUpload",
      method = RequestMethod.POST,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public String uploadFile(MultipartFile multipartFile) {
    return  fileService.uploadFile(multipartFile);
  }



  @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<Product> addProduct(@RequestBody Product product) {
    return productService.addProduct(product);
  }

 @RequestMapping(value = "/edit", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<Product> editProduct(@RequestBody Product product) {
    return productService.editProduct(product);
  }

 @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<Product> deleteProduct(@RequestBody Long id) {
    return productService.deleteProduct(id);
  }


}
