package ca.utils.web.webservices.services;

import ca.utils.web.exceptions.send.ConnectionNullException;
import ca.utils.web.requests.POSTWebRequest;
import ca.utils.web.webservices.definitions.IWebService;

import java.io.IOException;

/** Define a service that use the POST method. */
public class POSTService extends POSTWebRequest implements IService {
    /** The service web service. */
    protected IWebService service;
    /** Initialize a new instance of {@link POSTService} class.
     * @param service The service's web services.
     * @param address The web request's address. */
    public POSTService(IWebService service,String address) {
        super(service.getBaseAddress()+'/'+address);
        this.service = service;
    }
    /** Call the service. */
    @Override
    public String call() throws IOException, ConnectionNullException {
        return this.send();
    }
}
