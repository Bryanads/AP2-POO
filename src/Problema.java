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
    private int aindaEsta;
    private Cidadao reportante;
    private List<Comentario> comentarios;

    public Problema(int idProblema, String titulo, String descricao, Localizacao localizacao, String classificacao, String status, Cidadao reportante) {
        this.idProblema = idProblema;
        this.titulo = titulo;
        this.descricao = descricao;
        this.localizacao = localizacao;
        this.classificacao = classificacao;
        this.status = status;
        this.data = LocalDateTime.now();
        this.comentarios = new ArrayList<>();
        this.reportante = reportante;
        this.aindaEsta = 0;
    }

    public void adicionarComentario(Comentario comentario) {
        if (comentario != null) {
            this.comentarios.add(comentario);
            System.out.println("Comentário adicionado ao problema '" + this.titulo + "'.");
        }
    }

    public void adicionarVotoConfirmacao() {
        this.aindaEsta++;
        System.out.println("Voto de confirmação adicionado ao problema '" + this.titulo + "'. Votos: " + this.aindaEsta);
    }

    public String imprimirProblema() {
        StringBuilder sb = new StringBuilder();
        sb.append("--- Detalhes do Problema ---\n");
        sb.append("ID: ").append(idProblema).append("\n");
        sb.append("Título: ").append(titulo).append("\n");
        sb.append("Descrição: ").append(descricao).append("\n");
        sb.append("Localização: ").append(localizacao.toString()).append("\n");
        sb.append("Classificação: ").append(classificacao).append("\n");
        sb.append("Status: ").append(status).append("\n");
        sb.append("Reportado por: ").append(reportante.getNome()).append(" (ID: ").append(reportante.getIdCidadao()).append(")\n");
        sb.append("Registrado em: ").append(data.format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))).append("\n");
        sb.append("Votos de Confirmação: ").append(aindaEsta).append("\n");
        sb.append("Comentários (").append(comentarios.size()).append("):\n");
        if (comentarios.isEmpty()) {
            sb.append("  Nenhum comentário ainda.\n");
        } else {
            for (Comentario c : comentarios) {
                sb.append("  - ").append(c.toString()).append("\n");
            }
        }
        sb.append("----------------------------");
        return sb.toString();
    }
}