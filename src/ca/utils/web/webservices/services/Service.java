package ca.utils.web.webservices.services;

import ca.utils.web.exceptions.headers.KeyHeaderNullException;
import ca.utils.web.exceptions.headers.ValueHeaderNullException;
import ca.utils.web.exceptions.send.ConnectionNullException;
import ca.utils.web.requests.WebRequest;

import java.io.IOException;

/** /** Class representing a service of a web services. */
public class Service {
    /** The request to send to the server. */
    protected WebRequest request;
    /** Initialize a new instance of {@link Service} class.
     * @param request The request to send to the server. */
    public Service(WebRequest request){
        this.request = request;
    }
    /** Add a value to the header.
     * @param key The headers key .
     * @param value The headers's value. */
    protected void addHeader(String key, String value) throws KeyHeaderNullException, ValueHeaderNullException {
        this.request.addHeader(key, value);
    }
    protected void addArgument(String key, String value){
        this.request.addArgument(key, value);
    }
    /** Call the service.
     * @return The result of the service. */
    public String call() throws IOException, ConnectionNullException {
        return this.request.send();
    }
}
