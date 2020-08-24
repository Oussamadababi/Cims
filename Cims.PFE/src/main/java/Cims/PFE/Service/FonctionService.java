package Cims.PFE.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Cims.PFE.Dao.FonctionRepository;
import Cims.PFE.Entities.Fonction;

@Service
public class FonctionService {
	
	@Autowired
	FonctionRepository FR;
	
	public Fonction save(Fonction c) {
		return FR.save(c);
	}

	public List<Fonction> listAll() {
		List<Fonction> Fonctions = new ArrayList<>();
		FR.findAll().forEach(Fonctions::add);
		return Fonctions;
	}

}
