package com.javarush.task.task17.task1706;

public class OurPresident {

    static {
        synchronized (OurPresident.class) {
            if (OurPresident.president == null) {
                president = new OurPresident();
            }
        }

    }

    private static OurPresident president;

    private OurPresident() {
    }

    public static OurPresident getOurPresident() {
        return president;
    }
}
