package teste.mapeamento.manyMany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ingrediente")
public class Ingrediente {

    @ManyToMany(mappedBy = "ingredientes")
    private List<Pizza> pizzas;

    public List<Pizza> getPizzas() {
        return pizzas;
    }
}
