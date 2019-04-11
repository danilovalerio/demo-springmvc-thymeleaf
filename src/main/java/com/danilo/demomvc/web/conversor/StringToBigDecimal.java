package com.danilo.demomvc.web.conversor;

import java.math.BigDecimal;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

//@Component
public class StringToBigDecimal implements Converter<String, BigDecimal> {

	@Override
	public BigDecimal convert(String text) {
		//text = text.trim(); //para remover espaço em branco ao final da informaçaõ 		
		BigDecimal bd = new BigDecimal(text = text.trim());
		return bd;
	}

}
