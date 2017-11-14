package SPwebClients;

public enum HttpMethod {

    POST("POST"),
    PUT("PUT"),
    GET("GET"),
    DELETE("DELETE");

    private String method;

    private HttpMethod(String method) {
        this.method = method;
    }

    public String getMethod() {
        return method;
    }

    @Override
    public String toString() {
        return "HttpMethod{" +
                "method='" + method + '\'' +
                '}';
    }



}