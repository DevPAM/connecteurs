package ca.webservices.pastell.services.v3;

import ca.utils.web.exceptions.headers.KeyHeaderNullException;
import ca.utils.web.exceptions.headers.ValueHeaderNullException;
import ca.webservices.pastell.PastellWebService;
import ca.webservices.pastell.services.v3.sources.GETPastellService;

public class DetailEntity extends GETPastellService {
    /** Initialize a new instance of {@link DetailEntity} class.
     * @param service The service web service.  */
    public DetailEntity(PastellWebService service, int entity_id) throws KeyHeaderNullException, ValueHeaderNullException {
        super(service, String.format("/api/v2/entite/%d", entity_id));
        // Set the header's values.
        this.addHeader("Accept", "application/json");
    }
}
