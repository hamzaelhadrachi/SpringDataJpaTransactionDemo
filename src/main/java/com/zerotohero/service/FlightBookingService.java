package com.zerotohero.service;


import com.zerotohero.dto.FlightBookingAknowledgement;
import com.zerotohero.dto.FlightBookingRequest;
import com.zerotohero.entity.PassengerInfos;
import com.zerotohero.entity.PaymentInfos;
import com.zerotohero.repository.PassengerInfosRepository;
import com.zerotohero.repository.PaymentInfosRepository;
import com.zerotohero.utils.PaymentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class FlightBookingService {

    @Autowired
    private PassengerInfosRepository passengerInfosRepository;
    @Autowired
    private PaymentInfosRepository paymentInfosRepository;

    @Transactional//(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public FlightBookingAknowledgement boockFlightTicket(FlightBookingRequest req){

        PassengerInfos passengerInfos =req.getPassengerInfos();
        passengerInfos = passengerInfosRepository.save(passengerInfos);

        PaymentInfos paymentInfos = req.getPaymentInfos();

        PaymentUtils.validCreditLimit(paymentInfos.getAccountNo(), passengerInfos.getFare());

        paymentInfos.setPassengerId(passengerInfos.getPId());
        paymentInfos.setAmount(passengerInfos.getFare());

        paymentInfosRepository.save(paymentInfos);

        return new FlightBookingAknowledgement("SUCCESS", passengerInfos.getFare(), UUID.randomUUID().toString().split("-")[0], passengerInfos);
    }
}
