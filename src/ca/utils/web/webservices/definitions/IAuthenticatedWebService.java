package ca.utils.web.webservices.definitions;

/** Contract interface for web services with authentication. */
public interface IAuthenticatedWebService extends IWebService {
    /** Get the base 64 for the authentication.
     * @return The base 64 for the authentication. */
    public String getBase64Authentication();
}
