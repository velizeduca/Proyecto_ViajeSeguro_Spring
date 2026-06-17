package com.viajes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viajes.entity.MarcaBus;
import com.viajes.repository.MarcaBusRepository;

@Service
public class MarcaBusServiceImpl implements MarcaBusService{

	@Autowired
	private MarcaBusRepository repoMarcaBus;
	
	@Override
	public List<MarcaBus> listar() {
		return repoMarcaBus.findAll();
	}

}
