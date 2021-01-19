package ca.utils.web.requests.general;

/** Enumeration of web request methods. */
public enum EWebRequestMethod {
    /** The GET method. */
    GET("GET"),
    /** The HEAD method. */
    HEAD("HEAD"),
    /** The POST method. */
    POST("POST"),
    /** The PUT method. */
    PUT("PUT"),
    /** The DELETE method. */
    DELETE("DELETE"),
    /** The CONNECT method. */
    CONNECT("CONNECT"),
    /** The OPTIONS method. */
    OPTIONS("OPTIONS"),
    /** The TRACE method. */
    TRACE("TRACE"),
    /** The PATCH method. */
    PATCH("PATCH");
    /** The value of the enumeration. */
    public final String value;
    /** Initialize the value od the {@link EWebRequestMethod}. */
    private EWebRequestMethod(String value) {
        this.value = value;
    }
}
