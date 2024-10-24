package CodeJdbcTemplete.controller;

import CodeJdbcTemplete.CustomException.GlobleExceptionHandle;
import CodeJdbcTemplete.model.CompanyProfile;
import CodeJdbcTemplete.service.CompanyService;
import CodeJdbcTemplete.utill.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CompanyProfileController {
    @Autowired
    private CompanyService companyService;

    @PostMapping("/saveCompany")
    public ResponseEntity<String> saveCompanyProfile(@RequestBody CompanyProfile companyProfile) {
       CompanyProfile companyProfile1= companyService.save(companyProfile);
       try {
           if (companyProfile1 != null) {
               return ResponseEntity.status(HttpStatus.OK).body(Constant.SAVE_DATA);
           }
       }catch (GlobleExceptionHandle e) {
           //throw new GlobleExceptionHandle(Constant.COMPANY_PROFILE_NOT_SAVED);
           throw new GlobleExceptionHandle("sdas",404);
       }
       return ResponseEntity.status(HttpStatus.OK).body(Constant.SAVE_DATA);
    }

}
