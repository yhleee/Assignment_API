package api.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import api.Entity.Program;


@Repository
public interface ProgramRepository extends CrudRepository<Program, Long> {

	
	//region code 로 program 검
	Program findByRegionCode(@Param("regionCode") String regionCode);
	
	

}
