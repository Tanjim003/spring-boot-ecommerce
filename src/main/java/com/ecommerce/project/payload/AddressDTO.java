package com.ecommerce.project.payload;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
    @Schema(description = "User Address id uses in adding order ")
    private Long addressId;
    @Schema(description = "User Address street uses in adding order ")
    private String street;
    @Schema(description = "User Building name uses in adding order ")
    private String buildingName;
    @Schema(description = "User city")
    private String city ;
    @Schema(description = "User State")
    private String state;
    @Schema(description = "User Country")
    private String country;
    @Schema(description = "User area pincode")
    private String pincode;
}
