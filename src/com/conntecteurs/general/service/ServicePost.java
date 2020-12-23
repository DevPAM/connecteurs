package com.conntecteurs.general.service;

import com.conntecteurs.exceptions.general.ParametreNullException;
import com.conntecteurs.general.api.IApi;
import com.conntecteurs.general.reponses.ReponseService;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;

public abstract class ServicePost<T> extends Service<T> {
    /** Intialise une nouvelle instance de la classe {@link Service}.
     * @param api     L'api de base sur laquelle le service s'exécute.
     * @param adresse L'adresse du service sur l'API. */
    public ServicePost(IApi api, String adresse) throws ParametreNullException {
        super(api, "POST", adresse);
    }
    @Override
    public ReponseService<T> appeler() throws IOException {
        HttpURLConnection connexion = this.obtenirConnection();
        String parametresService = this.obtenirParametres();
        if(parametresService != null) {
            // Ecritures des paramètres pour le service.
            connexion.setDoOutput(true);
            DataOutputStream sortie = new DataOutputStream(connexion.getOutputStream());
            sortie.writeBytes(parametresService);
            sortie.flush();
            sortie.close();
        }
        // Récupération du résultat.
        ReponseService<T> resultat = this.obtenirReponse(connexion);
        // Fermeture de la connexion.
        connexion.disconnect();
        // Retour du résultat.
        return resultat;
    }
    @Override
    protected String obtenirParametres() {
        StringBuilder resultat = new StringBuilder();
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
