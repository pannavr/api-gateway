package com.productservice.service.ProductServiceImp;

import com.productservice.entity.Product;
import com.productservice.model.ProductDTO;
import com.productservice.model.ProductMapper;
import com.productservice.repository.ProductRepository;
import com.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProducServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductMapper productMapper;

    @Override
    public ProductDTO findOne(Integer id) {
        return productMapper.toDTO(productRepository.findById(id).orElse(null));
    }

    @Override
    public List<ProductDTO> finAll() {
        return productMapper.toDTOList(productRepository.findAll());
    }

    @Override
    public List<ProductDTO> findProductActive() {
        List<Product> productInformation = productRepository.findAll().stream().filter(product -> product.getIsActive().equals(0)).toList();
        return productMapper.toDTOList(productInformation);    }

    @Override
    public ProductDTO saveData(ProductDTO productInformationDTO) {
        productRepository.save(productMapper.toEntity(productInformationDTO));
        return productInformationDTO;    }

    @Override
    public ProductDTO nonActiveProduct(ProductDTO productDTO) {
        if( productRepository.findById(productDTO.getProductId()).orElse(null) == null ){
            throw new RuntimeException("Product "+ productDTO.getProductId() +" tidak ditemukan");
        }
        Product product = productMapper.toEntity(productDTO);
        product.setIsActive(1);
        productDTO.setIsActive(1);
        productRepository.save(product);
        return productDTO;
    }

    @Override
    public ProductDTO deleteProduct(Integer id) {
        ProductDTO productInformationDTO = productMapper.toDTO(productRepository.findById(id).orElse(null));
        productRepository.deleteById(id);
        return productInformationDTO;
    }
}
