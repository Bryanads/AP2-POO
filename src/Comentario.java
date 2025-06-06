import java.time.LocalDateTime;

public class Comentario {
    private int id;
    private Cidadao autor;
    private String texto;
    private LocalDateTime dataHora;

    public Comentario(int id, String texto, Cidadao autor) {
        this.id = id;
        this.texto = texto;
        this.dataHora = LocalDateTime.now();
        this.autor = autor;
    }

    public int getId() {
        return id;
    }

    public String getTexto() {
        return texto;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public Cidadao getAutor() {
        return autor;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", " + autor.getNome() + " (" + dataHora.format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) + "): " + texto;
    }
}