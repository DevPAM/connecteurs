package ca.utils.web.webservices;

import ca.utils.web.webservices.definitions.IWebService;

/** Basic class for web service. */
public class WebService implements IWebService {
    /** The web service's address. */
    private final String address;
    /** Initialize a new instance of {@link WebService} class.
     * @param address The web service's address.
     * @throws Exception If the web service address is null or empty. */
    public WebService(String address) throws Exception {
        if(address == null || address.isEmpty() || address.isBlank()) throw new Exception("Set the web service address please.");
        // Set the class parameters.
        this.address = address;
    }
    @Override
    public String getBaseAddress() {
        return this.address;
    }
}
