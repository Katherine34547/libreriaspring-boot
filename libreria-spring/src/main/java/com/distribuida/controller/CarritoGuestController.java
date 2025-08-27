package com.distribuida.controller;

import com.distribuida.model.Carrito;
import com.distribuida.service.CarritoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/guest/cart")
public class CarritoGuestController {

    private final CarritoService carritoService;

    public CarritoGuestController(CarritoService carritoService){
        this.carritoService = carritoService;
    }

    @PostMapping
    public ResponseEntity<Carrito> createOrGet(@RequestParam String token){
        return ResponseEntity.ok(carritoService.getOrCreateByToken(token));
    }

    @GetMapping
    public ResponseEntity<Carrito> get(@RequestParam String token){
        return ResponseEntity.ok(carritoService.getByToken(token));
    }

    @PostMapping("/items")
    public ResponseEntity<Carrito> addItem(@RequestParam String token,
                                           @RequestBody Map<String, Integer> body
                                           ){
        int lilbroId = body.getOrDefault("libroId ", 0);
        int cantidad = body.getOrDefault("cantidad", 0);
        return  ResponseEntity.ok(carritoService.addItem(token, lilbroId, cantidad));

    }

    @PutMapping("/item/{carritoItemId}")
    public ResponseEntity<Carrito> update(@RequestParam String token,
                                          @PathVariable long carritoItemId,
                                          @RequestBody Map<String, Integer> body
                                          ){
        int cantidad = body.getOrDefault("cantidad", 0);
        return ResponseEntity.ok(carritoService.updateItemCantidad(token, carritoItemId, cantidad));

    }

}
