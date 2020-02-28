package kockak;

import java.awt.*;

public class Allapot {

    int[][] tabla;
    Point ures;

    public Allapot() {
        this.tabla = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        this.ures = new Point(1,1);
    }

    @Override
    public String toString() {
        return tabla[0][0] + "\t" + tabla[0][1] + "\t" + tabla[0][2] +"\n" +
                tabla[1][0] + "\t" + tabla[1][1] + "\t" + tabla[1][2] +"\n" +
                tabla[2][0] + "\t" + tabla[2][1] + "\t" + tabla[2][2];
    }

    /**
     * Célállapot esetén nem lényeg, hol van az üres mező, csak minden kocka sötét oldala nézzen felfelé.
     * @return célállapotban vagyunk-e?
     */
    public boolean cel(){
        int sum = 0;
        for (int i  = 0; i < 3; i++)
            for (int j  = 0; j < 3; j++)
                sum += tabla[i][j];
            return sum == 48;
    }

    @Override
    public int hashCode() {
        return tabla[0][0] * 100_000_000 + tabla[0][1] * 10_000_000 + tabla[0][2] * 1_000_000 +
                tabla[1][0] * 100_000 + tabla[1][1] * 10_000 + tabla[1][2] * 1_000 +
                tabla[2][0] * 100 + tabla[2][1] * 10 + tabla[2][2];
    }

    @Override
    public boolean equals(Object o) {
        Allapot a = (Allapot) o;
        for (int i  = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ( a.tabla[i][j] != this.tabla[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}

