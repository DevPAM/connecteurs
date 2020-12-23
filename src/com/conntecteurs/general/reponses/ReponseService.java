package com.conntecteurs.general.reponses;
/** Modele de donnée pour une réponse de la part d'un service. */
public class ReponseService<T> {
    /** Le statut vers l'appel service. */
    public int statut;
    /** La réponse de l'API en cas de succes. */
    public T reponseSucces;
    /** La réponse de l'API en cas d'erreur'. */
    public T reponseErreur;
    /** La réponse de l'API en cas d'echec. */
    /** Initialise une nouvelle instance de la classe {@link ReponseService}. */
    public ReponseService(){
        this.statut = -1;
        this.reponseSucces = null;
        this.reponseErreur = null;
    }
}
