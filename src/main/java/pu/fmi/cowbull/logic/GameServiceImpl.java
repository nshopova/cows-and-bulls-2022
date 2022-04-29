package pu.fmi.cowbull.logic;

import java.util.Random;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import pu.fmi.cowbull.model.GameInfo;
import pu.fmi.cowbull.model.GameRepository;
import pu.fmi.cowbull.model.TryInfo;

@Service("gameService")
@Scope
public class GameServiceImpl implements GameService {
	
//	@Autowired
	private GameRepository gameRepository;
	
	public GameServiceImpl(GameRepository gameRepository) {
		this.gameRepository = gameRepository;
		System.out.println("Constructor of gameService");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("Init method of gameService");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Destroy method for gameService");
	}
	
	@Override
	public GameInfo startGame() {
		var gameInfo = new GameInfo();
		gameInfo.setGameId(UUID.randomUUID().toString());

		var random = new Random();
		var number = new int[4];
		for (int i = 0; i < 4; i++) {
			number[i] = random.nextInt(9);
		}

		gameInfo.setNumber(number);
		gameRepository.addGame(gameInfo);
		return gameInfo;
	}

	@Override
	public GameInfo getGame(String gameId) {
		return gameRepository.getGame(gameId);
	}

	@Override
	public GameInfo makeTry(String gameId, String guess) {
		GameInfo gameInfo = gameRepository.getGame(gameId);
		
		TryInfo tryInfo = new TryInfo();
		tryInfo.setGuessString(guess);
		gameInfo.getHistory().add(tryInfo);
		
		//TODO calculate cows and bulls
		return gameInfo;
	}
//	
//	@Autowired
//	public void setGameRepository(GameRepository gameRepository) {
//		this.gameRepository = gameRepository;
//	}

}
