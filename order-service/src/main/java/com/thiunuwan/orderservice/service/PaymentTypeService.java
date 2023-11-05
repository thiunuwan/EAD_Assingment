package com.thiunuwan.orderservice.service;

import com.thiunuwan.orderservice.dto.PaymentTypeDTO;
import com.thiunuwan.orderservice.entity.PaymentType;
import com.thiunuwan.orderservice.repository.PaymentTypeRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PaymentTypeService {

    @Autowired
    private PaymentTypeRepo paymentTypeRepo;

    @Autowired
    private ModelMapper modelMapper;


    public String savePaymentType(PaymentTypeDTO paymentTypeDTO) {
        paymentTypeRepo.save(modelMapper.map(paymentTypeDTO, PaymentType.class));
        return "New Payment Type sucessfully added";

    }

    public List<PaymentTypeDTO> getAllPaymentTypes() {
        List<PaymentType> paymentTypeList= paymentTypeRepo.findAll();
        return  modelMapper.map(paymentTypeList, new TypeToken<ArrayList<PaymentTypeDTO>>(){
        }.getType());
    }
}
