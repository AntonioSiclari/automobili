package com.comdata.auto.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.comdata.auto.model.Automobile;
import com.comdata.auto.model.DTO.AutomobileDTO;
import com.comdata.auto.service.AutoSerivceImpl;

@RestController
public class AutomobileController {

	@Autowired
	AutoSerivceImpl autoServiceImpl;

	@PostMapping("/api/crud/inserisci")
	public AutomobileDTO inserisci(@Valid @RequestBody Automobile automobile) {
		return autoServiceImpl.inserisciAutomobile(automobile);

	}

	@PutMapping("/api/crud/modifica")
	public AutomobileDTO modifica(@Valid @RequestBody Automobile automobile) {
		return autoServiceImpl.modificaAutobile(automobile);
	}

	@DeleteMapping("/api/crud/elimina")
	public AutomobileDTO elimina(@RequestBody Automobile automobile) {
		return autoServiceImpl.eliminaAutomobile(automobile);

	}

	@GetMapping("/api/crud/lista")
	public List<Automobile> lista() {
		return autoServiceImpl.visualizzaAutomobili();
	}

	@GetMapping("/api/crud/lista/paginazione")
	public List<Automobile> listaPaginazione(@RequestParam int pagina) {
		return autoServiceImpl.visualizzaAutomobiliPaginati(pagina);
	}
}
