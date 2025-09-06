package com.distribuida.controller;

import com.distribuida.model.Factura;
import com.distribuida.service.GuestCheckoutService;
import com.distribuida.service.GuestCheckoutServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/guest/checkout")
public class GuestCheckoutController {

    private final GuestCheckoutService service;

    public GuestCheckoutController(GuestCheckoutService service){
        this.service= service;
    }

    @PostMapping
    public ResponseEntity<Factura> chechlout(@RequestParam String token){
        return ResponseEntity.ok(service.checkoutByToken(token));
    }
}
