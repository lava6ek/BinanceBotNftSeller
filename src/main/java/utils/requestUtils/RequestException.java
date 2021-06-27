package utils.requestUtils;

public class RequestException extends Exception {
    String errorBody;

    public RequestException(String message, String errorBody){
        super(message);
        this.errorBody = errorBody;
    }

    public String getBody() {
        return errorBody;
    }

}
