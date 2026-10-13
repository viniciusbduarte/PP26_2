/**
 * Handler responsável por contar espaços.
 */
public class ContadorEspaco extends ContadorTextHandler {
    /**
     * Incrementa a contagem quando recebe um espaço; caso contrário, encaminha.
     *
     * @param caracter caractere recebido
     */
    @Override 
    public void handleRequest(String caracter) {
        if (caracter.equals(" ")) {
            this.count++;
        } else {
            super.handleRequest(caracter);
        }
    }
}