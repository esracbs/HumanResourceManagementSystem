package kodlamaio.HumanResourceManagementSystem.entities.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kodlamaio.HumanResourceManagementSystem.entities.concretes.AbilityCandidate;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.Candidate;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.CvDetail;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.LanguageCandidate;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.SchoolCandidate;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.SocialMedia;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.WorkplaceCandidate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvDto {
	
	@JsonIgnore
	private Candidate candidate;
	
	private List<SchoolCandidate> schoolCandidates;
	
	private List<WorkplaceCandidate> workplaceCandidates;
	
	private List<LanguageCandidate> languageCandidates;
	
	private List<AbilityCandidate> abilityCandidates;
	
	private List<SocialMedia> socialMedias;

    private CvDetail cvDetail;
	
}
