package ca.webservices.pastell.services.v3;

import ca.utils.web.exceptions.headers.KeyHeaderNullException;
import ca.utils.web.exceptions.headers.ValueHeaderNullException;
import ca.utils.web.webservices.services.GETService;
import ca.webservices.pastell.PastellWebService;
import ca.webservices.pastell.services.v3.sources.GETPastellService;

/** Service that get the web service version. */
public class GetVersion extends GETPastellService {
    /** Initialize a new instance of {@link GETService} class.
     * @param service The service's {@link PastellWebService}. */
    public GetVersion(PastellWebService service) throws KeyHeaderNullException, ValueHeaderNullException {
        super(service, "api/v2/version");
        // Set the header's values.
        this.addHeader("Accept", "application/json");
    }
}
