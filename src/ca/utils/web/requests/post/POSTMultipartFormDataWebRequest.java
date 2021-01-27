package ca.utils.web.requests.post;

import ca.utils.web.exceptions.headers.KeyHeaderNullException;
import ca.utils.web.exceptions.headers.ValueHeaderNullException;

    public class POSTMultipartFormDataWebRequest extends POSTWebRequest {
    /** Value of the boundary between the parameters of the request body. */
    private final String boundary;
    /** Line break value in the request body. */
    private final String crlf;
    /** Initialize a new instance of {@link POSTMultipartFormDataWebRequest} class.
     * @param address The web request's address. */
    public POSTMultipartFormDataWebRequest(String address) throws KeyHeaderNullException, ValueHeaderNullException {
        super(address);
        // Initialization of the values of the class.
        this.crlf = "\r\n";
        this.boundary = "JavaWebFormDataWebRequestBoundary";
        // Adding the necessary headers.
        this.addHeader("Content-Type", String.format("multipart/form-data;boundary=\"%s\"", this.boundary));
    }
    @Override
    public void addArgument(String key, String value) {
        if(!this.alreadyHasParameter) {
            this.addToBody(String.format("%s--%s%s", this.crlf, this.boundary, this.crlf));
            this.alreadyHasParameter = true;
        }
        this.addToBody(String.format("Content-Disposition: form-data; name=\"%s\"%s%s%s%s--%s%s", key, this.crlf, this.crlf, value, this.crlf, this.boundary, this.crlf));
    }
}
