package Cims.PFE.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Cims.PFE.Dao.ServiceRepository;


@Service
public class ServiceService {
	@Autowired
	ServiceRepository serviceRepository;
	
	public List<Cims.PFE.Entities.Service> listAll(){

		return serviceRepository.findAll();
	}

}
