package api.Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.CSVReader;
import api.Entity.Program;
import api.Entity.Region;
import api.Repository.ProgramRepository;
import api.Repository.RegionRepository;
import api.Service.FileUploadService;


@Controller    
public class MainController {
	@Autowired
	private RegionRepository regionRepository;
	@Autowired
	private ProgramRepository programRepository;
	@Autowired
	private  FileUploadService fileUploadService;
	
	//csv 파일 업로드하여 데이터베이스 저장 
	@PostMapping(path="/loadCSV", headers = ("content-type=multipart/*;charset=EUC-KR"))
		public @ResponseBody Iterable<Program> loadCSV(@RequestParam("file") MultipartFile inputFile) { 
		
		HttpHeaders headers = new HttpHeaders();

		try {
			InputStreamReader is = new InputStreamReader(inputFile.getInputStream(), "EUC-KR");
			CSVReader reader = new CSVReader(is);
			List<String[]> list = reader.readAll();
			fileUploadService.join(list);
			
			return programRepository.findAll();
			//저장된 program list 를 출력 

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null ;	//error message
			
		}
		
		
		}
	
	
	//모든 program 조회
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Program> getAllProgram() {
		return programRepository.findAll();
	}
	
	
	//program 조회 -region명으로 검색 
	@PostMapping(path="/program",consumes = MediaType.APPLICATION_JSON_VALUE,
	        produces = MediaType.APPLICATION_JSON_VALUE)
		public @ResponseBody Program apiTest(@RequestBody Map<String, Object> param) {  
		  String region = (String) param.get("region");

		  Region r = regionRepository.findByName(region);
		  String regionC = r.getRegionCode()+"";
		  Program p = programRepository.findByRegionCode(regionC);
		  System.out.println(p.getRegionCode()+" ");
		  return p;
		}
	
	
}
