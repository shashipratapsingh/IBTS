package CodeJdbcTemplete.service.impl;

import CodeJdbcTemplete.CustomException.GlobleExceptionHandle;
import CodeJdbcTemplete.model.CompanyProfile;
import CodeJdbcTemplete.repository.CompanyRepository;
import CodeJdbcTemplete.service.CompanyService;
import CodeJdbcTemplete.utill.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyProfileServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public CompanyProfile save(CompanyProfile companyProfile) {
        try {
            companyProfile.setCreatedBy("SystemUser");
            companyProfile.setUpdatedBy("SystemUser");
            this.companyRepository.save(companyProfile);
        }catch (Exception e) {
            throw new GlobleExceptionHandle(Constant.COMPANY_ALREADY_EXIST);
        }
        return companyProfile;
    }
}
