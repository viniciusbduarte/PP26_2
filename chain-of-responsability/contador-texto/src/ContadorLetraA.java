/**
 * Handler responsável por contar as letras 'a' e 'A'.
 */
public class ContadorLetraA extends ContadorTextHandler {  
    /**
     * Incrementa a contagem quando recebe 'a' ou 'A'; caso contrário, encaminha.
     *
     * @param caracter caractere recebido
     */
    @Override 
    public void handleRequest(String caracter) {
        if (caracter.equals("A") || caracter.equals("a")) {
            this.count++;
        } else {
            super.handleRequest(caracter);
        }
    }
  }
