package crypto.coin.connectionRequests;

import crypto.coin.utils.SSLTrustStore;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.net.ssl.SSLHandshakeException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpConnection {
    public HttpURLConnection connection;
    BufferedReader reader;
    String line;
    StringBuffer responseContent = new StringBuffer();

    public void httpConnection(String path) {
        try {
            URL url = new URL(path);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            int status = connection.getResponseCode();
            if (status > 299) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }
    }

    public static JSONObject getJsonResponse(String requesttype, String url) throws Exception {
        JSONObject jsonresult = new JSONObject();
        //JSONArray jsonarray = new JSONArray();
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        try {
            HttpResponse response;
            if (requesttype.equals("POST")) {
                HttpPost request = new HttpPost(url.replace(" ", "+"));
                request.addHeader("content-type", "application/json");

                SSLTrustStore.ssltrustinstall();

                response = httpClient.execute(request);

                HttpEntity entity = response.getEntity();

                if (entity != null) {
                    InputStream instream = entity.getContent();
                    String result = convertStreamToString(instream);

                     jsonresult = new JSONObject(result);
                    //jsonarray = new JSONArray(result);

                    instream.close();
                }
            } else if (requesttype.equals("GET")) {
                HttpGet request = new HttpGet(url.replace(" ", "+"));
                request.addHeader("content-type", "application/json");

                SSLTrustStore.ssltrustinstall();

                response = httpClient.execute(request);

                HttpEntity entity = response.getEntity();

                if (entity != null) {
                    InputStream instream = entity.getContent();
                    String result = convertStreamToString(instream);

                     jsonresult = new JSONObject(result);
                    //jsonarray = new JSONArray(result);

                    instream.close();
                }
            }
        } catch (SSLHandshakeException ex) {
            throw ex;
        } catch (Exception ex) {
            throw ex;
        } finally {
            httpClient.close();
        }
        return jsonresult;
    }

    public static JSONArray getJsonArrayResponse(String requesttype, String url) throws Exception {
        JSONArray jsonarray = new JSONArray();
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        try {
            HttpResponse response;
            if (requesttype.equals("POST")) {
                HttpPost request = new HttpPost(url.replace(" ", "+"));
                request.addHeader("content-type", "application/json");

                SSLTrustStore.ssltrustinstall();

                response = httpClient.execute(request);

                HttpEntity entity = response.getEntity();

                if (entity != null) {
                    InputStream instream = entity.getContent();
                    String result = convertStreamToString(instream);
                    jsonarray = new JSONArray(result);

                    instream.close();
                }
            } else if (requesttype.equals("GET")) {
                HttpGet request = new HttpGet(url.replace(" ", "+"));
                request.addHeader("content-type", "application/json");

                SSLTrustStore.ssltrustinstall();

                response = httpClient.execute(request);

                HttpEntity entity = response.getEntity();

                if (entity != null) {
                    InputStream instream = entity.getContent();
                    String result = convertStreamToString(instream);
                    jsonarray = new JSONArray(result);

                    instream.close();
                }
            }
        } catch (SSLHandshakeException ex) {
            throw ex;
        } catch (Exception ex) {
            throw ex;
        } finally {
            httpClient.close();
        }
        return jsonarray;
    }

    private static String convertStreamToString(InputStream is) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    public static String parseJSONarray(String responseBody) {
        JSONArray obj = new JSONArray(responseBody);
        return responseBody;
    }
}