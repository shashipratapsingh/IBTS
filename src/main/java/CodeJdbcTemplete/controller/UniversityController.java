package CodeJdbcTemplete.controller;

import CodeJdbcTemplete.CustomException.GlobleExceptionHandle;
import CodeJdbcTemplete.model.University;
import CodeJdbcTemplete.service.UniversityService;
import CodeJdbcTemplete.utill.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UniversityController {

    private final UniversityService universityService;

    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @PostMapping("/saveUniversity")
    public String saveUniversity(@RequestBody University university) {
        if(university!=null)
            universityService.saveUniversity(university);
        else
            throw new GlobleExceptionHandle(Constant.SAVE_UNIVERCITY);
        return "University saved successfully!";
    }

    @GetMapping("/getUniversityById/{id}")
    public ResponseEntity<?> getUniversityById(@PathVariable int id) {
        try {
            University university = universityService.getUniversityById(id);
            if (university != null) {
                return ResponseEntity.ok(university);
            }else {
                return ResponseEntity.noContent().build();
            }
        }catch (GlobleExceptionHandle e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No university found with ID: " + id);
        }
    }
}
