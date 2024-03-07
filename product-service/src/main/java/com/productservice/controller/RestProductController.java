package com.productservice.controller;

import com.productservice.model.ProductDTO;
import com.productservice.model.ResponseDataDTO;
import com.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("rest/product")
public class RestProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/finByID/{id}")
    public ResponseEntity<ResponseDataDTO> findByID(@PathVariable Integer id) {
        ResponseDataDTO responseDataDTO = new ResponseDataDTO();
        responseDataDTO.setStatus("Succes");
        responseDataDTO.setData(productService.findOne(id));
        return new ResponseEntity<>(responseDataDTO, HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<ResponseDataDTO> findAllUser() {
        ResponseDataDTO responseDataDTO = new ResponseDataDTO();
        responseDataDTO.setStatus("Succes");
        responseDataDTO.setListData(productService.finAll());
        return new ResponseEntity<>(responseDataDTO, HttpStatus.OK);
    }

    @GetMapping("/active")
    public ResponseEntity<ResponseDataDTO> findUserActive() {
        ResponseDataDTO responseDataDTO = new ResponseDataDTO();
        responseDataDTO.setStatus("Succes");
        responseDataDTO.setListData(productService.findProductActive());
        return new ResponseEntity<>(responseDataDTO, HttpStatus.OK);
    }


    @PostMapping("/save")
    public ResponseEntity<ResponseDataDTO> saveUser(@RequestBody ProductDTO productDTO) {
        ResponseDataDTO responseDataDTO = new ResponseDataDTO();
        responseDataDTO.setStatus("Succes");
        responseDataDTO.setData(productService.saveData(productDTO));
        return new ResponseEntity<>(responseDataDTO, HttpStatus.OK);
    }

    @PostMapping("/non/active")
    public ResponseEntity<ResponseDataDTO> nonActiveUser(@RequestBody ProductDTO productDTO) {
        ResponseDataDTO responseDataDTO = new ResponseDataDTO();
        responseDataDTO.setStatus("Succes");
        responseDataDTO.setData(productService.nonActiveProduct(productDTO));
        return new ResponseEntity<>(responseDataDTO, HttpStatus.OK);
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDataDTO> deleteUser(@PathVariable Integer id) {
        ResponseDataDTO responseDataDTO = new ResponseDataDTO();
        responseDataDTO.setStatus("Succes delete");
        responseDataDTO.setData(productService.deleteProduct(id));
        return new ResponseEntity<>(responseDataDTO, HttpStatus.OK);
    }
}
