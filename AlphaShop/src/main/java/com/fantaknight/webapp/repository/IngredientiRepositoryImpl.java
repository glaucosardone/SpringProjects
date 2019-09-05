package com.fantaknight.webapp.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.fantaknight.webapp.domain.Ingredienti;

@Repository
public class IngredientiRepositoryImpl implements IngredientiRepository
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Ingredienti SelIngredientiByCodArt(String CodArt)
	{
		String Sql = "SELECT * FROM INGREDIENTI WHERE CODART = ?";
		
		Ingredienti ingredienti;
		
		try
		{
			ingredienti = jdbcTemplate.queryForObject(Sql, new IngredientiMapper(), CodArt);
		}
		catch (EmptyResultDataAccessException ex)
		{
			System.out.println(ex.getMessage());
			
			ingredienti = new Ingredienti();
		}
	
		return ingredienti;
    } 
    
    @Override
	public void InsIngredienti(Ingredienti ingredienti) 
	{
		String Sql = "EXEC Sp_InsIngredienti ?,?";
		
		jdbcTemplate.update(Sql, ingredienti.getCodArt(), ingredienti.getInfo());
		
    }
    
    @Override
	public void DelIngredienti(String CodArt)
	{
		String Sql = "DELETE FROM INGREDIENTI WHERE CODART = ?";
		
		jdbcTemplate.update(Sql, CodArt);
		
	}

}
