package com.maxisoriano.conversores.accion;

import java.io.IOException;

import com.maxisoriano.conversores.modelo.ConversorDeMoneda;
import com.maxisoriano.conversores.modelo.ConversorDeTemperatura;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CalcularValorDeTemperatura implements Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		float temperaturaAConvetir=Float.valueOf(request.getParameter("temperatura"));
		String modoAConvertir=request.getParameter("convetir");
		
		ConversorDeTemperatura conversorDeTemperatura=new ConversorDeTemperatura();
		conversorDeTemperatura.setTemperatura(temperaturaAConvetir);
		float valorConvertido=0;
		if(modoAConvertir.equals("Celsius a Fahrenheit")) {
			conversorDeTemperatura.setDesicion(true);
			valorConvertido=conversorDeTemperatura.convetirTemperatura();
		}else {
			conversorDeTemperatura.setDesicion(false);
			valorConvertido=conversorDeTemperatura.convetirTemperatura();
		}
		
		request.setAttribute("resultado",valorConvertido);
		request.setAttribute("temperatura",conversorDeTemperatura.getTemperatura());
		request.setAttribute("tipoDeConversion", modoAConvertir);
		
		return "forward:mostrarConversionTemperatura.jsp";
	}

}
