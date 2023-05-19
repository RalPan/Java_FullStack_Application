package we.final_project_thymeleaf_JDBC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import we.final_project_thymeleaf_JDBC.DAOs.toleranceRepo;
import we.final_project_thymeleaf_JDBC.model.tolerance;

import java.util.List;
@RestController
@RequestMapping("/tolerance")
@CrossOrigin
public class toleranceController {
    @Autowired
    private toleranceRepo toleranceRepo;


    @GetMapping("/tolerances")
    public ResponseEntity<List<tolerance>> allTolerance() {
        List<tolerance> tolerances = toleranceRepo.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(tolerances);
    }

    @GetMapping("/{id}")
    public ResponseEntity<tolerance> getToleranceById(@PathVariable("id") Integer id) {
        tolerance tolerance = toleranceRepo.getReferenceById(id);
        return new ResponseEntity<tolerance>(tolerance, HttpStatus.OK);
    }
    //I don't know how to use what is past this point
    @PostMapping("/add")
    public ResponseEntity<Void> addNewTolerance(@RequestBody tolerance tolerance) {
        toleranceRepo.save(tolerance);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTolerance(@PathVariable("id") Integer id) {
        toleranceRepo.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<tolerance> updateTolerance(@PathVariable("id") Integer id, @RequestBody tolerance tolerance) {
        toleranceRepo.save(tolerance);
        return new ResponseEntity<tolerance>(tolerance, HttpStatus.OK);
    }
}
