package ca.utils.web.requests.general;

import ca.utils.web.exceptions.headers.KeyHeaderNullException;
import ca.utils.web.exceptions.headers.ValueHeaderNullException;
import ca.utils.web.exceptions.send.ConnectionNullException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

/** Basic web request class. */
public abstract class WebRequest {
    /** The URL address. */
    protected String address;
    /** The header's value. */
    private final HashMap<String, String> headers;
    /** The web request's method. */
    private final EWebRequestMethod method;
    /** Initialize a new instance of {@link WebRequest} class.
     * @param method The web request's method.
     * @param address The web request's address. */
    public WebRequest(EWebRequestMethod method, String address) {
        this.method = method;
        this.address = address;
        this.headers = new HashMap<>();
    }
    /** Add a value to the header.
     * @param key The headers key .
     * @param value The headers's value. */
    public void addHeader(String key, String value) throws KeyHeaderNullException, ValueHeaderNullException {
        // Check the preconditions.
        if(key == null || key.trim().isBlank() || key.trim().isEmpty()) throw new KeyHeaderNullException();
        if(value == null || value.trim().isEmpty() || value.trim().isBlank()) throw  new ValueHeaderNullException(key);
        // Set the headers.
        this.headers.put(key, value);
    }
    /** Get the connection to the URL address.
     * @return  HttpURLConnection The connection to the web request URL. */
    protected HttpURLConnection getBasicConnexion() throws IOException {
        // Set the connexion.
        URL url = new URL(this.address);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        // Set web request's method connection.
        connection.setRequestMethod(this.method.value);
        // Set the headers.
        for(String key : this.headers.keySet()) connection.setRequestProperty(key, this.headers.get(key));
        connection.setDoOutput(true);
        // Return the connection.
        return connection;
    }
    /** Read the result from a {@link HttpURLConnection} instance.
     * @param connection The connection to get the result.
     * @return String The connection result. */
    protected String readResponse(HttpURLConnection connection) throws IOException, ConnectionNullException {
        // Test the preconditions
        if(connection == null) throw new ConnectionNullException();
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(),  "utf-8"));
        // Get connection result.
        StringBuilder result = new StringBuilder();
        String reading = null;
        while((reading = br.readLine()) != null) result.append(reading.trim());
        br.close();
        // Return the result.
        return result.toString();
    }
    /** Add a parameter into the web request. */
    public abstract void addParameter(String key, String value);
    /** Send the request to the URL address.
     * @return String The web request's response. */
    public abstract String send() throws IOException, ConnectionNullException;
}
