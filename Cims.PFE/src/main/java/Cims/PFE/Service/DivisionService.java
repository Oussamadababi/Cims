package Cims.PFE.Service;

import java.util.ArrayList;
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

//		List<Division> listeDivs=new ArrayList();
//		Division div = new Division();
//		div.setId_division(null);
//		div.setNom_divisionAr(null);
//		div.setNom_divisionFr(null);
//		listeDivs.add(div);
       List<Division> dicvs=divisionRepository.getDivisionParStructure(idStructure);
//       for(Division a:dicvs)
//       {
//    	   listeDivs.add(a);
//       }
      

		List<Division> Divisions = new ArrayList<>();
		divisionRepository.getDivisionParStructure(idStructure).forEach(Divisions::add);
		return Divisions;

	}

}
