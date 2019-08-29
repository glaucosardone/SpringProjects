package com.fantaknight.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fantaknight.webapp.domain.Articoli;
import com.fantaknight.webapp.service.ArticoliService;

@Controller
@RequestMapping("/articoli")
public class ArticoliController 
{
	@Autowired
	private ArticoliService articoliService;
	
	@RequestMapping(value = "/cerca/{filter}", method = RequestMethod.GET)
	public String GetArticoliByFilter(@PathVariable("filter") String Filter, Model model)
	{
		List<Articoli> articoli = articoliService.SelArticoliByFilter(Filter);
		
		model.addAttribute("Articoli", articoli);
		
		return "articoli";

	}
	
}
