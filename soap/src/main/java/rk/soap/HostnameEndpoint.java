package rk.soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import soap_server_test.rk.GetHostnameRequest;
import soap_server_test.rk.GetHostnameResponse;

@Endpoint
public class HostnameEndpoint {
    private static final String NAMESPACE_URI = "rk.soap-server-test";

    private HostnameReader hostnameReader;

    @Autowired
    public HostnameEndpoint(HostnameReader hostnameReader) {
        this.hostnameReader = hostnameReader;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getHostnameRequest")
    @ResponsePayload
    public GetHostnameResponse getHostname(@RequestPayload GetHostnameRequest request) {
        GetHostnameResponse response = new GetHostnameResponse();
        response.setHostname(hostnameReader.getHostname(request.getName()));

        return response;
    }
}
