package com.hackathongestamp2020.Backend;

public class VentasNotFoundException extends RuntimeException {

    VentasNotFoundException(String id) {
        super("Could not find customer " + id);
    }
}
