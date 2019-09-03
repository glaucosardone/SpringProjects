package com.fantaknight.webapp.service;

import java.util.List;

import com.fantaknight.webapp.domain.Movimenti;

public interface MovimentiService 
{
	Movimenti SelMovimentiByCodArt(String CodArt);
	
	List <Movimenti> SelMovimentiByFilter(String Filtro);
	
	List <Movimenti> SelMovimentiByFilter(String Filtro, String OrderBy, String Tipo, String FilterMag);

}
