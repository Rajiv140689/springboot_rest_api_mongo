package RESTAPI.demo.repository;

import RESTAPI.demo.models.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends MongoRepository<Employee,String> {
    @Query("{'name': ?0}")
    List<Optional<Employee>> findByName(String name);
}
