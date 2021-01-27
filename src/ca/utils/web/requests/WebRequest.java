package ca.utils.web.requests;

import ca.utils.web.exceptions.headers.KeyHeaderNullException;
import ca.utils.web.exceptions.headers.ValueHeaderNullException;
import ca.utils.web.exceptions.send.ConnectionNullException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

/** Basic web request class. */
public abstract class WebRequest {
    /** The URL address. */
    protected String address;
    /** The header's value. */
    private final HashMap<String, String> headers;
    /** The body of the web request. */
    private final StringBuilder body;
    /** The web request's method. */
    private final EWebRequestMethod method;
    /** Initialize a new instance of {@link WebRequest} class.
     * @param method The web request's method.
     * @param address The web request's address. */
    public WebRequest(EWebRequestMethod method, String address) {
        this.method = method;
        this.address = address;
        this.headers = new HashMap<>();
        this.body = new StringBuilder();
    }
    /** Adds an element to the web address.
     * @param to_add Item added to web address. */
    public void addToAddress(String to_add) {
        if(to_add == null || to_add.isEmpty() || to_add.isBlank()) return;
        this.address = String.format("%s/%s", this.address, to_add);
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
    /** Adds an element to the body of the request.
     * @param to_add The element to add. */
    protected void addToBody(String to_add){
        this.body.append(to_add);
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
        connection.setUseCaches(false);
        connection.setDoOutput(true);
        connection.setDoInput(true);
        // Return the connection.
        return connection;
    }
    /** Read the result from a {@link HttpURLConnection} instance.
     * @param connection The connection to get the result.
     * @return String The connection result. */
    protected String readResponse(HttpURLConnection connection) throws IOException, ConnectionNullException {
        // Test the preconditions
        if(connection == null) throw new ConnectionNullException();
        connection.connect();
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
        // Get connection result.
        StringBuilder result = new StringBuilder();
        String reading;
        while((reading = br.readLine()) != null) result.append(reading.trim());
        br.close();
        connection.disconnect();
        // Return the result.
        return result.toString();
    }
    /** Retrieve the value of the body of the request.
     * @return String The value of the body of the request. */
    public String getBody() {
        return this.body.toString();
    }
    /** Send the request to the URL address.
     * @return String The web request's response. */
    public abstract String send() throws IOException, ConnectionNullException;
    /** Add an argument to the query.
     * @param key The name of the value to add.
     * @param value The value to add. */
    public abstract void addArgument(String key, String value);

}
