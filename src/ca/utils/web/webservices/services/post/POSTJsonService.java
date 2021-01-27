package ca.utils.web.webservices.services.post;

import ca.utils.web.exceptions.headers.KeyHeaderNullException;
import ca.utils.web.exceptions.headers.ValueHeaderNullException;
import ca.utils.web.requests.post.POSTJsonWebRequest;
import ca.utils.web.webservices.definitions.IWebService;

import java.util.ArrayList;

/** Class for services using the POST method with a JSON body. */
public class POSTJsonService extends POSTService {
    /** Initialize a new instance of {@link POSTJsonService} class.
     * @param service The web service to which the service is attached.
     * @param address The address of the service. */
    public POSTJsonService(IWebService service, String address) throws KeyHeaderNullException, ValueHeaderNullException {
        super(service, new POSTJsonWebRequest(service.getBaseAddress()));
        this.request.addToAddress(address);
    }
    /** Add an array type argument in the body.
     * @param key The argument key.
     * @param values The argument values. */
    public void addArgument(String key, ArrayList<String> values){
        ((POSTJsonWebRequest)this.request).addArgument(key, values);
    }
}
