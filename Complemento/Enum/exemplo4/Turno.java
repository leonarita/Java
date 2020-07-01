package exemplo4;

public enum Turno {

	MANHA("manh�"),
    TARDE("tarde"),
    NOITE("noite");
 
    private String descricao;
 
    Turno(String descricao) {
        this.descricao = descricao;
    }
 
    public String getDescricao() {
        return descricao;
    }
}
