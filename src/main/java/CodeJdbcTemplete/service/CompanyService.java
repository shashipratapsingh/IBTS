package CodeJdbcTemplete.service;

import CodeJdbcTemplete.model.CompanyProfile;
import CodeJdbcTemplete.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public interface CompanyService {

    public CompanyProfile save(CompanyProfile companyProfile);



}
