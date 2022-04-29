package com.zerotohero.dto;

import com.zerotohero.entity.PassengerInfos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingAknowledgement {

    private String status;
    private double totalFare;
    private String pnrNo;
    private PassengerInfos passengerInfos;
}
