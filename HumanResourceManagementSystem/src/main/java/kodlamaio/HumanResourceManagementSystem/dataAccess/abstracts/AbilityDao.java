package kodlamaio.HumanResourceManagementSystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HumanResourceManagementSystem.entities.concretes.Ability;

public interface AbilityDao extends JpaRepository<Ability, Integer>{
	
}
