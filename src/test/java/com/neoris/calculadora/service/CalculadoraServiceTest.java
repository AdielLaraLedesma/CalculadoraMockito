package com.neoris.calculadora.service;

import com.neoris.calculadora.exceptions.NullException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

/**
 * @author adiel.lara
 */
class CalculadoraServiceTest {

    @InjectMocks
    private CalculadoraService underTest;

    @Mock
    private CalculadoraInflacionImp calculadoraInflacion;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        underTest = new CalculadoraService(calculadoraInflacion);

    }

    @Test
    void addTwoNumbers() {
        //Arrange
        Float numeroUno = 3f;
        Float numeroDos = 6f;
        Float expected = Float.sum(numeroUno, numeroDos);

        //Act
        Float result = underTest.suma(numeroUno, numeroDos);

        //Assert
        assertEquals(expected, result);
    }

    @Test
    void addingANullNumberShouldThrowNullException(){
        //Arrange
        Float numeroUno = 5f;
        Float numeroDos = null;
        String expected = "Los numeros tienen que ser diferentes a null";

        //Act
        NullException result = assertThrows(NullException.class, () -> {
           underTest.suma(numeroUno, numeroDos);
        });

        //Assert
        assertEquals(expected, result.getMessage());
    }

    @Test
    void subtractTwoNumbers() {
        //Arrange
        Float numeroUno = 10f;
        Float numeroDos = 2f;

        Float expected = numeroUno - numeroDos;

        //Act
        Float result = underTest.resta(numeroUno, numeroDos);

        //Assert
        assertEquals(expected, result);
    }

    @Test
    void subtractingANullNumberShouldThrowNullException(){
        //Arrange
        Float numeroUno = 10f;
        Float numeroDos = null;
        String expected = "Los numeros tienen que ser diferentes a null";

        //Act
        NullException result = assertThrows(NullException.class, () -> {
            underTest.resta(numeroUno, numeroDos);
        });

        //Assert
        assertEquals(expected, result.getMessage());
    }

    @Test
    void divideTwoNumbers() {
        //Arrange
        Float numeroUno = 10f;
        Float numeroDos = 2f;

        Float expected = numeroUno / numeroDos;

        //Act
        Float result = underTest.division(numeroUno, numeroDos);

        //Assert
        assertEquals(expected, result);
    }

    @Test
    void dividingANullNumberShouldThrowNullException(){
        //Arrange
        Float numeroUno = 10f;
        Float numeroDos = null;
        String expected = "Los numeros tienen que ser diferentes a null";

        //Act
        NullException result = assertThrows(NullException.class, () -> {
            underTest.division(numeroUno, numeroDos);
        });

        //Assert
        assertEquals(expected, result.getMessage());
    }

    @Test
    void multiplicacion() {
        //Arrange
        Float numeroUno = 10f;
        Float numeroDos = 2f;

        Float expected = numeroUno * numeroDos;

        //Act
        Float result = underTest.multiplicacion(numeroUno, numeroDos);

        //Assert
        assertEquals(expected, result);
    }
    @Test
    void multiplyingANullNumberShouldThrowNullException(){
        //Arrange
        Float numeroUno = 10f;
        Float numeroDos = null;
        String expected = "Los numeros tienen que ser diferentes a null";

        //Act
        NullException result = assertThrows(NullException.class, () -> {
            underTest.multiplicacion(numeroUno, numeroDos);
        });

        //Assert
        assertEquals(expected, result.getMessage());
    }

    @Test
    void shouldReturnFalseWhenGiveNotANulNumber() {
        //Arrage

        //Act
        boolean result = underTest.isNull(2f);

        //Assert
        assertFalse(result);
    }

    @Test
    void shouldReturnTrueWhenGiveANulNumber() {
        //Arrage

        //Act
        boolean result = underTest.isNull(null);

        //Assert
        assertTrue(result);
    }

    @Test
    void calculaContraInflaccion() {
        //Arrange
        double inflacion = 12;
        Float amount = 2000f;
        double expected = 12 * amount;
        when(calculadoraInflacion.calcularInflaccion(anyInt(), anyInt())).thenReturn(inflacion);

        //Act
        double result = underTest.calculaContraInflaccion(1998, 2022, amount);

        //Assert
        assertEquals(expected, result);

    }
}