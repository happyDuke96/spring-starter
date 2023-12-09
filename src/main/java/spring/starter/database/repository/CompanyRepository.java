package spring.starter.database.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import spring.starter.bpp.Auditing;
import spring.starter.bpp.Transaction;
import spring.starter.database.entity.Company;
import spring.starter.database.pool.ConnectionPool;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

//@Repository в файле xml указали что CrudRepository будет создан даже не  указываем что это @Component

/** в этом случае возвращается прокси даже если помечен как prototype всегда возвращается singleton объект */
@Slf4j
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Transaction
@Auditing
@RequiredArgsConstructor
public class CompanyRepository implements CrudRepository<Integer,Company>{

//    @InjectBean
    /** @Resource - он добавился чтобы поддержать java ЕЕ JSR-250 спецификацию,минусы его нельзя вставить над конструктором,
     * но в случае когда будет унас два бина  с помощью его лего можно внедрять по названию бина то что не возможно с @Autowired-ом */
//    @Autowired
//    @Qualifier("pool1")
    private final ConnectionPool pool1;
    private final List<ConnectionPool> pools;
    @Value("${db.pool.size}")
    private final  Integer poolSize;

    @PostConstruct
    private void init() {
        log.warn("Init companyService");
    }

    @Override
    public Optional<Company> findById(Integer id) {
        System.out.println("findById method...");
        return Optional.of(new Company(id));
    }

    @Override
    public void delete(Company entity) {
        System.out.println("delete method...");
    }
}
