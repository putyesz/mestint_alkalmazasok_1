package kockak;

import java.awt.*;

public class Operator {

    Irany irany;

    public Operator(Irany irany) {
        this.irany = irany;
    }

    /**
     * Megadja, hogy alkalmazható-e egy operátor az adott állapotra.
     * @param allapot
     * @return az adott irányból van e lehetőség kockát billenteni
     */
    public boolean alkalmazhato(Allapot allapot) {
        switch (this.irany) {
            case Fel:
                return allapot.ures.x > 0;
            case Jobbra:
                return allapot.ures.y < 2;
            case Le:
                return allapot.ures.x < 2;
            case Balra:
                return allapot.ures.y > 0;
        }
        return false;
    }

    /**
     * Mátrix, amely leírja az adott irányból, a kocka állapotának függvényében, hogy a billentést végrehajtva,
     * milyen oldala látszik a kockának.
     */
    int[][] billentes = {
            //0,1,2,3,4,5,6
            {0, 5, 2, 1, 4, 6, 3},//Fentről
            {0, 3, 2, 6, 4, 1, 5},//Lentről
            {0, 2, 6, 3, 1, 5, 4},//Jobbról
            {0, 4, 1, 3, 6, 5, 2} //Balról
    };

    /**
     * Az operátorok hatásdefiníciója.
     * A tábla nagy része nem változik, 2 mezőt leszámítva, az adott iránynak megfelelően.
     * @param allapot
     * @return egy új állapotot
     */
    public Allapot alkalmaz(Allapot allapot) {
        Allapot uj = new Allapot();
        int[][] a = allapot.tabla;
        int[][] b = uj.tabla;

        for (int i  = 0; i < 3; i++)
            System.arraycopy(a[i], 0, b[i], 0, 3);

        switch (this.irany) {
            case Fel:
                b[allapot.ures.x - 1][allapot.ures.y] = 0;
                uj.ures = new Point(allapot.ures.x - 1, allapot.ures.y);
                b[allapot.ures.x][allapot.ures.y] = billentes[0][a[uj.ures.x][uj.ures.y]];
                break;
            case Le:
                b[allapot.ures.x + 1][allapot.ures.y] = 0;
                uj.ures = new Point(allapot.ures.x + 1, allapot.ures.y);
                b[allapot.ures.x][allapot.ures.y] = billentes[1][a[uj.ures.x][uj.ures.y]];
                break;
            case Balra:
                b[allapot.ures.x][allapot.ures.y - 1] = 0;
                uj.ures = new Point(allapot.ures.x, allapot.ures.y - 1);
                b[allapot.ures.x][allapot.ures.y] = billentes[2][a[uj.ures.x][uj.ures.y]];
                break;
            case Jobbra:
                b[allapot.ures.x][allapot.ures.y + 1] = 0;
                uj.ures = new Point(allapot.ures.x, allapot.ures.y + 1);
                b[allapot.ures.x][allapot.ures.y] = billentes[3][a[uj.ures.x][uj.ures.y]];
                break;
            default:
                break;
        }
        //System.out.println("\n\n" + this.irany + "\n" + uj);

        return uj;
    }

    @Override
    public String toString() {
        return "Operator : " + irany;
    }
}
