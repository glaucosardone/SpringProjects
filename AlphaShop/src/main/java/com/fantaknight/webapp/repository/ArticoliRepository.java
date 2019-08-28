package com.fantaknight.webapp.repository;

import java.util.List;

import com.fantaknight.webapp.domain.Articoli;

public interface ArticoliRepository 
{
	List <Articoli> SelArticoliByFilter(String Filtro);
	
	List <Articoli> SelArticoliByFilter(String Filtro, String OrderBy, String Tipo);
		
	void InsArticolo(Articoli articolo);
	
	void DelArticolo(String CodArt);
}
