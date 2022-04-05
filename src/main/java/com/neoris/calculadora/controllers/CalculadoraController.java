package com.neoris.calculadora.controllers;

import com.neoris.calculadora.service.CalculadoraService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/")
public class CalculadoraController {
    
    @Autowired
    private CalculadoraService calculadora;

    @GetMapping("/suma")
    private Float suma(@RequestParam Float numeroUno, @RequestParam Float numeroDos){
        return calculadora.suma(numeroUno, numeroDos);
    }

    @GetMapping("/resta")
    private Float resta(@RequestParam Float numeroUno, @RequestParam Float numeroDos){
        return calculadora.resta(numeroUno, numeroDos);
    }

    @GetMapping("/division")
    private Float division(@RequestParam Float numeroUno, @RequestParam Float numeroDos){
        return calculadora.division(numeroUno, numeroDos);
    }

    @GetMapping("/multiplicacion")
    private Float multiplicacion(@RequestParam Float numeroUno, @RequestParam Float numeroDos){
        return calculadora.multiplicacion(numeroUno, numeroDos);
    }

    @GetMapping("/inflacion")
    private Double inflacion(@RequestParam Integer yearOfStart, @RequestParam Integer now, @RequestParam Float amount){
        return calculadora.calculaContraInflaccion(yearOfStart, now, amount);
    }



}
