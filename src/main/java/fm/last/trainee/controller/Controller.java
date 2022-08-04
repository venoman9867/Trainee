package fm.last.trainee.controller;

import com.google.gson.Gson;
import fm.last.trainee.POJO.MyJson;
import fm.last.trainee.POJO.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class Controller {
    // String key = "e5e90c1dcef57aa97fd33bb2df47d105";
    @Autowired
    PersonService personService;
    @RequestMapping("/Get")
    public List method() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://ws.audioscrobbler.com/2.0/?method=library.getartists&limit=100&api_key=e5e90c1dcef57aa97fd33bb2df47d105&user=joanofarctan&format=json";
        Gson gson = new Gson();
        String json = restTemplate.getForObject(url, String.class);
        MyJson myJson=gson.fromJson(json,MyJson.class);
        myJson.getArtists().getArtist().forEach(artist -> {personService.save(artist);});
        return personService.getAllPersons();
    }
}

