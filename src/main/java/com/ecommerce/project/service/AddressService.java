package com.ecommerce.project.service;

import com.ecommerce.project.model.User;
import com.ecommerce.project.payload.AddressDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AddressService {
    AddressDTO createAddress(AddressDTO addressDTO, User user);

    List<AddressDTO> getaddresses();

    AddressDTO getaddressesById(Long addressId);
}
