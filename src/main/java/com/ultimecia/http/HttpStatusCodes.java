package com.ultimecia.http;

public enum HttpStatusCodes {
    /* CLIENT ERRORS */
    CLIENT_ERROR_400_BAD_REQUEST(400,"Bad request"),
    CLIENT_ERROR_401_METHOD_NOT_ALLOWED(401,"method not allowed"),
    CLIENT_ERROR_414_URI_TOO_LONG(414,"uri too long"),
    /* SERVER ERRORS */
    SERVER_ERROR_500_INTERNAL_SERVER_ERROR(500,"Internal server error"),
    SERVER_ERROR_501_NOT_IMPLEMENTED(501,"Not Implemented"),
    SERVER_ERROR_505_VERSION_NOT_SUPPORTED(505,"Version not supported");

    public final int  STATUS_CODE;
    public final String MESSAGE;

    private HttpStatusCodes(int  STATUS_CODE,String MESSAGE) {
        this.STATUS_CODE = STATUS_CODE;
        this.MESSAGE = MESSAGE;
    }

}
