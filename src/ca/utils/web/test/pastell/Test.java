package ca.utils.web.test.pastell;

import ca.utils.web.requests.GETWebRequest;

public class Test {
    public static void main(String[] args) {
        System.setProperty("javax.net.ssl.trustStore","C:\\personnel\\developpement\\certificats\\publickey.store");
        System.setProperty("javax.net.ssl.trustStorePassword","cg59500");
        try {
            GETWebRequest request = new GETWebRequest("https://pastell-tst.intranet.cg59.fr/api/v2/version");
            // GETWebRequest request = new GETWebRequest("https://www.google.com");
            request.addHeader("Authorization","Basic YWRtaW46YWRtaW4=");
            System.out.println(request.send());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
