package sla.tacocloud.tacos;

import java.util.List;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Taco {

    private String name;
    private List<String> ingredients;

}
