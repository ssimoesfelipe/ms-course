package com.ssimoesfelipe.hrpayroll.resources;

import com.ssimoesfelipe.hrpayroll.entities.Payment;
import com.ssimoesfelipe.hrpayroll.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentResources {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long workerId,@PathVariable Integer days){
        Payment payment = paymentService.getPayment(workerId,days);
        return ResponseEntity.ok(payment);
    }


}
