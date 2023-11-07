package com.thiunuwan.orderservice.service;


import com.thiunuwan.orderservice.dto.PaymentTypeDTO;
import com.thiunuwan.orderservice.dto.UserPaymentMethodDTO;
import com.thiunuwan.orderservice.entity.PaymentType;
import com.thiunuwan.orderservice.entity.UserPaymentMethod;
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

    public String saveUserPaymentMethod(UserPaymentMethodDTO userPaymentMethodDTO) {
        userPaymentMethodRepo.save(modelMapper.map(userPaymentMethodDTO, UserPaymentMethod.class));
        return "User Payment Method saved sucessfully";
    }

    public List<UserPaymentMethodDTO> getAllUserPaymentMethods() {
        List<UserPaymentMethod> userPaymentMethodList= userPaymentMethodRepo.findAll();
        return  modelMapper.map(userPaymentMethodList, new TypeToken<ArrayList<UserPaymentMethodDTO>>(){
        }.getType());
    }
}
