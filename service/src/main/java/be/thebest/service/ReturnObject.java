package be.thebest.service;

public class ReturnObject {
    private int returnCode;
    private String message;
    public static final int OK = 1;
    public static final int OK_WITH_MESSAGE = 2;
    public static final int ERROR = 3;

    private ReturnObject(int returnCode) {
        this.returnCode = returnCode;
    }

    public static ReturnObject returnObject(int returnCode) {
        if (returnCode != 1) {
            throw new IllegalArgumentException("Return code " + returnCode + " requires a return message.");
        }
        return new ReturnObject(returnCode);
    }

    private ReturnObject(int returnCode, String message) {
        this.returnCode = returnCode;
        this.message = message;
    }

    public static ReturnObject returnObject(int returnCode, String message) {
        if (returnCode == 1) {
            throw new IllegalArgumentException("Return code 1 does not accept a return message.");
        }
        return new ReturnObject(returnCode, message);
    }

    public int getReturnCode() {
        return returnCode;
    }

    public String getMessage() {
        return message;
    }
}
