package ca.utils.web.webservices;

import ca.utils.web.webservices.definitions.IAuthenticatedWebService;

import java.util.Base64;

/** An authenticated web service. */
public class WebServiceAuthentication extends WebService implements IAuthenticatedWebService {
    /** The Web service's login. */
    private String login;
    /** The web service's password. */
    private String password;
    /** Initialize a new instance of {@link WebService} class.
     * @param address The web service's address.
     * @throws Exception If the web service address is null or empty. */
    public WebServiceAuthentication(String address, String login, String password) throws Exception {
        super(address);
        this.login = login;
        this.password = password;
    }
    @Override
    public String getBase64Authentication() {
        return Base64.getEncoder().encodeToString((String.format("%s=%s", this.login, this.password).getBytes()));
    }
}
