import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

/**
 * Ponto de entrada da aplicação de contagem de caracteres.
 *
 * <p>O texto pode ser informado diretamente ou carregado de um arquivo:
 * {@code java App "texto"} ou {@code java App --file caminho.txt}.</p>
 */
public class App {
    /**
     * Inicia a aplicação.
     *
     * @param args texto entre aspas ou a opção {@code --file} seguida do caminho
     */
    public static void main(String[] args) {
        runApplication(args);
    }

    /**
     * Executa a aplicação e mantém o tratamento de entrada separado do ponto
     * de entrada do programa.
     *
     * @param args argumentos recebidos pelo processo
     */
    private static void runApplication(String[] args) {
        if (args.length == 0) {
            System.err.println("Uso: java App \"texto\" | java App --file caminho.txt");
            return;
        }

        try {
            String text = readInput(args);
            printStatistics(text);
        } catch (IOException | IllegalArgumentException exception) {
            printInputError(exception);
        }
    }

    /**
     * Conta o texto usando a cadeia de responsabilidade e imprime o resultado.
     *
     * @param text texto a ser contado
     */
    private static void printStatistics(String text) {
        ContadorLetraA contadorA = new ContadorLetraA();
        ContadorLetraC contadorC = new ContadorLetraC();
        ContadorEspaco contadorEspaco = new ContadorEspaco();
        ContadorPonto contadorPonto = new ContadorPonto();

        contadorA.setNextHandler(contadorC)
                .setNextHandler(contadorEspaco)
                .setNextHandler(contadorPonto);

        contadorA.ContarText(text);

        System.out.println("\nContagem final:");
        System.out.println("Letras A: " + contadorA.getCount());
        System.out.println("Letras C: " + contadorC.getCount());
        System.out.println("Espaços: " + contadorEspaco.getCount());
        System.out.println("Pontos: " + contadorPonto.getCount());
    }

    /**
     * Exibe uma mensagem padronizada para falhas na entrada.
     *
     * @param exception exceção que descreve a falha
     */
    private static void printInputError(Exception exception) {
        System.err.println("Não foi possível processar a entrada: " + exception.getMessage());
    }

    /**
     * Interpreta os argumentos como texto literal ou caminho de arquivo.
     *
     * @param args argumentos recebidos pelo processo
     * @return texto a ser processado
     * @throws IOException se o arquivo não puder ser lido
     */
    private static String readInput(String[] args) throws IOException {
        if ("--file".equals(args[0])) {
            if (args.length != 2) {
                throw new IllegalArgumentException("Informe exatamente um caminho após --file.");
            }
            return Files.readString(Path.of(args[1]), StandardCharsets.UTF_8);
        }
        return String.join(" ", Arrays.asList(args));
    }
}
