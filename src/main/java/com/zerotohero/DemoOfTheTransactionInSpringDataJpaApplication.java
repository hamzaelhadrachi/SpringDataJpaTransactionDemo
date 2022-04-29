package com.zerotohero;

import com.zerotohero.dto.FlightBookingAknowledgement;
import com.zerotohero.dto.FlightBookingRequest;
import com.zerotohero.service.FlightBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableTransactionManagement
public class DemoOfTheTransactionInSpringDataJpaApplication {

	@Autowired
	private FlightBookingService service;
	@PostMapping("/bookFlightTicket")
	public FlightBookingAknowledgement bookFlight(@RequestBody FlightBookingRequest request){
		System.out.println(request.getPaymentInfos());
		System.out.println(request.getPassengerInfos());
		return service.boockFlightTicket(request);
	}
	public static void main(String[] args) {
		SpringApplication.run(DemoOfTheTransactionInSpringDataJpaApplication.class, args);
	}

}
