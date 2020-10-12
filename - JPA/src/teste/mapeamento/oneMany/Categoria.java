package teste.mapeamento.oneMany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria {

	@OneToMany(mappedBy = "categoria")
    private List<Evento> eventos;

    public List<Evento> getEventos() {
        return eventos;
    }
}
