/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utn.tacs.grupo2.snake.telegram.operaciones;

import com.utn.tacs.grupo2.snake.telegram.Api;
import com.utn.tacs.grupo2.snake.telegram.OperacionDeTelegram;
import com.utn.tacs.grupo2.snake.telegram.PartesMensajeTelegram;
import com.utn.tacs.grupo2.snake.telegram.vo.CotizacionMonedaVo;

/**
 *
 * @author fiok
 */

public class OperacionDeTelegramPrecio implements OperacionDeTelegram{

    @Override
    public String getResultado(PartesMensajeTelegram parametros) {
        CotizacionMonedaVo cotizacionMonedaVo = Api.getCotizacion(parametros.getMoneda().getNombre());
        
        return "Cotizacion de " + parametros.getMoneda().getNombre() + " en USD: "+String.valueOf(cotizacionMonedaVo.getCotizacionDolar());
    }
    
}
