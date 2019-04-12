package api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.Entity.Region;
import api.Repository.RegionRepository;

@Service
public class RegionService {
	@Autowired
	private RegionRepository resionRepository;
	
	public Region setRegionByName(String name) {
		if(resionRepository.findByName(name)!=null) {
			return resionRepository.findByName(name);
		}else {
			return null;
		}
		
	}


}
