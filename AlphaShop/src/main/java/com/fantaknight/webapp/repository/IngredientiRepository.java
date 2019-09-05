package com.fantaknight.webapp.repository;

import com.fantaknight.webapp.domain.Ingredienti;

public interface IngredientiRepository
{
	Ingredienti SelIngredientiByCodArt(String CodArt);
	
	void InsIngredienti(Ingredienti ingredienti);
	
	void DelIngredienti(String CodArt);
}