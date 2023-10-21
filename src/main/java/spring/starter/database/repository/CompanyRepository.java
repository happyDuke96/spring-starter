package spring.starter.database.repository;

import spring.starter.bpp.Auditing;
import spring.starter.bpp.InjectBean;
import spring.starter.bpp.Transaction;
import spring.starter.database.entity.Company;
import spring.starter.database.pool.ConnectionPool;
import java.util.Optional;

@Transaction
@Auditing
public class CompanyRepository implements CrudRepository<Integer,Company>{

    @InjectBean
    ConnectionPool connectionPool;

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
