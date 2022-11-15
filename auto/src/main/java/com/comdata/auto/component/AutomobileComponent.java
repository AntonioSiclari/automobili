package com.comdata.auto.component;

import java.util.Iterator;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comdata.auto.Repository.AutoRepository;
import com.comdata.auto.model.Automobile;
import com.comdata.auto.model.DTO.AutomobileDTO;

@Service
public class AutomobileComponent {

	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	AutoRepository autoRepository;
	

	
	// auto---->autoDTO
	public AutomobileDTO autoToDTO(Automobile automobile) {
		AutomobileDTO automobileDto = this.modelMapper.map(automobile, AutomobileDTO.class);
		return automobileDto;
	}
	
}
