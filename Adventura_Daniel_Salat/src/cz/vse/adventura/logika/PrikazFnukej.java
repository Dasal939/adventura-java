package cz.vse.adventura.logika;

import java.util.Random;

/**
 * Třída PrikazFnukej implementuje příkaz "fnukej", díky kterému může hráč brečet a naříkat :D.
 * Příkaz generuje jeden ze čtyř možných náhodných výkřiků.
 *
 * Autor: Daniel Salat
 * Verze: květen/červen 2024
 */
class PrikazFnukej implements IPrikaz {
    private static final String NAZEV = "fnukej";

    /**
     * Konstruktor bez parametrů, slouží pro vložení do seznamu příkazů.
     */
    public PrikazFnukej() {
    }

    /**
     * Metoda provede příkaz "fnukej", který náhodně generuje jeden ze čtyř možných výkřiků.
     *
     * @param parametry (nejsou používány).
     * @return Vrací náhodný výkřik.
     */
    @Override
    public String provedPrikaz(String... parametry) {
        Random random = new Random();
        int nahodneCislo = random.nextInt(4); //Generuje od 0 do 3

        switch (nahodneCislo) {
            case 0:
                return "ááá, mamiii, kde jsi? :(";
            case 1:
                return "maminkoooo, chci jít domůůů :(";
            case 2:
                return "béééé, já chci mámuuuu :(";
            case 3:
                return "bůůůůůů :(";
        }
        return null;
    }

    /**
     * Metoda vrací název příkazu.
     *
     * @return Vrací název příkazu.
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }
}