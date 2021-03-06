package com.utn.tacs.grupo2.snake.controller;

import com.utn.tacs.grupo2.snake.repository.MonedaRepository;
import com.utn.tacs.grupo2.snake.vo.CotizacionMonedaVo;
import com.utn.tacs.grupo2.snake.vo.MonedaVo;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MonedaRestController {

    private final MonedaRepository monedaRepository;

    @GetMapping("/monedas")
    public List<MonedaVo> obtenerTodas() {
        ArrayList<MonedaVo> monedas = new ArrayList<>();

        monedas.add(new MonedaVo("Bitcoin"));
        monedas.add(new MonedaVo("Ethereum"));

        return monedas;
    }

    @GetMapping("/monedas/{nombreMoneda}/cotizacion")
    public CotizacionMonedaVo obtenerCotizacion(@PathVariable String nombreMoneda) {
        return monedaRepository.obtener(nombreMoneda);
    }
}
