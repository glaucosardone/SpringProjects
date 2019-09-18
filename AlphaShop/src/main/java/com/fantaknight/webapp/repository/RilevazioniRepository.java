package com.fantaknight.webapp.repository;

import java.util.List;

import com.fantaknight.webapp.domain.Rilevazioni;

public interface RilevazioniRepository 
{
	List <Rilevazioni> SelTrasmByFilter(String Filtro);
		
	void InsTrasm(Rilevazioni Rilev);
	
	void DelTrasm(String IdTerminale);
}

