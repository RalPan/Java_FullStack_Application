package we.final_project_thymeleaf_JDBC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import we.final_project_thymeleaf_JDBC.DAOs.userDAO;
import we.final_project_thymeleaf_JDBC.DAOs.userRepo;
import we.final_project_thymeleaf_JDBC.model.user;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class userController {
    @Autowired
    private userRepo userRepo;
    @Autowired
    private userDAO userDAO;

    @GetMapping("/users")
    public ResponseEntity<List<user>> allUsers() {
        List<user> user = userRepo.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<user> getUserslById(@PathVariable("id") Integer id) {
        user user = userRepo.findById(id).orElse(null);
        return new ResponseEntity<user>(user, HttpStatus.OK);
    }
    //I don't know how to use what is past this point
    @PostMapping("/add")
    public ResponseEntity<Void> addNewUsers(@RequestBody user user) {
        userRepo.save(user);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsers(@PathVariable("id") Integer id) {
        userRepo.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<user> updateMeal(@PathVariable("id") Integer id, @RequestBody user user) {
        userRepo.save(user);
        return new ResponseEntity<user>(user, HttpStatus.OK);
    }
    @PostMapping("/findbyname")
    public int findUserByName(String name) {

        return userDAO.findByName(name);
    }
}
