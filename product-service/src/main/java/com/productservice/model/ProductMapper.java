package com.productservice.model;

import com.productservice.entity.Product;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class ProductMapper {
    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public ProductDTO toDTO(Product product) {
        ProductDTO productDTO =  new ProductDTO();
        if (product == null) {
            return productDTO; // or throw an exception, depending on your requirements
        }
        ModelMapper modelMapper = new ModelMapper();
        productDTO = modelMapper.map(product, ProductDTO.class);
        return productDTO;
    }

    public List<ProductDTO> toDTOList(List<Product> productList) {
        if (productList == null) {
            return null; // or throw an exception, depending on your requirements
        }
        return productList.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public  Product toEntity(ProductDTO productInformationDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Product productInformation = modelMapper.map(productInformationDTO, Product.class);
        return productInformation;
    }
}
