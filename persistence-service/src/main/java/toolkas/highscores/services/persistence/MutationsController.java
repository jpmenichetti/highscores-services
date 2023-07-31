package toolkas.highscores.services.persistence;

import org.springframework.web.bind.annotation.RestController;

import toolkas.highscores.services.datamodel.Highscore;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class MutationsController {

    @Autowired
    private HighscoreService highscoreService;

    @GetMapping("/")
    public String index() {
        return "Welcome to the High Scores Persistence Service";
    }

    @PutMapping("/highscore")
    public boolean putHighScore(@RequestBody Highscore data) {
        highscoreService.store(data);
        return true;
    }

    @GetMapping("/highscore")
    public Collection<Highscore> listHighScores() {
        return highscoreService.listAll();
    }
}
