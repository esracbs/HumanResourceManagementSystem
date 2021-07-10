package kodlamaio.HumanResourceManagementSystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HumanResourceManagementSystem.entities.concretes.City;


public interface CityDao extends JpaRepository<City, Integer>{
	 boolean  existsById(int id);
}
