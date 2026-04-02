package com.ecommerce.project.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    @Schema(description = "Product id ")
    private Long productId;
    @Schema(description = "Name of the product you wish to create")
    private String productName;
    @Schema(description = "Add an image of you product")
    private String image;
    @Schema(description = "Description about the product")
    private String description;
    @Schema(description = "Product quantity")
    private Integer quantity;
    @Schema(description = "Price of the product ")
    private double price;
    @Schema(description = "Discount if you want to add in product")
    private double discount;
    private double specialPrice;

}
