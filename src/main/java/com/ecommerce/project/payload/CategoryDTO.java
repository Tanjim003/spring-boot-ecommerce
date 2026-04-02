package com.ecommerce.project.payload;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
    @Schema(description = "Category id")
    private Long categoryId;
    @Schema(description = "Category name you wish to create")
    private String categoryName;


}
