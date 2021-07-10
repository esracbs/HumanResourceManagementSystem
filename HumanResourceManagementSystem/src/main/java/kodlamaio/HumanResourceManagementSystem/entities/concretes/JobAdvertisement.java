package kodlamaio.HumanResourceManagementSystem.entities.concretes;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="job_advertisements")
public class JobAdvertisement {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="description")
	private String description;
	
	@Column(name="quota")
	private int quota;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name="appeal_expiration_date")
	private Date appealExpirationDate;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="min_salary")
	private Double minSalary;
	
	@Column(name="max_salary")
	private Double maxSalary;
	
	@Column(name="is_active")
	private boolean isActive=true;
	
	@Column(name = "is_confirm")
	private boolean isConfirm=false;
	
	@ManyToOne()
	@JoinColumn(name = "employer_id")
	private Employer employer;
	
	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;
	 
	@ManyToOne()
	@JoinColumn(name = "job_title_id")
	private JobTitle jobtitle;
	
	@ManyToOne()
	@JoinColumn(name = "work_schedule_id")
	private WorkSchedule workSchedule;
	
	@ManyToOne
	@JoinColumn(name = "work_types_id")
	private WorkType workType;
	

	@Column(name="advert_title")
	private String advertTitle;
	 
}
