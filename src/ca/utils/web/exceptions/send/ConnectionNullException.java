package ca.utils.web.exceptions.send;

/** Throw this {@link Exception} when the {@link java.net.HttpURLConnection} is null or empty. */
public class ConnectionNullException extends Exception {
    /** Initialize a new instance of {@link ConnectionNullException} class. */
    public ConnectionNullException(){
        super("The web request connexion can't be null or empty.");
    }
}
