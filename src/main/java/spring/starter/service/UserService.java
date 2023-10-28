package spring.starter.service;

import org.springframework.stereotype.Service;
import spring.starter.database.entity.Company;
import spring.starter.database.repository.CompanyRepository;
import spring.starter.database.repository.CrudRepository;
import spring.starter.database.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    /*помечен как @Transaction это значит мы вернем Proxy а не сам беан по этому указываем какой будет type */
    private final CrudRepository<Integer, Company> companyRepository;

    public UserService(UserRepository userRepository, CrudRepository<Integer, Company> companyRepository) {
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
    }
}
