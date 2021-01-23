package com.jdutton.fibonacci.controllers;

import com.jdutton.fibonacci.domain.FibonacciErrorInfo;
import com.jdutton.fibonacci.domain.FibonacciNumber;
import com.jdutton.fibonacci.domain.FibonacciSequence;
import com.jdutton.fibonacci.exceptions.FibonacciServiceException;
import com.jdutton.fibonacci.service.FibonacciService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@Tag(name="fibonacci-service", description="Servicio REST para tratamiento de la serie de Fibonacci. Permite obtener una " +
    "serie de Fibonacci hasta un valor de 22390 (configurable en application.properties), obtener la misma serie desde 0 " +
    "hasta el número tope suministrado y también obtener el valor de Fibonacci concreto para una posición determinada.")
public class FibonacciController {


    private final FibonacciService fibonacciService;
    
    public FibonacciController(FibonacciService fibonacciService) {
        super();
        this.fibonacciService = fibonacciService;
    }

    /**
     * Permite obtener la serie de Fibonacci hasta el n&uacute;mero 22390, o el que se haya configurado en application.properties.
     * Hay que tener en cuenta que si se intenta obtener la secuencia hasta un n&uacute;mero demasiado alto, corremos el
     * riesgo de tener un OutOfMemoryError. El servicio est&aacute; blindado contra esta posibilidad, pero en este caso no se
     * obtiene ning&uacute;n resultado.
     *
     * @return {@link ResponseEntity} con el resultado
     */
    @Operation(summary = "Devuelve la serie de Fibonacci", description = "Lista la serie completa de Fibonacci hasta el número 22390. El resultado es un JSON de unos 50Mb de tamaño." +
    "Se ha escogido este tamaño porque no produce un OutOfMemoryError")
    @GetMapping("/fibonacci")
    public ResponseEntity<Object> getFibonacciSequence()  {
        FibonacciSequence sequence;
        try {
            sequence = fibonacciService.getFibonacciSequence();
        } catch (FibonacciServiceException e) {
            return new ResponseEntity<>(new FibonacciErrorInfo(503, e), HttpStatus.SERVICE_UNAVAILABLE);
        }

        return new ResponseEntity<>(sequence, HttpStatus.OK);
    }

    /**
     * Permite obtener la serie de Fibonacci hasta el n&uacute;mero indicado por el argumento topNumber.
     * Hay que tener en cuenta que si se intenta obtener la secuencia hasta un n&uacute;mero demasiado alto, corremos el
     * riesgo de tener un OutOfMemoryError. El servicio est&aacute; blindado contra esta posibilidad, pero en este caso no se
     * obtiene ning&uacute;n resultado.
     *
     * @param topNumber N&uacute;mero final de la serie.
     * @return {@link ResponseEntity} con el resultado
     */
    @Operation(summary = "Devuelve la serie de Fibonacci desde 0 hasta el número suministrado",
            description = "Lista la serie completa de Fibonacci hasta el número que se pasa como argumento. Hay que tener en cuenta" +
                    " que si se introduce un número demasiado grande podemos tener un OutOfMemoryError. En este caso se devolverá un " +
                    " error 503 de Servidor no disponible")
    @GetMapping("/fibonacci/{topNumber}")
    public ResponseEntity<Object> getFibonacciSequence(@PathVariable Integer topNumber)  {
        FibonacciSequence sequence;
        try {
            sequence = fibonacciService.getFibonacciSequence(topNumber);
        } catch (FibonacciServiceException e) {
            return new ResponseEntity<>(new FibonacciErrorInfo(409, e), HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(sequence, HttpStatus.OK);
    }

    /**
     * Permite obtener el n&uacute;mero de Fibonacci correspondiente al n&uacute;mero suministrado como argumento.
     * El c&aacute;lculo se basa en la formula de Binet. https://matebut.com/sucesion-de-fibonacci-y-la-formula-de-binet
     *
     * @param postion N&uacute;mero del que se quiere obtener el Fibonacci correspondiente.
     * @return {@link ResponseEntity} con el n&uacute;mero
     */
    @Operation(summary = "Devuelve el valor de Fibonacci para el número indicado",
            description = "Teniendo en cuenta que la serie comienza en 0, devolverá el valor correspondiente al número suministrado. Por ejemplo, si se suministra como parámetro el 10, devolverá el 55")
    @GetMapping("/fibonacci/number/{position}")
    public ResponseEntity<Object> getFibonacciNumber(@PathVariable Integer position) {
        FibonacciNumber result;
        try {
            result = fibonacciService.getFibonacciNumber(position);
        } catch (FibonacciServiceException e) {
            return new ResponseEntity<>(new FibonacciErrorInfo(409, e), HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
