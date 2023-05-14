package com.maxisoriano.conversores.accion;

import java.io.IOException;
import java.util.List;

import com.maxisoriano.conversores.modelo.ConversorDeMoneda;
import com.maxisoriano.conversores.modelo.MonedaExtranjera;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class IndexConversorTemperatura implements Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return "forward:conversorDeTemperatura.jsp";
	}

}
