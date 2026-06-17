package com.viajes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viajes.entity.Ciudad;
import com.viajes.repository.CiudadRepository;

@Service
public class CiudadServiceImpl implements CiudadService {

	@Autowired
	private CiudadRepository repoCiudad;

	@Override
	public List<Ciudad> listar() {
		return repoCiudad.findAll();
	}

}
