package CodeJdbcTemplete.controller;

import CodeJdbcTemplete.model.University;
import CodeJdbcTemplete.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UniversityController {

    private final UniversityService universityService;

    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @PostMapping("/university")
    public String saveUniversity(@RequestBody University university) {
        universityService.saveUniversity(university);
        return "University saved successfully!";
    }
}
