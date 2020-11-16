package ee.tako.thenewandimprovedchooseadventure.controller;

import ee.tako.thenewandimprovedchooseadventure.model.Monster;
import ee.tako.thenewandimprovedchooseadventure.service.MonsterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class MonsterController {

	private final MonsterService monsterService;

	@GetMapping("/monster")
	public Monster getRandomMonster() {
		return monsterService.fetchRandomMonster();
	}

	@GetMapping("/restart")
	public HashSet getNewRandomMonsters() {
		return monsterService.fetchNewSetOfMonsters();
	}
}
