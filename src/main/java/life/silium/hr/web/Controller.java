package life.silium.hr.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import life.silium.hr.Database.UserRepository;
import life.silium.hr.Database.Users;
import life.silium.hr.Service.ReadText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class Controller {

    @Autowired
    UserRepository userRepository;
    ObjectMapper mapper = new ObjectMapper();


    @GetMapping("/all")
    public String all(){
        List<Users> userList = userRepository.findAllUsers();


        try {
            // JSON 형식으로 변환하여 출력
            String userJson = mapper.writeValueAsString(userList);
            return userJson;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return e.toString();
        }

    }

    @GetMapping("/user")
    public String findUser(@RequestParam int id) {
        List<Users> user = userRepository.findOneProjectedById(id);
        try {
            // JSON 형식으로 변환하여 출력
            String userJson = mapper.writeValueAsString(user);
            return userJson;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return e.toString();
        }

    }

    @GetMapping("/remove")
    public Boolean removeUser(@RequestParam int id) {

        if ( userRepository.findOneProjectedById(id).toArray().length == 1) {
            userRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @GetMapping("/name")
    public String findName(@RequestParam String name) {
        List<Users> user = userRepository.findOneProjectedByName(name);
        try {
            // JSON 형식으로 변환하여 출력
            String userJson = mapper.writeValueAsString(user);
            return userJson;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return e.toString();
        }
    }
}
