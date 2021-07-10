package kodlamaio.HumanResourceManagementSystem.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@Entity
@Table(name="cv_details")
@AllArgsConstructor
@NoArgsConstructor
public class CvDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="id")
    private int id;

    @JsonIgnore
    @OneToOne()
    @JoinColumn(name="candidate_id")
    private Candidate candidate;
    
    //@ManyToOne()
	//@JoinColumn(name = "image_id")
	//private Image image;

    @Column(name="description")
    private String description;

    @Column(name="cv_photo_url")
    private String cvPhotoUrl;
}
