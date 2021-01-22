package ca.utils.web.requests.get;

import ca.utils.web.exceptions.send.ConnectionNullException;
import ca.utils.web.requests.EWebRequestMethod;
import ca.utils.web.requests.WebRequest;
import ca.utils.web.requests.post.POSTWebRequest;

import java.io.IOException;

/** The GET web request class. */
public class GETWebRequest extends WebRequest {
    /** Indicate if an parameter has already been added to the request. */
    protected boolean alreadyHasParameter;
    /** Initialize a new instance of {@link POSTWebRequest} class.
     * @param address The web request's address. */
    public GETWebRequest(String address) {
        super(EWebRequestMethod.GET, address);
        this.alreadyHasParameter = false;
    }
    @Override
    public String send() throws IOException, ConnectionNullException {
        return this.readResponse(this.getBasicConnexion());
    }
    @Override
    public void addArgument(String key, String value) {
        String separator = "?";
        if(this.alreadyHasParameter) separator = "&";
        else this.alreadyHasParameter = true;
        this.addToAddress(String.format("%s%s=%s",separator, key, value));
    }
}
