package pu.fmi.cowbull;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import pu.fmi.cowbull.logic.GameService;
import pu.fmi.cowbull.model.GameRepository;

@SpringBootApplication
public class CowsandbullsApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(CowsandbullsApplication.class, args);
		
		GameService gameService = context.getBean("gameService", GameService.class);
		System.out.println(gameService.startGame().getGameId());
		System.out.println(gameService);
		
		GameService gameService2 = context.getBean("gameService", GameService.class);
		System.out.println(gameService2);
		
		GameRepository gameRepository = context.getBean("gameRepository", GameRepository.class);
		System.out.println(gameRepository);
		
		GameRepository gameRepository2 = context.getBean("gameRepository", GameRepository.class);
		System.out.println(gameRepository2);
		
//		((ConfigurableApplicationContext)context).close();
	}

}
