package com.conntecteurs.general.service;

import com.conntecteurs.general.api.IApi;

/** Classe désignant un service. */
public abstract class Service {
    /** L'API sur laquelle s'exécute de */
    private IApi api;
    /** L'adresse de l'API. */
    private String adresse;
    /** */
    /** Intialise une nouvelle instance de la classe {@link Service}.
     * @param api L'api de base sur laquelle le service s'exécute.
     * @param methode La méthode utilisée pour le service.
     * @param adresse L'adresse du service sur l'API. */
    public Service(IApi api, String methode, String adresse){
        this.api = api;
        this.adresse = adresse;
    }
    /** Permet d'obtenir l'adresse complète du service.
     * @return @{@link String} L'adresse du du service complet. */
    public String obtenirAdresse(){
        return this.api.obtenirAdresse()+"/"+this.adresse;
    }
    /** Méthode permettant d'appeler le service. */
    public abstract void appeler();
}
