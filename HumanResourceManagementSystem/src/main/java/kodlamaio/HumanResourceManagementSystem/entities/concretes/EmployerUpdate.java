package kodlamaio.HumanResourceManagementSystem.entities.concretes;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employer_update")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerUpdate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "employer_id")
    private Integer employerId;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "web_site")
    private String webSite;

    @Column(name = "phone_number")
    private String phoneNumber;
    
    @Column(name = "verifyed")
    @JsonIgnore
    private boolean verifyed;

    @Column(name = "employee_id")
    @JsonIgnore
    private Integer employeeId;


}
