package com.ultimecia.http;

public class HttpRequest extends HttpMessage{
    private HttpMethod method;
    private String requestTarget;
    private String originalHttpVersion;
    private HttpVersion bestCompatiableHttpVersion;

    HttpRequest(){
        
    }

    public HttpMethod getMethod() {
        return method;
    }

    public String getOriginalHttpVersion() {
        return originalHttpVersion;
    }

    public HttpVersion getBestCompatibleHttpVersion() {
        return bestCompatiableHttpVersion;
    }

    void setMethod(String methodName) throws HttpParsingException {
        for(HttpMethod method:HttpMethod.values()){
            if(methodName.equals(method.name())){
                this.method=method;
                return;
            }
        }
        throw new HttpParsingException(
            HttpStatusCodes.SERVER_ERROR_501_NOT_IMPLEMENTED
        );
    }

    void setRequestTarget(String requestTarget) throws HttpParsingException {
        if (requestTarget==null || requestTarget.length()==0) {
            throw new HttpParsingException(HttpStatusCodes.SERVER_ERROR_500_INTERNAL_SERVER_ERROR);
        }
        this.requestTarget=requestTarget;
    }

    public String getRequestTarget() {
        return requestTarget;
    }

    void setHttpVersion(String originalHttpVersion) throws BadHttpVersionException, HttpParsingException {
        this.originalHttpVersion = originalHttpVersion;
        this.bestCompatiableHttpVersion = HttpVersion.getBestCompatibleVersion(originalHttpVersion);
        if (this.bestCompatiableHttpVersion==null) {
            throw new HttpParsingException(HttpStatusCodes.SERVER_ERROR_505_VERSION_NOT_SUPPORTED);
        }
        
    }

}
