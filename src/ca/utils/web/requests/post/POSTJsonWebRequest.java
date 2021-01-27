package ca.utils.web.requests.post;

import ca.utils.web.exceptions.headers.KeyHeaderNullException;
import ca.utils.web.exceptions.headers.ValueHeaderNullException;
import ca.utils.web.exceptions.send.ConnectionNullException;

import java.io.IOException;
import java.util.ArrayList;

/** Class for the web request using the post method */
public class POSTJsonWebRequest extends POSTWebRequest {
    private StringBuilder localBody;
    /** Initialize a new instance of {@link POSTJsonWebRequest} class.
     * @param address The web request's address. */
    public POSTJsonWebRequest(String address) throws KeyHeaderNullException, ValueHeaderNullException {
        super(address);
        this.localBody = new StringBuilder();
        this.addHeader("Content-Type", "application/json");
    }
    @Override
    public void addArgument(String key, String value) {
        if(this.alreadyHasParameter) this.localBody.append(",");
        else this.alreadyHasParameter = true;
        this.localBody.append(String.format("\"%s\":\"%s\"", key, value));
    }
    @Override
    public String send() throws IOException, ConnectionNullException {
        this.addToBody(String.format("{%s}", this.localBody.toString()));
        return super.send();
    }
    /** */
    public void addArgument(String key, ArrayList<String> values) {
        if(this.alreadyHasParameter) this.localBody.append(",");
        else this.alreadyHasParameter = true;
        boolean is_separated = false;
        this.localBody.append(String.format("\"%s\":[", key));
        for(String value : values) {
            if(!is_separated) is_separated = true;
            else this.localBody = this.localBody.append(",");
            this.localBody.append(String.format("\"%s\"", value));
        }
        this.localBody.append("]");
    }
}
