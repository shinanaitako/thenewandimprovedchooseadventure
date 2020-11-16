package ee.tako.thenewandimprovedchooseadventure.service;

import ee.tako.thenewandimprovedchooseadventure.model.Monster;
import ee.tako.thenewandimprovedchooseadventure.repository.MonsterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class MonsterService {

	private HashSet<Long> usedMonsters = new HashSet<>();

	private final MonsterRepository monsterRepository;

	public Monster fetchRandomMonster() {

		long monsterNumber = ThreadLocalRandom.current().nextLong(1, monsterRepository.findAll().size() + 1);

		Monster randomMonster = monsterRepository.getOne(monsterNumber);

		while (!usedMonsters.add(monsterNumber)) {
			monsterNumber = ThreadLocalRandom.current().nextLong(1, monsterRepository.findAll().size() + 1);
			randomMonster = monsterRepository.getOne(monsterNumber);
		}
		usedMonsters.add(monsterNumber);

		return  randomMonster;
	}

	public HashSet fetchNewSetOfMonsters() {
		usedMonsters = new HashSet<>();
		return usedMonsters;
	}
}
