public class Main {
    public static void main(String[] args) {
        System.out.println("--- Bem-vindo ao Cidade+ (Simulação) ---\n");

        // 1. Criar alguns Cidadãos
        Cidadao joao = new Cidadao(1, "C001", "João Silva");
        Cidadao maria = new Cidadao(2, "C002", "Maria Oliveira");
        Cidadao pedro = new Cidadao(3, "C003", "Pedro Souza");

        System.out.println("Cidadãos criados:");
        System.out.println("- " + joao.getNome() + " (ID: " + joao.getIdCidadao() + ")");
        System.out.println("- " + maria.getNome() + " (ID: " + maria.getIdCidadao() + ")");
        System.out.println("- " + pedro.getNome() + " (ID: " + pedro.getIdCidadao() + ")\n");

        // 2. Criar Localizações com os novos campos
        Localizacao locBuraco = new Localizacao(
                1, "SP", "São Paulo", "Centro", "Rua das Flores", "123", -23.550520, -46.633308
        );
        Localizacao locPoste = new Localizacao(
                2, "RJ", "Rio de Janeiro", "Bairro Alegre", "Avenida do Sol", "45", -22.906847, -43.172896
        );

        System.out.println("Localizações criadas:");
        System.out.println("- Buraco: " + locBuraco);
        System.out.println("- Poste: " + locPoste + "\n");

        // 3. Criar Problemas
        Problema problema1 = new Problema(
                1,
                "Buraco Perigoso na Rua das Flores",
                "Há um buraco enorme próximo ao número 123, causando risco a carros e pedestres. ",
                locBuraco,
                "Buraco",
                "Aberto",
                joao
        );

        Problema problema2 = new Problema(
                2,
                "Poste Sem Luz na Avenida do Sol",
                "O poste em frente ao número 45 está com a luz queimada há 3 dias, deixando a rua escura e perigosa. ",
                locPoste,
                "Poste sem luz",
                "Aberto",
                maria
        );

        System.out.println("Problemas registrados inicialmente:\n");
        System.out.println(problema1.imprimirProblema());
        System.out.println("\n");
        System.out.println(problema2.imprimirProblema());
        System.out.println("\n");

        // 4. Interagir com os Problemas
        System.out.println("--- Interagindo com os Problemas ---\n");

        problema1.adicionarVotoConfirmacao();
        problema1.adicionarVotoConfirmacao();
        problema1.adicionarVotoConfirmacao();

        Comentario comentario1_1 = new Comentario(1, "Concordo, quase caí de bicicleta aqui!", pedro);
        problema1.adicionarComentario(comentario1_1);

        Comentario comentario1_2 = new Comentario(2, "A prefeitura precisa agir rápido!", maria);
        problema1.adicionarComentario(comentario1_2);

        problema2.adicionarVotoConfirmacao();

        Comentario comentario2_1 = new Comentario(3, "Realmente, está muito escuro à noite.", joao);
        problema2.adicionarComentario(comentario2_1);

        System.out.println("\n--- Problemas atualizados ---\n");
        System.out.println(problema1.imprimirProblema());
        System.out.println("\n");
        System.out.println(problema2.imprimirProblema());
        System.out.println("\n--- Fim da Simulação ---");
    }
}