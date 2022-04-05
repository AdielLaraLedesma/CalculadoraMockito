package com.neoris.calculadora.service;

import com.neoris.calculadora.exceptions.NullException;

import org.springframework.beans.factory.annotation.Autowired;

public class CalculadoraService {
    
    @Autowired
    private IInflacion calculadoraInflacion;


    public Float suma(Float numeroUno, Float numeroDos){
        if(isNull(numeroUno) || isNull(numeroDos))
            throw new NullException("Los numeros tienen que ser diferentes a null");
        return Float.sum(numeroUno, numeroDos);
    }

    public Float resta(Float numeroUno, Float numeroDos){
        if(isNull(numeroUno) || isNull(numeroDos))
            throw new NullException("Los numeros tienen que ser diferentes a null");
        return numeroUno-numeroDos;
    }

    public Float division(Float numeroUno, Float numeroDos){
        if(isNull(numeroUno) || isNull(numeroDos))
            throw new NullException("Los numeros tienen que ser diferentes a null");
        return numeroUno/numeroDos;
    }

    public Float multiplicacion(Float numeroUno, Float numeroDos){
        if(isNull(numeroUno) || isNull(numeroDos))
            throw new NullException("Los numeros tienen que ser diferentes a null");
        return numeroUno*numeroDos;
    }

    public boolean isNull(Float numero){
        return numero == null;
    }


    public double calculaContraInflaccion(Integer yearOfStart, Integer now, Float amount){

        Double inflacion = calculadoraInflacion.calcularInflaccion(yearOfStart, now);

        return amount*inflacion;
    }

}
