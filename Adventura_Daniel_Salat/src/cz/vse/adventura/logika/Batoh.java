package cz.vse.adventura.logika;

import java.util.ArrayList;
import java.util.List;

/**
 * Třída Batoh reprezentuje herní úložiště, do kterého si hráč může ukládat věci co najde.
 * Batoh má omezenou kapacitu, kterou nelze překročit.
 * Poskytuje metody pro přidávání, odebírání a kontrolu věcí v batohu.
 * Obsahuje také metodu pro výpis aktuálních věcí v batohu.
 *
 * Autor: Daniel Salat
 * Verze: květen/červen 2024
 */
public class Batoh
{
    private static final int MAX_KAPACITA = 3;

    private List<Vec> veci ;

    /**
     * Konstruktor, inicializace.
     */
    public Batoh() {
        veci = new ArrayList<>();
    }

    /**
     * Metoda přidává věc do batohu, pokud je volné místo a věc je přenositelná.
     *
     * @param pridavanaVec Věc, kterou chceme přidat do batohu.
     * @return Vrací přidanou věc.
     * @throws IllegalStateException Pokud je věc nepřenositelná nebo není volné místo.
     */
    public Vec pridejVec(Vec pridavanaVec) {
        if (pridavanaVec == null) {
            throw new IllegalStateException("Tuhle věc tady nevidím.");
        }
        if (!jeVolno()) {
            throw new IllegalStateException("Máš plný batoh.");
        }
        if (pridavanaVec.isPrenositelna()) {
            veci.add(pridavanaVec);
            return pridavanaVec;
        }
        else {
            throw new IllegalStateException("Tato věc je nepřenositelná.");
        }
    }

    /**
     * Metoda odebírá věc z batohu podle jejího názvu.
     *
     * @param odebiranaVec Název věci, kterou chceme odebrat z batohu.
     * @return Vrací odebranou věc.
     * @throws IllegalStateException Pokud věc v batohu není.
     */
    public Vec odeberVec(String odebiranaVec) {
        Vec hledanaVec = null;
        for (Vec vec : veci) {
            if (vec.getNazev().equals(odebiranaVec)) { // Pokud se odebiranaVec shoduje se zrovna nalezenou věcí v batohu
                hledanaVec = vec; // Přiřadí tu věc do proměnné hledanaVec
                break;
            }
        }
        if (hledanaVec == null) {
            throw new IllegalStateException("Tuhle věc v batohu nemám.");
        }
        veci.remove(hledanaVec);
        return hledanaVec;
    }

    /**
     * Metoda kontroluje, jestli batoh obsahuje věc s daným názvem.
     *
     * @param hledanaVec Název hledané věci.
     * @return Vrací true, pokud batoh obsahuje věc s daným názvem, jinak false.
     */
    public boolean obsahujeVec(String hledanaVec) {
        for (Vec vec: veci) {
            if (vec.getNazev().equals(hledanaVec)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Metoda zjišťuje, zda je v batohu ještě volné místo.
     *
     * @return Vrací true, pokud je v batohu volné místo, jinak false.
     */
    public boolean jeVolno() {
        if (veci.size() < MAX_KAPACITA) {
            return true;
        }
        return false;
    }

    /**
     * Metoda vrací seznam věcí v batohu jako řetězec.
     *
     * @return Vrací řetězec obsahující informace o zaplnění batohu a seznam věcí co tam jsou.
     */
    public String vypisVeci() {
        if (veci.isEmpty()) {
            return "Batoh je prázdný.";
        } else {
            String veciString = "";
            String finalString = "Batoh máš z " + veci.size() + "/" + MAX_KAPACITA + " zaplněný.\nV batohu jsou následující věci:";
            for (Vec vec : veci) {
                veciString = veciString.concat("\n" + vec.getNazev()); // Přidá název věci do řetězce veciString, každý název na nový řádek (pomohlo ChatGPT)
            }
            return finalString + veciString;
        }
    }
}
