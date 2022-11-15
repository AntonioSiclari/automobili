package com.comdata.auto.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.comdata.auto.model.Automobile;
import com.comdata.auto.model.DTO.AutomobileDTO;

public interface AutoService {

	
	//metodi di DB
	
	public AutomobileDTO inserisciAutomobile(Automobile automobile);
	
	public AutomobileDTO eliminaAutomobile(Automobile automobile);
	
	public AutomobileDTO modificaAutobile(Automobile automobile);
	
	public List<Automobile> visualizzaAutomobili();
	
	public List<Automobile> visualizzaAutomobiliPaginati(int pagina);
}
