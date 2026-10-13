import java.util.Objects;

/**
 * Handler base da cadeia de contagem de caracteres.
 */
public abstract class ContadorTextHandler {
    protected ContadorTextHandler nextHandler;
    protected int count;

    /**
     * Define o próximo elo e o devolve para permitir a montagem fluente da cadeia.
     *
     * @param handler próximo handler
     * @return o handler recebido
     */
    public ContadorTextHandler setNextHandler(ContadorTextHandler handler) {
        this.nextHandler = handler;
        return handler;
    }

    /**
     * Processa um caractere ou o encaminha ao próximo elo.
     *
     * @param caracter caractere recebido
     */
    public void handleRequest(String caracter) {
        if (this.nextHandler != null) {
            this.nextHandler.handleRequest(caracter);
        }
    }

    /**
     * Retorna a quantidade acumulada por este handler.
     *
     * @return quantidade contada
     */
    public int getCount() {
        return count;
    }

    /**
     * Zera a contagem deste handler e dos próximos elos.
     */
    public void resetCount() {
        this.count = 0;
        if (this.nextHandler != null) {
            this.nextHandler.resetCount();
        }
    }

    /**
     * Envia cada caractere do texto para o primeiro elo da cadeia.
     *
     * @param text texto a ser contado
     */
    public void ContarText(String text) {
        Objects.requireNonNull(text, "text não pode ser nulo");
        for (int i = 0; i < text.length(); i++) {
            String caracter = String.valueOf(text.charAt(i));
            this.handleRequest(caracter);
        }
    }
}
