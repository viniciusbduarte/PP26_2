/**
 * Handler responsável por contar pontos finais.
 */
public class ContadorPonto extends ContadorTextHandler {
    /**
     * Incrementa a contagem quando recebe um ponto; caso contrário, encaminha.
     *
     * @param caracter caractere recebido
     */
    @Override 
    public void handleRequest(String caracter) {
        if (caracter.equals(".")) {
            this.count++;
        } else {
            super.handleRequest(caracter);
        }
    }
}
