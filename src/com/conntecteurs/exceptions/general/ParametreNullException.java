package com.conntecteurs.exceptions.general;
/** Classe d'exception lancée lorsque le paramètre du méthode est null ou vide alors qu'il ne devrait pas. */
public class ParametreNullException extends CustomException {
    /** Initialise une nouvelle instance de la classe {@link ParametreNullException}.
     * @param parametre @{@link String} Le nom du paramètre ayant provoqué l'{@link Exception}. */
    public ParametreNullException(String classe, String methode, String parametre) {
        super("Veuillez saisir le paramètre '"+parametre+"' de la méthode '"+methode+"' dans la classe '"+classe+"'.",
              "Une erreur innatendue est survenue. Veuillez retenter plus tard svp.");
    }
}
