package Cims.PFE.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Cims.PFE.Dao.DivisionRepository;
import Cims.PFE.Entities.Division;

@Service
public class DivisionService {
	@Autowired
	DivisionRepository divisionRepository;

	public List<Division> getDivisionParStructure( long idStructure)
	{
		return divisionRepository.getDivisionParStructure(idStructure);
	}

}
