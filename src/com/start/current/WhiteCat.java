package com.start.current;

public class WhiteCat extends  Cat {
    public void getWhiteInfo() {
        // we can't access private here!!!!
        System.out.println(publicName);
        System.out.println(defaultName);
        System.out.println(protectedName);
    }
}
