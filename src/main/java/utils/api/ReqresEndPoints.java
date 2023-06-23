package utils.api;

public enum ReqresEndPoints {

    GET_USERS_LIST("/api/users"),
    GET_SINGLE_USER("/api/users/"),

    POST_CREATE_USER("/api/users"),
    PUT_CREATE_USER("/api/users/"),
    PATCH_CREATE_USER("/api/users/"),
    DELETE_CREATE_USER("/api/users/");

    private String endPoint;

    ReqresEndPoints(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }
}
