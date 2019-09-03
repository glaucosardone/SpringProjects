package com.fantaknight.webapp.repository;

import java.util.List;

import com.fantaknight.webapp.domain.Movimenti;

public interface MovimentiRepository 
{
	Movimenti SelMovimentiByCodArt(String CodArt);
	
	List <Movimenti> SelMovimentiByFilter(String Filtro);
	
	List <Movimenti> SelArticoliByFilter(String Filtro, String OrderBy, String Tipo);
}
