package ee.tako.thenewandimprovedchooseadventure.repository;

import ee.tako.thenewandimprovedchooseadventure.model.Monster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MonsterRepository extends JpaRepository<Monster, Long> {

	List<Monster> findAll();

	Optional<Monster> findMonsterByName(String name);
}


