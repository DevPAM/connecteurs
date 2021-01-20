package ca.webservices.pastell;

import ca.utils.web.exceptions.headers.KeyHeaderNullException;
import ca.utils.web.exceptions.headers.ValueHeaderNullException;
import ca.utils.web.exceptions.send.ConnectionNullException;
import ca.utils.web.webservices.WebService;
import ca.utils.web.webservices.WebServiceAuthentication;
import ca.webservices.pastell.services.v3.DetailEntity;
import ca.webservices.pastell.services.v3.GetVersion;
import ca.webservices.pastell.services.v3.ListEntities;

import java.io.IOException;

/** Web service for Pastell. */
public class PastellWebService extends WebServiceAuthentication {
    /** Initialize a new instance of {@link WebService} class.
     * @param address The web service's adress.
     * @param login The API's login.
     * @param password the API's password.
     * @throws Exception If the web service address is null or empty. */
    public PastellWebService(String address, String login, String password) throws Exception {
        super(address, login, password);
    }
    /** Initialize a new instance of {@link WebService} class.
     * @param address The web service's address.
     * @param login The API's login.
     * @param password the API's password.
     * @param keystore The path to the keystore.
     * @param keystorepassword The keystore's password.
     * @throws Exception If the web service address is null or empty. */
    public PastellWebService(String address, String login, String password, String keystore, String keystorepassword) throws Exception {
        super(address, login, password);
        // Set the keystore ans key keystore password.
        // keystore : "C:\\personnel\\developpement\\certificats\\publickey.store"
        // password : "cg59500
        if(System.getProperty("javax.net.ssl.trustStore") == null) System.setProperty("javax.net.ssl.trustStore", keystore);
        if(System.getProperty("javax.net.ssl.trustStorePassword") == null) System.setProperty("javax.net.ssl.trustStorePassword", keystorepassword);
    }
    /** Get Pastell's API version.
     * @throws KeyHeaderNullException
     * @throws ValueHeaderNullException
     * @throws IOException
     * @throws ConnectionNullException */
    public String getVersion() throws KeyHeaderNullException, ValueHeaderNullException, IOException, ConnectionNullException {
        GetVersion service = new GetVersion(this);
        return service.call();
    }
    /** Get Pastell's entities.
     * @throws KeyHeaderNullException
     * @throws ValueHeaderNullException
     * @throws IOException
     * @throws ConnectionNullException*/
    public String listEntities() throws KeyHeaderNullException, ValueHeaderNullException, IOException, ConnectionNullException {
        ListEntities service = new ListEntities(this);
        return service.call();
    }
    /** Get Pastell entity's detail.
     * @param entity_id An entity id.
     * @throws KeyHeaderNullException
     * @throws ValueHeaderNullException
     * @throws IOException
     * @throws ConnectionNullException */
    public String getEntityDetail(int entity_id) throws KeyHeaderNullException, ValueHeaderNullException, IOException, ConnectionNullException {
        DetailEntity service = new DetailEntity(this, entity_id);
        return service.call();
    }
}
