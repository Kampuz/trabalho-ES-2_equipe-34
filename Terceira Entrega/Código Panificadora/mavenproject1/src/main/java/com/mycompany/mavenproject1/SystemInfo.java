package com.mycompany.mavenproject1;

public class SystemInfo {

    private SystemInfo() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static String javaVersion() {
        return System.getProperty("java.version");
    }

    public static String javafxVersion() {
        return System.getProperty("javafx.version");
    }

}