package ca.utils.web.webservices.services.get;

import ca.utils.web.exceptions.headers.KeyHeaderNullException;
import ca.utils.web.exceptions.headers.ValueHeaderNullException;
import ca.utils.web.exceptions.send.ConnectionNullException;
import ca.utils.web.requests.get.GETWebRequest;
import ca.utils.web.webservices.WebService;
import ca.utils.web.webservices.services.Service;

import java.io.IOException;

/** Define a service that use the GET method. */
public class GETService extends Service {
    /** The service web service. */
    protected WebService service;
    /** Initialize a new instance of {@link GETService} class.
     * @param service The service's web services.
     * @param address The web request's address. */
    public GETService(WebService service, String address) {
        super(new GETWebRequest(service.getBaseAddress()));
        this.request.addToAddress(address);
        this.service = service;
    }
}
