package com.htf.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by htf52 on 17-Nov-15.
 */
public class Variables {
    private static Variables instance = new Variables();
    private List<Lab> labs = new ArrayList<Lab>();

    private Variables() {
        labs.add(new Lab("com.htf.hello.HtfFirstDemo", "HTF First Demo", "HTF say hello to the world!"));
        labs.add(new Lab("com.htf.hello.FirstLab", "Mr.Haitt First Lab", "Hello World!"));
        labs.add(new Lab("com.htf.hello.SecondLab", "Mr.Haitt Second Lab", "Consuming web services: Register and Login", "Medium"));
    }

    public static Variables getInstance() {
        return instance;
    }

    public List<Lab> getLabs() {
        return labs;
    }

    public void setLabs(List<Lab> labs) {
        this.labs = labs;
    }
}
