import java.util.ArrayList;
import java.util.List;

public class Cidadao {
    private int id;
    private String idCidadao;
    private String nome;
    private List<Problema> problemasReportados; // Biderecional com Problema
    private List<Problema> problemasContribuidos; // N:N com Problema

    public Cidadao(int id, String idCidadao, String nome) {
        this.id = id;
        this.idCidadao = idCidadao;
        this.nome = nome;
        this.problemasReportados = new ArrayList<>();
        this.problemasContribuidos = new ArrayList<>();
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

    public List<Problema> getProblemasReportados() {
        return problemasReportados;
    }

    public void adicionarProblemaReportado(Problema problema) {
        if (problema != null && !problemasReportados.contains(problema)) {
            problemasReportados.add(problema);
        }
    }

    public List<Problema> getProblemasContribuidos() {
        return problemasContribuidos;
    }

    public void adicionarProblemaContribuido(Problema problema) {
        if (problema != null && !problemasContribuidos.contains(problema)) {
            problemasContribuidos.add(problema);
        }
    }
}