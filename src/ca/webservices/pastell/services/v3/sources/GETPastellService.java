package ca.webservices.pastell.services.v3.sources;

import ca.utils.web.exceptions.headers.KeyHeaderNullException;
import ca.utils.web.exceptions.headers.ValueHeaderNullException;
import ca.utils.web.webservices.services.GETService;
import ca.webservices.pastell.PastellWebService;

/** Pastell's service that use the GET method. */
public class GETPastellService extends GETService {
    /** Initialize a new instance of {@link GETService} class.
     * @param service The service web service.
     * @param address The web request's address. */
    public GETPastellService(PastellWebService service, String address) throws KeyHeaderNullException, ValueHeaderNullException {
        super(service, address);
        // Set the header's values.
        this.addHeader("Authorization", ((PastellWebService)this.service).getBase64Authentication());
    }
}
