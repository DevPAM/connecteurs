package ca.utils.web.requests;

import ca.utils.web.exceptions.send.ConnectionNullException;
import ca.utils.web.requests.general.EWebRequestMethod;
import ca.utils.web.requests.general.WebRequest;

import java.io.IOException;
import java.net.HttpURLConnection;

/** The GET web request class. */
public class GETWebRequest extends WebRequest {
    /** Indicate if an parameter has already been added to the request. */
    private boolean alreadyHasParameter;
    /** Initialize a new instance of {@link POSTWebRequest} class.
     * @param address The web request's address. */
    public GETWebRequest(String address) {
        super(EWebRequestMethod.GET, address);
        this.alreadyHasParameter = false;
    }
    @Override
    public void addParameter(String key, String value) {
        String separator = null;
        if(this.alreadyHasParameter) {
            separator = "?";
            this.alreadyHasParameter = true;
        }else separator ="&";
        StringBuilder new_address = new StringBuilder(this.address);
        new_address.append(String.format("%s%s=%s", separator, key, value));
        this.address = new_address.toString();
    }
    @Override
    public String send() throws IOException, ConnectionNullException {
        return this.readResponse(this.getBasicConnexion());
    }
}
