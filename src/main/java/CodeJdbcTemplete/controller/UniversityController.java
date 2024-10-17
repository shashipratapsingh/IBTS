package CodeJdbcTemplete.controller;

import CodeJdbcTemplete.CustomException.GlobleExceptionHandle;
import CodeJdbcTemplete.model.University;
import CodeJdbcTemplete.service.UniversityService;
import CodeJdbcTemplete.utill.Constant;
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
        if(university!=null)
            universityService.saveUniversity(university);
        else
            throw new GlobleExceptionHandle(Constant.SAVE_UNIVERCITY);
        return "University saved successfully!";
    }
}
