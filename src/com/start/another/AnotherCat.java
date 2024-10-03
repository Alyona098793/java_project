package com.start.another;

import com.start.current.Cat;

public class AnotherCat extends Cat {
    public void getAnotherInfo() {
        // we can't access private and private-packed here!!!!
        // we inside another packet
        System.out.println(publicName);
        System.out.println(protectedName);
    }
}
