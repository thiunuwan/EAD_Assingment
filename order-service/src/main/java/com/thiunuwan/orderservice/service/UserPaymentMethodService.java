package com.thiunuwan.orderservice.service;


import com.thiunuwan.orderservice.dto.UserPaymentMethodRequestDTO;
import com.thiunuwan.orderservice.dto.UserPaymentMethodResponseDTO;
import com.thiunuwan.orderservice.entity.PaymentType;
import com.thiunuwan.orderservice.entity.UserPaymentMethod;
import com.thiunuwan.orderservice.repository.PaymentTypeRepo;
import com.thiunuwan.orderservice.repository.UserPaymentMethodRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserPaymentMethodService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserPaymentMethodRepo userPaymentMethodRepo;

    @Autowired
    private PaymentTypeRepo paymentTypeRepo;

    public String saveUserPaymentMethod(UserPaymentMethodRequestDTO userPaymentMethodRequestDTO) {

        PaymentType mappedPaymentType = paymentTypeRepo.findById(userPaymentMethodRequestDTO.getPayment_type_id()).orElseThrow(()-> new RuntimeException("Payment Type not found"));

//        userPaymentMethodRepo.save(modelMapper.map(userPaymentMethodDTO, UserPaymentMethod.class));

        UserPaymentMethod newUserPaymentMethod = new UserPaymentMethod();

        newUserPaymentMethod.setUser_id(userPaymentMethodRequestDTO.getUser_id());
        newUserPaymentMethod.setPaymentType(mappedPaymentType);
        newUserPaymentMethod.setAccount_num(userPaymentMethodRequestDTO.getAccount_num());
        newUserPaymentMethod.setExpiry_date(userPaymentMethodRequestDTO.getExpiry_date());
//        newUserPaymentMethod.set_default(false);


        userPaymentMethodRepo.save(newUserPaymentMethod);
        return "User Payment Method saved sucessfully";
    }

    public List<UserPaymentMethodResponseDTO> getAllUserPaymentMethods() {
        List<UserPaymentMethod> userPaymentMethodList= userPaymentMethodRepo.findAll();
        return  modelMapper.map(userPaymentMethodList, new TypeToken<ArrayList<UserPaymentMethodResponseDTO>>(){
        }.getType());
    }
}
