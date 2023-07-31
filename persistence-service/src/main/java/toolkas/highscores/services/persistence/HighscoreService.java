package toolkas.highscores.services.persistence;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import toolkas.highscores.services.datamodel.Highscore;

@Service
public class HighscoreService {

    private Map<UUID, Highscore> dataset = new HashMap<>();
    
    public void store(Highscore data) {
        UUID id = UUID.randomUUID();
        data.setId(id);
        System.out.println("UUID "+id+" assigned to "+data.getUserId()+"/"+data.getAppId()+"="+data.getScore());
        dataset.put(id, data);
    }

    public Collection<Highscore> listAll() {
        return dataset.values();
    }
    
}
