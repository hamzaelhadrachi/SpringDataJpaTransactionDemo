package com.zerotohero.dto;

import com.zerotohero.entity.PassengerInfos;
import com.zerotohero.entity.PaymentInfos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingRequest {

    private PassengerInfos passengerInfos;
    private PaymentInfos paymentInfos;
}
