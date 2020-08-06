package sla.tacocloud.tacos.repos;

import org.springframework.data.repository.CrudRepository;
import sla.tacocloud.tacos.pdo.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
