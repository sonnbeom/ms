package com.hypeboy.hypeBoard.enums;

public enum EndPoint {
    LOGOUT(Path.LOGOUT),
    LOGIN_RESULT(Path.LOGIN_RESULT), //temp path
    LOGIN_ACTION(Path.LOGIN_ACTION),
    LOGIN(Path.LOGIN),
    SIGNUP_RESULT(Path.SIGNUP_RESULT),
    SIGNUP(Path.SIGNUP);

    public static class Path {
        public static final String LOGOUT = "/logout";
        public static final String LOGIN_RESULT = "/login_result";
        public static final String LOGIN_ACTION = "/login_action";
        public static final String LOGIN = "/login";
        public static final String SIGNUP_RESULT = "/signup_result";
        public static final String SIGNUP = "/signup";
        public static final String CREATE_POST = "/create_post";
        public static final String SESSION_CHECK = "/session_check";
        public static final String CLICK_POST = "/post/{postId}";
        public static final String CLICK_LIKE = "/post/{postId}/like/{userID}";


    }

    private final String path;


    EndPoint(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
