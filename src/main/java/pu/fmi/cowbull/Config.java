package pu.fmi.cowbull;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pu.fmi.cowbull.logic.GameService;
import pu.fmi.cowbull.logic.GameServiceImpl;
import pu.fmi.cowbull.model.GameRepository;
import pu.fmi.cowbull.model.GameRepositoryImpl;

@Configuration
public class Config {
//	
//	@Bean("gameRepository")
//	public GameRepository getGameRepository() {
//		return new GameRepositoryImpl();
//	}
//	
//	@Bean(initMethod = "init", destroyMethod = "destroy")
//	public GameService gameService() {
//		return new GameServiceImpl(getGameRepository());
//	}

}
