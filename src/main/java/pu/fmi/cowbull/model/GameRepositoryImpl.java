package pu.fmi.cowbull.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("gameRepository")
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class GameRepositoryImpl implements GameRepository {

	private Map<String, GameInfo> games = new ConcurrentHashMap<String, GameInfo>();
	
	@Override
	public void addGame(GameInfo gameInfo) {
		games.put(gameInfo.getGameId(), gameInfo);
	}
	
	@Override
	public GameInfo getGame (String gameId) {
		return games.get(gameId);
	}
	
	@PostConstruct
	public void init() {
		System.out.println("Init method of gameRepository");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Destroy method for gameRepository");
	}
}
