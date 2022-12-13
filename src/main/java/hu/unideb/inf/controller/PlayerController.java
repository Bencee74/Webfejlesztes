package hu.unideb.inf.controller;

import hu.unideb.inf.model.Player;
import hu.unideb.inf.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.spring6.context.webflux.IReactiveDataDriverContextVariable;
import org.thymeleaf.spring6.context.webflux.ReactiveDataDriverContextVariable;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Controller
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping(value = "/")
    public String getAllPlayers(final Model model){

        IReactiveDataDriverContextVariable reactiveDataDriverContextVariable
                =new ReactiveDataDriverContextVariable(
                playerRepository.findAll(),1);
        model.addAttribute("players",reactiveDataDriverContextVariable);

        return "index";
    }


    @GetMapping(path = {"/edit","/edit/{id}"})
    public String updatePlayerById(Model model, @PathVariable("id") Optional<Long> id){
        if(id.isPresent()){
            Mono<Player> player = playerRepository.findById(id.get());
            model.addAttribute("player", player);
        }else {
            model.addAttribute("player", new Player());
        }
        return "new-player";
    }

    @PostMapping(value = "/create")
    public String addPlayer(Player player){
        playerRepository.save(player).subscribe();
        return "redirect:/";
    }

    @GetMapping(path="/delete/{id}")
    public String deletePlayer(Model model, @PathVariable("id") Long id){
        playerRepository.deleteById(id).subscribe();
        return "redirect:/";
    }
}