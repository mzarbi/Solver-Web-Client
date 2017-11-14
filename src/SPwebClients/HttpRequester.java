package SPwebClients;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.Consts;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

/**
 * Med Zied Arbi
 * Simple class used to facilitate requests and separate the logic from the UI.
 */
public class HttpRequester {

    private final HttpClient httpClient = HttpClients.createDefault();

    public FullHttpResponse call(String url, String method, Map<String, String> parameters) {

        StringBuilder responseRaw = new StringBuilder();
        FullHttpResponse result = null;
        HttpUriRequest request = null;
        HttpResponse response;
        if(method.equals(HttpMethod.GET.getMethod())) {
            request = new HttpGet(url);
        } else if(method.equals(HttpMethod.POST.getMethod())) {
            request = new HttpPost(url);
            List<NameValuePair> nvps = new ArrayList<>();
            for(Map.Entry<String, String> entry : parameters.entrySet()) {
                nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }

            ((HttpPost)request).setEntity(new UrlEncodedFormEntity(nvps, Consts.UTF_8));
        }

        try {
            response = this.httpClient.execute(request);
            result = new FullHttpResponse(response, request);
        } catch (IOException e) {
            e.printStackTrace();

        }

        return result;

    }

}