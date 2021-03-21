package com.flights.api;

public class Utils {

    public static String logRequest(String tenant, String method, String uri) {
        return tenant + ": " + method + " " + uri;
    }

    public static String formatError(String name, String message) {
        return name + ": " + message;
    }
}
