package kockak;

import java.awt.*;

public class Operator {

    Irany irany;

    public Operator(Irany irany) {
        this.irany = irany;
    }

    /**
     * Megadja, hogy alkalmazható-e egy operátor az adott állapotra.
     * @param allapot, amire megnézzük, hogy alkalmazható-e bizonyos operátor
     * @return az adott irányból van e lehetőség kockát billenteni
     */
    public boolean alkalmazhato(Allapot allapot) {
        switch (this.irany) {
            case Fel:
                return allapot.getUres().x > 0;
            case Jobbra:
                return allapot.getUres().y < 2;
            case Le:
                return allapot.getUres().x < 2;
            case Balra:
                return allapot.getUres().y > 0;
        }
        return false;
    }

    /**
     * Mátrix, amely leírja az adott irányból, a kocka állapotának függvényében, hogy a billentést végrehajtva,
     * milyen oldala látszik a kockának.
     */
    int[][] billentes = {
           //0, 1, 2, 3, 4, 5, 6
            {0, 5, 2, 1, 4, 6, 3},//Fentről
            {0, 3, 2, 6, 4, 1, 5},//Lentről
            {0, 2, 6, 3, 1, 5, 4},//Balról
            {0, 4, 1, 3, 6, 5, 2} //Jobbról
    };

    /**
     * Az operátorok hatásdefiníciója.
     * A tábla nagy része nem változik, 2 mezőt leszámítva, az adott iránynak megfelelően.
     * @param allapot, amelyre az operátort alkamazni szeretnénk
     * @return egy új állapotot
     */
    public Allapot alkalmaz(Allapot allapot) {
        Allapot uj = new Allapot();
        int[][] a = allapot.tabla;
        int[][] b = uj.tabla;

        for (int i  = 0; i < 3; i++)
            System.arraycopy(a[i], 0, b[i], 0, 3);

        Point pAllapot = allapot.getUres();
        Point pUj = uj.getUres();
        switch (this.irany) {
            case Fel:
                pUj.x--;
                b[pAllapot.x][pAllapot.y] = billentes[0][a[pUj.x][pUj.y]];
                b[pUj.x][pUj.y] = 0;
                break;
            case Le:
                pUj.x++;
                b[pAllapot.x][pAllapot.y] = billentes[1][a[pUj.x][pUj.y]];
                b[pUj.x][pUj.y] = 0;
                break;
            case Balra:
                pUj.y--;
                b[pAllapot.x][pAllapot.y] = billentes[3][a[pUj.x][pUj.y]];
                b[pUj.x][pUj.y] = 0;
                break;
            case Jobbra:
                pUj.y++;
                b[pAllapot.x][pAllapot.y] = billentes[2][a[pUj.x][pUj.y]];
                b[pUj.x][pUj.y] = 0;
                break;
            default:
                break;
        }
        //System.out.println("\n\n" + this.irany + "\n" + uj);

        return uj;
    }

    @Override
    public String toString() {
        return "Operátor : " + irany;
    }
}