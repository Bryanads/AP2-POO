import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Problema {
    private int idProblema;
    private String titulo;
    private String descricao;
    private Localizacao localizacao;
    private String classificacao;
    private String status;
    private LocalDateTime data;
    private Cidadao reportante; // Bidirecional com Cidadao
    private List<Comentario> comentarios;
    private List<Cidadao> contribuintes; // N-N com Cidadao

    public Problema(int idProblema, String titulo, String descricao, Localizacao localizacao, String classificacao, String status, Cidadao reportante) {
        this.idProblema = idProblema;
        this.titulo = titulo;
        this.descricao = descricao;
        this.localizacao = localizacao;
        this.classificacao = classificacao;
        this.status = status;
        this.data = LocalDateTime.now();
        this.comentarios = new ArrayList<>();
        this.contribuintes = new ArrayList<>();
        this.reportante = reportante;
        if (reportante != null) {
            // Adiciona o problema à lista de problemas reportados do cidadão
            reportante.adicionarProblemaReportado(this);
        }
    }

    public void adicionarContribuinte(Cidadao cidadao) {
        if (cidadao != null && !contribuintes.contains(cidadao)) {
            contribuintes.add(cidadao);
            cidadao.adicionarProblemaContribuido(this);
            System.out.println(cidadao.getNome() + " contribuiu para o problema '" + this.titulo + "'.");
        }
    }


    public void adicionarComentario(Comentario comentario) {
        if (comentario != null) {
            this.comentarios.add(comentario);
            // Chama o nome do Cidadão que está dentro do Comentário que esta no Problema
            System.out.println((comentario.getAutor()).getNome() + " comentou : " + this.titulo + "'.");
        }
    }

    public void imprimirProblema() {
        System.out.println("ID: " + idProblema);
        System.out.println("Título: " + titulo);
        System.out.println("Descrição: " + descricao);
        System.out.println("Localização: " + localizacao.toString());
        System.out.println("Classificação: " + classificacao);
        System.out.println("Status: " + status);
        System.out.println("Reportado por: " + reportante.getNome() + " (ID: " + reportante.getIdCidadao() + ")");
        System.out.println("Registrado em: " + data.format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
        System.out.println("Contribuições: " + contribuintes.size());
        System.out.print("Contribuintes: ");
        if (contribuintes.isEmpty()) {
            System.out.println("Nenhum");
        } else {
            for (int i = 0; i < contribuintes.size(); i++) {
                Cidadao c = contribuintes.get(i);
                System.out.print(c.getNome() + " (" + c.getIdCidadao() + ")");
                if (i < contribuintes.size() - 1) System.out.print(", ");
            }
            System.out.println();
        }
        System.out.println("Comentários (" + comentarios.size() + "):");
        if (comentarios.isEmpty()) {
            System.out.println("  Nenhum comentário ainda.");
        } else {
            for (Comentario c : comentarios) {
                System.out.println("  - " + c.toString());
            }
        }
    }

    // Getters e Setters
    public List<Cidadao> getContribuintes() {
        return contribuintes;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}