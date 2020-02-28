package kockak;

import java.util.ArrayList;
import java.util.List;

public class Problema {
    public Allapot kezdo() {
        return new Allapot();
    }

    static List<Operator> OPERATOROK = new ArrayList<Operator>();
    static {
        for (Irany i : Irany.values())
            OPERATOROK.add(new Operator(i));
    }


    public List<Operator> operatorok() {
        return OPERATOROK;
    }
}
