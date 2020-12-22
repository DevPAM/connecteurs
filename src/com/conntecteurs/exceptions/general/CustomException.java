package com.conntecteurs.exceptions.general;
import java.lang.Exception;
/** Exception de base de la librairie. */
public class CustomException extends Exception {
    /** Message à retourner au client. */
    private String messageClient;
    /**Initialise une nouvelle instance de la classe {@link CustomException}.
     * @param messageRAI Le message à l'intention du RAI.
     * @param messageClient Le message à l'intention du client. */
    public CustomException(String messageRAI, String messageClient) {
        super(messageRAI);
        this.messageClient = messageClient;
    }
    /** Permet d'obtenir le message à l'intention du client.
     * @return @{@link String} Le message à l'intention du client. */
    public String obtenirMessageClient() {
        return this.messageClient;
    }
    /** Permet d'obtenir le message à l'intention du RAI (Responsable Application Informatique).
     * @return @{@link String} Le message à l'intention du RAI (Responsable Application Informatique). */
    public String obtenirMessageRai(){
        return super.getMessage();
    }
}
