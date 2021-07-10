package kodlamaio.HumanResourceManagementSystem.entities.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementFilterDto {
	private List<Integer> cityId;
	private List<Integer> jobTitleId;
	private List<Integer> workTypeId;
	private List<Integer> workScheduleId;
	//private int minSalary;
	//private int maxSalary;
}
