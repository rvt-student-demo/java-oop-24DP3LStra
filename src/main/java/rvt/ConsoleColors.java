package rvt;

public enum ConsoleColors {
    RESET ("\u001B[0m"),
    RED ("\u001B[31m");

    private final String code;

    ConsoleColors(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
