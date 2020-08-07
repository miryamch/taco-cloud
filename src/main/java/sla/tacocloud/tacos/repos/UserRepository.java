package sla.tacocloud.tacos.repos;

import org.springframework.data.repository.CrudRepository;
import sla.tacocloud.tacos.pdo.User;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
