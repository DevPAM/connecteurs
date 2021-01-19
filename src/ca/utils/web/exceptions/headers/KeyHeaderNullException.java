package ca.utils.web.exceptions.headers;

/** The exception throws if the key of the header is null or empty. */
public class KeyHeaderNullException extends Exception {
    /** Initialize a new instance of {@link KeyHeaderNullException} is null or empty.  */
    public KeyHeaderNullException(){
        super("A header's key can't be null or empty.");
    }
}
