package ca.utils.web.requests;

import ca.utils.web.requests.general.EWebRequestMethod;
import ca.utils.web.requests.general.WebRequest;

/** Basic POST web request class. */
public class POSTWebRequest extends WebRequest  {
    /**  Initialize a new instance of {@link POSTWebRequest} class.
     * @param address The web request's address. */
    public POSTWebRequest( String address) {
        super(EWebRequestMethod.POST, address);
    }
    @Override
    public void addParameter(String key, String value) {
        return;
    }
    @Override
    public String send() {
        return null;
    }
}
