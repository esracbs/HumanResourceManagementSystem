package kodlamaio.HumanResourceManagementSystem.entities.concretes;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name="candidates")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","schoolCandidates",
	"languageCandiates","abilityCandidates",
	"workplaceCandidates","socialMedias","cvDetail","images"})
public class Candidate extends User {

	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="identification_number")
	private String  identificationNumber;
	
	@Column(name="birth_date")
	private Date birthDate;
	
	@JsonIgnore
	@OneToMany(mappedBy="candidate")
	private List<SchoolCandidate> schoolCandidates;

	@JsonIgnore
	@OneToMany(mappedBy="candidate")
	private List<LanguageCandidate> languageCandidates;
	
	@JsonIgnore
	@OneToMany(mappedBy="candidate")
	private List<AbilityCandidate> abilityCandidates;
	@JsonIgnore
	@OneToMany(mappedBy="candidate")
	private List<WorkplaceCandidate> workPlaceCandidates;
	@JsonIgnore
	@OneToMany(mappedBy = "candidate" )
	private List<SocialMedia> socialMedias;
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<Image> images;

	@JsonIgnore
	@OneToOne(mappedBy = "candidate" )
	private CvDetail cvDetail;

	
	
}
