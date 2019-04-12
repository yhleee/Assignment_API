package api.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import api.Entity.Region;



@Repository
public interface RegionRepository extends CrudRepository<Region, Long> {

	Region findByName(@Param("name") String name);
	
	
}
