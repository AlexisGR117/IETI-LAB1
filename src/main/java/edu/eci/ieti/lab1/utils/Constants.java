package edu.eci.ieti.lab1.utils;

public interface Constants {

    String CLAIMS_ROLES_KEY = "ada_roles";
    String ADMIN_ROLE = "ADMIN";
    String USER_ROLE = "USER";
    String COOKIE_NAME = "Cookie name";

    int TOKEN_DURATION_MINUTES = 120;

    String MISSING_TOKEN_ERROR_MESSAGE = "Missing or wrong token";
    String TOKEN_EXPIRED_MALFORMED_ERROR_MESSAGE = "Token expired or malformed";
}