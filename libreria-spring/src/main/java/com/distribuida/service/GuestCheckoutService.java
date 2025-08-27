package com.distribuida.service;

import com.distribuida.model.Factura;

public interface GuestCheckoutService {

    Factura checkoutByToken(String token);
}
