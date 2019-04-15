package com.danilo.demomvc.web.conversor;

import java.math.BigDecimal;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToBigDecimal implements Converter<String, BigDecimal> {

	@Override
	public BigDecimal convert(String text) {
		System.out.println("Valor que está chegando: "+text);
		text = text.trim(); //para remover espaço em branco ao final da informação
		String text2 = text.replace(".","");
		System.out.println("Valor sem ponto: "+text2);
		String text3 = text2.replaceAll(",",".");
		System.out.println("Troca da vírgula por ponto: "+text3);
		
				
		
		BigDecimal bd = new BigDecimal(text3);
		System.out.println("Valor que está saindo: "+bd);
		
		return bd;
	}

}
