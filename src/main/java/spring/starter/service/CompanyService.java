package spring.starter.service;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import spring.starter.database.entity.Company;
import spring.starter.database.repository.CrudRepository;
import spring.starter.dto.CompanyReadDto;
import spring.starter.listener.entity.AccessType;
import spring.starter.listener.entity.EntityEvent;

import java.util.Optional;

@Service
public class CompanyService {

    private final UserService userService;
    private final CrudRepository<Integer, Company> companyRepository;
    private final ApplicationEventPublisher applicationEventPublisher; // implement of AnnotationConfigApplicationContext


    public CompanyService(UserService userService,
                          CrudRepository<Integer, Company> companyRepository,
                          ApplicationEventPublisher applicationEventPublisher) {
        this.userService = userService;
        this.companyRepository = companyRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }


    public Optional<CompanyReadDto> findById(Integer id) {
        return companyRepository.findById(id)
                .map(entity -> {
                    // publishEvent метод публикует(передает) на листенер можно передать кустом объект либо базовый класс ApplicationEvent
                    applicationEventPublisher.publishEvent(new EntityEvent(entity, AccessType.READ));
                    return new CompanyReadDto(entity.getId());
                });
    }
}
