package com.conntecteurs.general.service;

import com.conntecteurs.exceptions.general.ParametreNullException;
import com.conntecteurs.general.api.IApi;
import com.conntecteurs.general.reponses.ReponseService;

import java.io.IOException;
import java.net.HttpURLConnection;

/** Service à appeler en méthode GET. */
public abstract class ServiceGet<T> extends Service<T> {
    /** Intialise une nouvelle instance de la classe {@link ServiceGet}.
     * @param api L'api de base sur laquelle le service s'exécute.
     * @param adresse L'adresse du service sur l'API. */
    public ServiceGet(IApi api, String adresse) throws ParametreNullException {
        super(api, "GET", adresse);
    }
    @Override
    public String obtenirAdresse(){
        StringBuilder resultat = new StringBuilder(super.obtenirAdresse());
        // Récupération des parametres du service.
        String apendice = this.obtenirParametres();
        if(apendice != null) resultat.append(apendice);
        // retour du résultat.
        return resultat.toString();
    }
    @Override
    public ReponseService<T> appeler() throws IOException {
        HttpURLConnection connection = this.obtenirConnection();
        // Récupération de la réponse du service.
        ReponseService<T> resultat = this.obtenirReponse(connection);
        // deconnexion.
        connection.disconnect();
        // Retour du résultat.
        return resultat;
    }
    @Override
    protected String obtenirParametres() {
        StringBuilder resultat = new StringBuilder("?");
        int taille = 0;
        // Parcours de tous les éléments de paramètres.
        for(String cle : this.parametres.keySet()) {
            // Mise en place des paramètres la requête.
            if(taille>0) resultat.append("&");
            // Vérification si la valeur est null.
            if(this.parametres.get(cle) == null) resultat.append(cle+"=null");
            else resultat.append(cle+"="+((String)this.parametres.get(cle)));
        }
        if(taille > 0) return resultat.toString();
        return null;
    }
}
