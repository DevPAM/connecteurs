package ca.utils.web.webservices.services;

import ca.utils.web.exceptions.send.ConnectionNullException;
import ca.utils.web.requests.GETWebRequest;
import ca.utils.web.webservices.definitions.IWebService;

import java.io.IOException;

/** Define a service that use the GET method. */
public class GETService extends GETWebRequest implements IService {
    /** The service web service. */
    protected IWebService service;
    /** Initialize a new instance of {@link GETService} class.
     * @param service The service's web services.
     * @param address The web request's address. */
    public GETService(IWebService service, String address) {
        super(service.getBaseAddress()+'/'+address);
        this.service = service;
    }
    @Override
    public String call() throws IOException, ConnectionNullException {
        return this.send();
    }
}
