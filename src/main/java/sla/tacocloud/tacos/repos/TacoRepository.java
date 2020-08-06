package sla.tacocloud.tacos.repos;

import org.springframework.data.repository.CrudRepository;
import sla.tacocloud.tacos.pdo.Taco;

public interface TacoRepository extends CrudRepository<Taco, Long> {

}
