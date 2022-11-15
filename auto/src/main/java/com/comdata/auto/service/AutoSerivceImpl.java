package com.comdata.auto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.comdata.auto.Repository.AutoRepository;
import com.comdata.auto.component.AutomobileComponent;
import com.comdata.auto.model.Automobile;
import com.comdata.auto.model.DTO.AutomobileDTO;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Data
@Service
@Log4j2
public class AutoSerivceImpl implements AutoService {

	@Autowired
	AutoRepository autoRepository;
	@Autowired
	AutomobileComponent automobileComponent;

	@Override
	public AutomobileDTO inserisciAutomobile(Automobile automobile) {
		try {

			AutomobileDTO automobileDTO = automobileComponent.autoToDTO(automobile);
			autoRepository.save(automobile);
			log.info("inserimento avveneuto correttamente");
			return automobileDTO;
		} catch (Exception e) {
			log.error("errore,contattare l'amministratore di sistema");
			return null;
		}

	}

	@Override
	public AutomobileDTO eliminaAutomobile(Automobile automobile) {
		try {
			AutomobileDTO automobileDTO = automobileComponent.autoToDTO(automobile);
			autoRepository.delete(automobile);
			log.info("modifica avvenenuta correttamente");
			return automobileDTO;
		} catch (Exception e) {
			log.error("errore,contattare l'amministratore di sistema");
			return null;
		}
	}

	@Override
	public AutomobileDTO modificaAutobile(Automobile automobile) {
		try {
			AutomobileDTO automobileDTO = automobileComponent.autoToDTO(automobile);
			autoRepository.save(automobile);
			log.info("modifica avvenenuta correttamente");
			return automobileDTO;
		} catch (Exception e) {
			log.error("errore,contattare l'amministratore di sistema");
			return null;
		}
	}

	@Override
	public List<Automobile> visualizzaAutomobili() {

		try {
			log.info("lettura avvenenuta correttamente");
			return (List<Automobile>) autoRepository.findAll();
		} catch (Exception e) {
			log.error("errore,contattare l'amministratore di sistema");
			return null;
		}

	}

	@Override
	public List<Automobile> visualizzaAutomobiliPaginati(int pagina) {

		try {

			PageRequest paginazione = PageRequest.of(pagina, 5, Sort.by("targa"));
			Page<Automobile> paginazioneElementi = autoRepository.findAll(paginazione);
			log.info("lettura automobili impaginati avvenuta correttamente");
			return (List<Automobile>) paginazioneElementi.toList();
		} catch (Exception e) {

			log.error("errore di lettura ");
			return null;
		}

	}

}
