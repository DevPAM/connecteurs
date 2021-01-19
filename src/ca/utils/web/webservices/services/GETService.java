package ca.utils.web.webservices.services;

import ca.utils.web.requests.GETWebRequest;
import ca.utils.web.webservices.definitions.IWebService;

/** Define a service that use the GET method. */
public class GETService extends GETWebRequest implements IService {
    /** The service web service. */
    private IWebService service;
    /** Initialize a new instance of {@link GETService} class.
     * @param address The web request's address. */
    public GETService(IWebService service, String address) {
        super(service.getBaseAddress()+'/'+address);
        this.service = service;
    }

    @Override
    public String call() {
        return null;
    }
}
