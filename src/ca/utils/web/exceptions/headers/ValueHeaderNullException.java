package ca.utils.web.exceptions.headers;

/** The exception throws if the value of the header is null or empty. */
public class ValueHeaderNullException extends Exception {
    /** Initialize a new instance of {@link ValueHeaderNullException} class.
     * @param key The value's key. */
    public ValueHeaderNullException(String key) {
        super(String.format("The header's value of '%s' can't be null or empty."));
    }
}
