package com.neoris.calculadora.service;

import org.springframework.stereotype.Service;

@Service
public class CalculadoraInflacionImp implements IInflacion{

    @Override
    public Double calcularInflaccion(Integer yearOfStart, Integer now) {
        Double inflacion = Double.valueOf(0);
        for (int i=yearOfStart; i< now; i++){
            inflacion += 1.2;
        }
        return inflacion;
    }
    
}
