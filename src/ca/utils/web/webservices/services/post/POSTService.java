package ca.utils.web.webservices.services.post;

import ca.utils.web.requests.post.POSTWebRequest;
import ca.utils.web.webservices.definitions.IWebService;
import ca.utils.web.webservices.services.Service;

/** Define a service that use the POST method. */
public class POSTService extends Service {
    /** The service web service. */
    protected IWebService service;
    /** Initialize a new instance of {@link POSTService} class.
     * @param service The web service to which the service is attached.
     * @param address The address (shortcuts) of the service within the web service. */
    public POSTService(IWebService service, String address) {
        super( new POSTWebRequest(service.getBaseAddress()) );
        this.request.addToAddress(address);
        this.service = service;
    }
    /** Initialize a new instance of {@link POSTService} class.
     * @param service The web service to which the service is attached.
     * @param request The address (shortcuts) of the service within the web service. */
    public POSTService(IWebService service, POSTWebRequest request) {
        super(request);
        this.service = service;
    }
}
