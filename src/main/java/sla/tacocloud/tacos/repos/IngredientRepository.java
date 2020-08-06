package sla.tacocloud.tacos.repos;

import org.springframework.data.repository.CrudRepository;
import sla.tacocloud.tacos.pdo.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
