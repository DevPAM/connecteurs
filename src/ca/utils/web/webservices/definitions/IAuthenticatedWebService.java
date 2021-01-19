package ca.utils.web.webservices.definitions;

/** Contract interface for web services with authentication. */
public interface IAuthenticatedWebService {
    /** Get the web service login. */
    public String getLogin();
    /** Get the Web service password's login. */
    public String GetPassword();
}
