package com.start.current;

public class Cat {
    public String publicName;
    String defaultName;
    protected String protectedName;
    private String privateName;
    public static String staticName;

    public Cat(String publicName) {
        this.publicName = publicName;
    }

    public Cat() {
    }

    public String getPrivateName() {
        return privateName;
    }

    public void setPrivateName(String privateName) {
        this.privateName = privateName;
    }


}
