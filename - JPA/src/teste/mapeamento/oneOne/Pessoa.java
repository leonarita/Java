package teste.mapeamento.oneOne;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa")
public class Pessoa {

    @OneToOne(mappedBy = "pessoa")
    private Avaliacao avaliacao;

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }
}