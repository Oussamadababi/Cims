package Cims.PFE.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Cims.PFE.Entities.Service1;

import Cims.PFE.Dao.ServiceRepository;


@Service
public class ServiceService {
	@Autowired
	ServiceRepository serviceRepository;
	
	public List<Cims.PFE.Entities.Service1> listAll(){

		return serviceRepository.findAll();
	}
	public List<Service1> getServiceParDivision( long idDivision)
	{

		List<Service1> Services = new ArrayList<>();
		serviceRepository.getServiceParDivision(idDivision).forEach(Services::add);
		return Services;

	}

}
