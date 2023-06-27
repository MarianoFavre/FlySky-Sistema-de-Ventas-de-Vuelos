package com.codoacodo.flysky.demo.controller;

import com.codoacodo.flysky.demo.service.IVueloService;
import com.codoacodo.flysky.demo.service.VueloServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/vuelos")
public class VueloController {
    private IVueloService vueloService;

    public VueloController(VueloServiceImpl vueloService) {
        this.vueloService = vueloService;
    }

    @GetMapping("disponibles")
    public ResponseEntity<?> verListaDeVuelosDisponibles() {
        return new ResponseEntity<>(vueloService.obtenerVuelosDisponibles(), HttpStatus.OK);
    }

}