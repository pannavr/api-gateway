package com.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {
    private int productId;
    private String productName;
    private String description;
    private Integer productStock;
    private BigDecimal productPrice;
    private Integer isActive;
    private Date createDate;
    private Date modifiedDate;
}
