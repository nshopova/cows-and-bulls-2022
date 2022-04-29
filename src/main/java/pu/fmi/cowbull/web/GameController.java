package pu.fmi.cowbull.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pu.fmi.cowbull.logic.GameService;
import pu.fmi.cowbull.model.GameInfo;
import pu.fmi.cowbull.model.GameRepository;

@Controller
public class GameController {
	
	@Autowired
	private GameService gameService;

	@GetMapping("/")
	public String hello(String name) {
		return "Welcome";
	}

	@PostMapping("games")
	public String startNewGame(Model model) {
		GameInfo gameInfo = gameService.startGame();
		return "redirect:/games/" + gameInfo.getGameId();
	}
	
	@GetMapping("games/{id}")
	public String showGame(@PathVariable String id, Model model) {
		GameInfo gameInfo = gameService.getGame(id);
		model.addAttribute("game", gameInfo);
		return "Game";
	}
	
	@PostMapping("games/{id}/try") 
	public String makeTry(@PathVariable String id, @RequestParam String guess, Model model) {
		
		System.out.println("gameId: " + id + "; guess: " + guess);
		GameInfo gameInfo = gameService.makeTry(id, guess);
		return "redirect:/games/" + gameInfo.getGameId();
	}
}
