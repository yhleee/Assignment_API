package api.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import api.Repository.RegionRepository;

@Entity
public class Program {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@JsonIgnore
	private String regionCode;
	
	private String region;
	
	private String target;
	private String usage;
	
	private String limitation;
	
	private String rate;
	
	private String institution;
	private String mgmt;
	private String reception;
	
	@JsonIgnore
	@CreatedDate
	private Date createdAt;
	
	@JsonIgnore
	@LastModifiedDate
	private Date updatedAt;
	
	public Program() {}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getUsage() {
		return usage;
	}

	public void setUsage(String usage) {
		this.usage = usage;
	}


	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public String getMgmt() {
		return mgmt;
	}

	public void setMgmt(String mgmt) {
		this.mgmt = mgmt;
	}

	public String getReception() {
		return reception;
	}

	public void setReception(String receiption) {
		this.reception = receiption;
	}

	public String getLimitation() {
		return limitation;
	}

	public void setLimitation(String limitation) {
		this.limitation = limitation;
	}

	public String getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}
	
	public String getCreatedAt() {
		return createdAt.toString();
	}
	
	public String getUpdatedAt() {
		return updatedAt.toString();
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	


}
