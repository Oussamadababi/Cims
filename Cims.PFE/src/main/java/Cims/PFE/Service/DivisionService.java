package Cims.PFE.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Cims.PFE.Dao.DivisionRepository;
import Cims.PFE.Entities.Division;
import Cims.PFE.Entities.Grade;

@Service
public class DivisionService {
	@Autowired
	DivisionRepository divisionRepository;

	public List<Division> getDivisionParStructure( long idStructure)
	{
		List<Division> Divisions = new ArrayList<>();
		divisionRepository.getDivisionParStructure(idStructure).forEach(Divisions::add);
		return Divisions;
	}

}
