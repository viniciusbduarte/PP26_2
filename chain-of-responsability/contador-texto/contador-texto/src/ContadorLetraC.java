/**
 * Handler opcional para contar as letras 'c' e 'C'.
 */
public class ContadorLetraC extends ContadorTextHandler {
    /**
     * Incrementa a contagem quando recebe 'c' ou 'C'; caso contrário, encaminha.
     *
     * @param caracter caractere recebido
     */
    @Override 
    public void handleRequest(String caracter) {
        if (caracter.equals("C") || caracter.equals("c")) {
            this.count++;
        } else {
            super.handleRequest(caracter);
        }
    }
}
