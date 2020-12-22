package com.conntecteurs.general.service;

import com.conntecteurs.general.api.IApi;

public class ServicePost extends Service {
    /** Intialise une nouvelle instance de la classe {@link Service}.
     * @param api     L'api de base sur laquelle le service s'exécute.
     * @param adresse L'adresse du service sur l'API. */
    public ServicePost(IApi api, String adresse) {
        super(api, "POST", adresse);
    }
    @Override
    public void appeler() { }
}
