package com.productservice.service;

import com.productservice.model.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProductService {

    public ProductDTO findOne(Integer id);

    public List<ProductDTO> finAll();

    public List<ProductDTO> findProductActive();

    public ProductDTO saveData(ProductDTO productInformationDTO);

    public ProductDTO nonActiveProduct(ProductDTO productInformationDTO);

    public ProductDTO deleteProduct(Integer id);
}
