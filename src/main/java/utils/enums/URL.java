package utils.enums;

public enum URL {

    REQRES("https://reqres.in");

    private String url;

    URL(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
