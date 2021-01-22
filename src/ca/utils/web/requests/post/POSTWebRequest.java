package ca.utils.web.requests.post;

import ca.utils.web.exceptions.send.ConnectionNullException;
import ca.utils.web.requests.EWebRequestMethod;
import ca.utils.web.requests.WebRequest;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/** Basic POST web request class. */
public class POSTWebRequest extends WebRequest  {
    /** Indicate if an parameter has already been added to the request. */
    protected boolean alreadyHasParameter;
    /**  Initialize a new instance of {@link POSTWebRequest} class.
     * @param address The web request's address. */
    public POSTWebRequest( String address) {
        super(EWebRequestMethod.POST, address);
        this.alreadyHasParameter = false;
    }
    @Override
    public String send() throws IOException, ConnectionNullException {
        HttpURLConnection connection = this.getBasicConnexion();
        // Write the body in the connexion.
        DataOutputStream dos = new DataOutputStream(connection.getOutputStream());
        dos.writeBytes(this.getBody());
        System.out.println(this.getBody());
        // Send and close.
        dos.flush(); dos.close();
        // Return the result.
        return this.readResponse(connection);
    }
    @Override
    public void addArgument(String key, String value) {
        String separator = "?";
        if(this.alreadyHasParameter) separator = "&";
        else this.alreadyHasParameter = true;
        this.addToBody(String.format("%s%s=%s",separator, URLEncoder.encode(key.replaceAll("\\s", "+"), StandardCharsets.UTF_8), URLEncoder.encode(value.replaceAll("\\s", "+"), StandardCharsets.UTF_8) ));
    }
}
