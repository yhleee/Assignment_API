package api.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.Entity.Program;
import api.Entity.Region;
import api.Repository.ProgramRepository;
import api.Repository.RegionRepository;


@Service
public class FileUploadService {
	
	@Autowired
	private ProgramRepository programRepository;
	
	@Autowired
	private RegionRepository regionRepository;
	
	
	 public void join(List<String[]> list) {
		 for(String[] str : list) {
		if(str==list.get(0)) continue; //skip header
		
		 Program p = new Program();	  
		
		 p.setRegionCode(getRegionCodeStr(str[1]));
		 p.setTarget(str[2]);
		 p.setUsage(str[3]);
		 p.setLimitation(str[4]);
		 p.setRate(str[5]);
		 p.setInstitution(str[6]);
		 p.setMgmt(str[7]);
		 p.setReception(str[8]);
		
		 programRepository.save(p);
		 }
	    }
	 
	 public String getRegionCodeStr(String region) {
		 
		 if(regionRepository.findByName(region)!=null) {
			 Region r = regionRepository.findByName(region);
			  return (r.getRegionCode()+"");
		 }else {
			 Region r = new Region(region);
			 regionRepository.save(r);
			 return (r.getRegionCode()+""); 
		 }
		
		 
	 }

	

}
