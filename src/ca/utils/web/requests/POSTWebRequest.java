package ca.utils.web.requests;

import ca.utils.web.exceptions.send.ConnectionNullException;
import ca.utils.web.requests.general.EWebRequestMethod;
import ca.utils.web.requests.general.WebRequest;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;

/** Basic POST web request class. */
public class POSTWebRequest extends WebRequest  {
    /** The request body. */
    private final StringBuilder body;
    /**  Initialize a new instance of {@link POSTWebRequest} class.
     * @param address The web request's address. */
    public POSTWebRequest( String address) {
        super(EWebRequestMethod.POST, address);
        this.body = new StringBuilder();
    }
    /** Add a parameter in content type "multipart/form-data".
     * @param key The parameter's key.
     * @param value The parameter's value. */
    public void addFormDataParameter(String key, String value) {
        this.body.append(String.format("Content-Disposition: form-data; name=\"%s\"\n\n%s\n", key, value));
    }
    @Override
    public String send() throws IOException, ConnectionNullException {
        HttpURLConnection connection = this.getBasicConnexion();
        // Write the body in the connexion.
        OutputStreamWriter osw = new OutputStreamWriter(connection.getOutputStream(), StandardCharsets.UTF_8);
        osw.write(this.body.toString());
        osw.flush();
        osw.close();
        // DEBUG
        System.out.println(this.body.toString());
        // Return the result.
        return this.readResponse(connection);
    }
}
