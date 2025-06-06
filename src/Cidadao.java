public class Cidadao {
    private int id;
    private String idCidadao;
    private String nome;

    public Cidadao(int id, String idCidadao, String nome) {
        this.id = id;
        this.idCidadao = idCidadao;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getIdCidadao() {
        return idCidadao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}