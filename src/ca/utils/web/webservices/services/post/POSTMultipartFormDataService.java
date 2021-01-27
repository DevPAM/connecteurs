package ca.utils.web.webservices.services.post;

import ca.utils.web.exceptions.headers.KeyHeaderNullException;
import ca.utils.web.exceptions.headers.ValueHeaderNullException;
import ca.utils.web.requests.post.POSTMultipartFormDataWebRequest;
import ca.utils.web.webservices.WebService;

/** Class for a service using the POST method with content at Mutilpart Form-data. */
public class POSTMultipartFormDataService extends POSTService {
    /** Initialize a new instance of {@link POSTMultipartFormDataService} class.
     * @param service The web service to which the service is attached.
     * @param  address The address of the service. */
    public POSTMultipartFormDataService(WebService service, String address) throws KeyHeaderNullException, ValueHeaderNullException {
        super(service, new POSTMultipartFormDataWebRequest(service.getBaseAddress()));
        this.request.addToAddress(address);
    }
}
