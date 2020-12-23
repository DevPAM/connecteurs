package com.conntecteurs.general.service;

import com.conntecteurs.exceptions.general.ParametreNullException;
import com.conntecteurs.general.api.IApi;
import com.conntecteurs.general.reponses.ReponseService;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

/** Classe désignant un service. */
public abstract class Service<T> {
    /** L'API sur laquelle s'exécute de */
    private IApi api;
    /** La méthode d'appel du service. */
    protected String methode;
    /** L'adresse de l'API. */
    private String adresse;
    /** Les paramètres d'appel des la méthode. */
    protected HashMap<String, Object> parametres;
    /** Les paramètres du header. */
    protected HashMap<String, String> entetes;
    /** Intialise une nouvelle instance de la classe {@link Service}.
     * @param api L'api de base sur laquelle le service s'exécute.
     * @param methode La méthode utilisée pour le service.
     * @param adresse L'adresse du service sur l'API. */
    public Service(IApi api, String methode, String adresse) throws ParametreNullException {
        // Vérification des préconditions.
        if(methode == null || methode.trim() == "") throw new ParametreNullException("Service", "constructeur", "methode");
        if(adresse == null || adresse.trim() == "") throw new ParametreNullException("Service", "constructeur", "adresse");
        // Mise en place des valeurs de classe.
        this.api = api;
        this.methode = methode;
        this.adresse = adresse;
        this.entetes = new HashMap<String,String>();
        this.parametres = new HashMap<String, Object>();
    }
    /** Permet d'obtenir l'adresse complète du service.
     * @return @{@link String} L'adresse du du service complet. */
    protected String obtenirAdresse(){
        return this.api.obtenirAdresse()+"/"+this.adresse;
    }
    /** Méthode permettant d'obtenir les parametres formater pour l'appel du service. */
    protected abstract String obtenirParametres();
    /** Ajoute un valeur d'entête pour la requête.
     * @param nom Le nom de la valeur d'entête.
     * @param valeur La valeur de l'entete. */
    protected void ajouterEntete(String nom, String valeur) throws ParametreNullException {
        // Vérification des préconditions.
        if(nom == null || nom.trim() == "") throw new ParametreNullException("Service", "ajouterEntete", "nom");
        if(valeur == null || valeur.trim() == "") throw new ParametreNullException("Service", "ajouterEntete", "valeur");
        // Ajout de l'entete.
        this.entetes.put(nom, valeur);
    }
    /** Méthode permettant d'obtenir une connecion vers l'url du service.
     * @return @{@link HttpURLConnection} La connexion vers l'adresse du service. */
    protected  HttpURLConnection obtenirConnection() throws IOException {
        // Intialisation de la connexion.
        URL url = new URL(this.obtenirAdresse());
        HttpURLConnection connexion = (HttpURLConnection) url.openConnection();
        connexion.setRequestMethod(this.methode);
        // Ajout de chaque élément d'entes/
        for(String cle : this.entetes.keySet()) connexion.setRequestProperty(cle, this.entetes.get(cle));
        return connexion;
    }
    /** Méthode permettant d'obtenir la réponse de la requête.
     *  @param connexion La connexion vers l'adresse du service.
     *  @return @{@link ReponseService} La réponse de l'appel service. */
    protected abstract ReponseService<T> obtenirReponse(HttpURLConnection connexion);
    /** Méthode permettant d'appeler le service. */
    public abstract ReponseService<T> appeler() throws IOException;
}
