package ca.utils.web.webservices.services;

import ca.utils.web.exceptions.send.ConnectionNullException;

import java.io.IOException;

/** Contract interface for a service.  */
public interface IService {
    /** Call the Service. */
    public String call() throws IOException, ConnectionNullException;
}
