package com.codoacodo.flysky.demo.service;

import com.codoacodo.flysky.demo.model.entity.VueloEntity;

import java.util.List;

public interface IVueloService {
    List<VueloEntity> obtenerVuelosDisponibles();
}