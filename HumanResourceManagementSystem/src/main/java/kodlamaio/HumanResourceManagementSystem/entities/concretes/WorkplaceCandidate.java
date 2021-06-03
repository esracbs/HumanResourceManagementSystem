package kodlamaio.HumanResourceManagementSystem.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="workplace_candidates")
@NoArgsConstructor
@AllArgsConstructor
public class WorkplaceCandidate {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne()
	@JoinColumn(name="workplaces_id")
	private Workplace workplace;
	
	@ManyToOne()
	@JoinColumn(name="candidate_id")
	private Candidate candidate;
	
	@ManyToOne()
	@JoinColumn(name="job_title_id")
	private JobTitle jobTitleId;
	
	@Column(name="date_of_entry")
	private LocalDate dateOfEntry;
	
	@Column(name="date_of_quit")
	private LocalDate dateOfQuit;

}
