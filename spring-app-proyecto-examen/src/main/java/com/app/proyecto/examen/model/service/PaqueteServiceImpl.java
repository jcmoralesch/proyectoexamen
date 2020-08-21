package com.app.proyecto.examen.model.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.app.proyecto.examen.model.dao.IPaqueteDao;
import com.app.proyecto.examen.model.entity.Paquete;

@Service
public class PaqueteServiceImpl implements IPaqueteService{
	
	@Autowired
	private IPaqueteDao paqueteDao;

	@Override
	@Transactional
	public void save(Paquete paquete) {
		
		paqueteDao.save(paquete);
		
	}

	@Override
	@Transactional
	public void delete(Long id) {
		paqueteDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Paquete findById(Long id) {
		
		return paqueteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Paquete> findAll() {
		
		return paqueteDao.findAll();
	}

	@Override
	@Transactional
	public String procedureRegistrarPaquete(String paramIn1, Double paramIn2, String paramIn3, String paramIn4,
			String paramIn5) {
		
		paqueteDao.procedureRegistrarPaquete(paramIn1, paramIn2, paramIn3, paramIn4, paramIn5);
		return null;
	}

}
