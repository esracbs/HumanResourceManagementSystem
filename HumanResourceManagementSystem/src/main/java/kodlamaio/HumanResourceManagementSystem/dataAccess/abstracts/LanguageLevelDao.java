package kodlamaio.HumanResourceManagementSystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HumanResourceManagementSystem.entities.concretes.LanguageLevel;

public interface LanguageLevelDao extends JpaRepository<LanguageLevel,Integer>{

}
