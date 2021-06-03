package kodlamaio.HumanResourceManagementSystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HumanResourceManagementSystem.entities.concretes.LinkType;

public interface LinkTypeDao extends JpaRepository<LinkType, Integer> {
}
