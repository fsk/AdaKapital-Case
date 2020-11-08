package com.adakapital.adakapitalbackendcase.messages.errormessages;

public final class UserErrorMessages {

    public static final String BASE_ERROR_MESSAGE = "ERROR.! ";

    public static final String SYSTEM_ERROR_MESSAGE = "System Error Message : ";

    public static final String SYSTEM_CAUSE_MESSAGE = "System Cause Message : ";

    public static final String INSERT_ERROR = BASE_ERROR_MESSAGE + "User Could Not INSERT.";

    public static final String DELETE_BY_ID_ERROR = BASE_ERROR_MESSAGE + "User Could Not DELETE.";

    public static final String DELETE_ALL_USERS_ERROR = BASE_ERROR_MESSAGE + "Users Could Not DELETE.";
    
    public static final String INVALID_EMAIL = BASE_ERROR_MESSAGE + "Invalid E-Mail.";
    
    public static final String EMAIL_ALREADY_EXISTS = BASE_ERROR_MESSAGE + "This E-Mail Already Exists.";
    
    public static final String USER_NOT_FOUND = BASE_ERROR_MESSAGE + "This User Could Not Found.";
    
    public static final String CREATED_TIME_NOT_CHANGE = BASE_ERROR_MESSAGE + "You Can Not Change Created Date.";
    
    public static final String UPDATE_BY_ID_ERROR_MESSAGE = BASE_ERROR_MESSAGE + "User Could Not UPDATE.";
}
