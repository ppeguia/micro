package com.interware.microservicios.ctl;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.interware.microservicios.ctl.response.CurrencyConversionBean;

import io.swagger.annotations.Api;

@Api(value = "Convertidor de dinero")
@RestController
public class CurrencyConversionController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
			
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to,
	      @PathVariable BigDecimal quantity) {
		logger.info("Controler: CurrencyConversionController - Metodo: convertCurrency - START"); 
		BigDecimal cMoneyFrom = new  BigDecimal(20);
		BigDecimal cMoneyResultado = quantity.multiply(cMoneyFrom);
	    CurrencyConversionBean response = new CurrencyConversionBean( 1L, from, to, quantity, cMoneyFrom, cMoneyResultado) ;

	    logger.info("Controler: CurrencyConversionController - Metodo: convertCurrency - END");
	    return response;
	}
	
}