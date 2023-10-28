package spring.starter.database.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import spring.starter.bpp.Auditing;
import spring.starter.bpp.Transaction;
import spring.starter.database.entity.Company;
import spring.starter.database.pool.ConnectionPool;

import java.util.List;
import java.util.Optional;

@Repository
@Transaction
@Auditing
public class CompanyRepository implements CrudRepository<Integer,Company>{

//    @InjectBean
    /** @Resource - он добавился чтобы поддержать java ЕЕ JSR-250 спецификацию,минусы его нельзя вставить над конструктором,
     * но в случае когда будет унас два бина  с помощью его лего можно внедрять по названию бина то что не возможно с @Autowired-ом */
//    @Autowired
//    @Qualifier("pool1")
    private final ConnectionPool pool1;
    private final List<ConnectionPool> pools;
    private final  Integer poolSize;

    public CompanyRepository(ConnectionPool pool1,
                             List<ConnectionPool> pools,
                             @Value("${db.pool.size}") Integer poolSize) {
        this.pool1 = pool1;
        this.pools = pools;
        this.poolSize = poolSize;
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
