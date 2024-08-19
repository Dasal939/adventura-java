package cz.vse.adventura.logika;

/**
 * Třída Quest reprezentuje quest v rámci hry.
 *
 * Quest má vždy definovanou potřebnou věc a potřebnou postavu, která tuto věc požaduje.
 * Třída obsahuje 2 konstruktory, první z nich je používán u většiny questů a má ještě parametr "odmena", který udává co za splnění questu dostaneme.
 * Druhý konstruktor obsahuje parametr "isFinal", který rozhoduje, zda se jedná o poslední quest.
 *
 * @author Daniel Salat
 * @version květen/červen 2024
 */
public class Quest {

    private Vec potrebnaVec;

    private Postava potrebnaPostava;

    private Vec odmena;

    private boolean isFinal = false;

    /**
     * Konstruktor pro vytvoření instance questu s definovanými požadavky na splnění.
     *
     * @param potrebnaVec Věc potřebná k splnění questu.
     * @param potrebnaPostava Postava potřebná k splnění questu.
     * @param odmena Odměna za splnění questu.
     */
    public Quest(Vec potrebnaVec, Postava potrebnaPostava, Vec odmena) {
        this.potrebnaVec = potrebnaVec;
        this.potrebnaPostava = potrebnaPostava;
        this.odmena = odmena;
    }

    /**
     * Konstruktor pro vytvoření instance questu s definovanými požadavky na splnění a označením jako finální.
     *
     * @param potrebnaVec Věc potřebná k splnění questu.
     * @param potrebnaPostava Postava potřebná k splnění questu.
     * @param isFinal Ukazatel, zda je quest finální.
     */
    public Quest(Vec potrebnaVec, Postava potrebnaPostava, boolean isFinal) {
        this.potrebnaVec = potrebnaVec;
        this.potrebnaPostava = potrebnaPostava;
        this.isFinal = isFinal;
    }

    /**
     * Metoda pro získání potřebné věci k splnění questu.
     *
     * @return Potřebná věc k splnění questu.
     */
    public Vec getPotrebnaVec() {
        return potrebnaVec;
    }

    /**
     * Metoda pro získání odměny za splnění questu.
     *
     * @return Odměna za splnění questu.
     */
    public Vec getOdmena() {
        return odmena;
    }

    /**
     * Metoda pro zjištění, zda je quest finální.
     *
     * @return True, pokud je quest finální, jinak false.
     */
    public boolean isFinal() {return isFinal;}
}
