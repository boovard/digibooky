package be.thebest.api;

public class ReturnObjectDto {
    private int returnCode;
    private String message;

    public static ReturnObjectDto returnObjectDto() {
        return new ReturnObjectDto();
    }

    public ReturnObjectDto withReturnCode(int returnCode) {
        this.returnCode = returnCode;
        return this;
    }

    public ReturnObjectDto withMessage(String message) {
        this.message = message;
        return this;
    }

    public int getReturnCode() {
        return returnCode;
    }

    public String getMessage() {
        return message;
    }
}
