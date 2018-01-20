package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Luncher;

public interface LuncherRepository extends JpaRepository<Luncher, Long> {

	public List<Luncher> findAllByGoing(boolean isGoing);
	
}
