package kodlamaio.HumanResourceManagementSystem.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="workplaces")
@NoArgsConstructor
@AllArgsConstructor
@CrossOrigin
public class Workplace {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="workplace_name")
	private String workplaceName;
	
	@JsonIgnore
	@OneToMany(mappedBy = "workplace" )
	private List<WorkplaceCandidate> workPlaceCandidates;
}
