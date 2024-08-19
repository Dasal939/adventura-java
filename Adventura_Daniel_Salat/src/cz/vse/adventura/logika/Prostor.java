package cz.vse.adventura.logika;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Trida Prostor - popisuje jednotlivé prostory (místnosti) hry
 *
 * Tato třída je součástí jednoduché textové hry.
 *
 * "Prostor" reprezentuje jedno místo (místnost, prostor, ..) ve scénáři hry.
 * Prostor může mít sousední prostory připojené přes východy. Pro každý východ
 * si prostor ukládá odkaz na sousedící prostor.
 *
 * @author Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova
 * @version pro školní rok 2016/2017
 */
public class Prostor {
    private String nazev;
    private String popis;

    private Quest quest;
    private Set<Prostor> vychody;   // obsahuje sousední místnosti

    private Set<Vec> veci = new HashSet<>();

    private Set<Postava> postavy = new HashSet<>();


    /**
     * Vytvoření prostoru se zadaným popisem, např. "kuchyň", "hala", "trávník
     * před domem"
     *
     * @param nazev nazev prostoru, jednoznačný identifikátor, jedno slovo nebo
     * víceslovný název bez mezer.
     * @param popis Popis prostoru.
     */
    public Prostor(String nazev, String popis) {
        this.nazev = nazev;
        this.popis = popis;
        vychody = new HashSet<>();
    }

    /**
     * Definuje východ z prostoru (sousední/vedlejsi prostor). Vzhledem k tomu,
     * že je použit Set pro uložení východů, může být sousední prostor uveden
     * pouze jednou (tj. nelze mít dvoje dveře do stejné sousední místnosti).
     * Druhé zadání stejného prostoru tiše přepíše předchozí zadání (neobjeví se
     * žádné chybové hlášení). Lze zadat též cestu ze do sebe sama.
     *
     * @param vedlejsi prostor, který sousedi s aktualnim prostorem.
     *
     */
    public void setVychod(Prostor vedlejsi) {
        vychody.add(vedlejsi);
    }

    /**
     * Metoda pro zjištění, zda prostor obsahuje určitou věc.
     *
     * @param nazevVeci Název věci, kterou hledáme v prostoru.
     * @return True, pokud prostor obsahuje hledanou věc, jinak false.
     */
    public boolean obsahujeVec(String nazevVeci) {
        Vec vec = this.getVec(nazevVeci);

        return vec != null;
    }

    /**
     * Metoda pro přidání věci do prostoru.
     *
     * @param vec Věc, kterou chceme přidat do prostoru.
     * @return True, pokud se věc podaří přidat do prostoru, jinak false.
     */
    public boolean pridejVec(Vec vec) {
        if (obsahujeVec(vec.getNazev())) {
            return false;
        }

        return veci.add(vec);
    }

    /**
     * Metoda pro získání věci z prostoru.
     *
     * @param nazevVeci Název věci, kterou chceme získat z prostoru.
     * @return Věc, pokud je v prostoru přítomná, jinak null.
     */
    public Vec getVec(String nazevVeci) {
        for (Vec vec: veci) {
            if (vec.getNazev().equals(nazevVeci)) {
                return  vec;
            }
        }

        return null;
    }

    /**
     * Metoda pro odebrání věci z prostoru.
     *
     * @param nazevVeci Název věci, kterou chceme odebrat z prostoru.
     * @return True, pokud se věc podaří odebrat z prostoru, jinak false.
     */
    public boolean odeberVec(String nazevVeci) {
        Vec vec = this.getVec(nazevVeci);

        if (vec == null) {
            return false;
        }

        return veci.remove(vec);
    }

    /**
     * Metoda pro přidání postavy do prostoru.
     *
     * @param postava Postava, kterou chceme přidat do prostoru.
     * @return True, pokud se postavu podaří přidat do prostoru, jinak false.
     */
    public boolean pridejPostavu(Postava postava) {
        return postavy.add(postava);
    }

    /**
     * Metoda pro získání postavy z prostoru.
     *
     * @param jmenoPostavy Jméno postavy, kterou chceme získat z prostoru.
     * @return Postava, pokud je v prostoru přítomná, jinak null.
     */
    public Postava getPostava(String jmenoPostavy) {
        for (Postava postava: postavy) {
            if (postava.getJmeno().equals(jmenoPostavy)) {
                return  postava;
            }
        }
        return null;
    }

    /**
     * Metoda pro nastavení questu v nějakém určitém prostoru.
     *
     * @param quest Quest, který chceme nastavit pro daný prostor.
     */
    public void setQuest(Quest quest) {
        this.quest = quest;
    }

    /**
     * Metoda pro získání questu, který je přiřazen k prostoru.
     *
     * @return Quest, který je přiřazen k prostoru.
     */
    public Quest getQuest() {
        return quest;
    }


    /**
     * Metoda equals pro porovnání dvou prostorů. Překrývá se metoda equals ze
     * třídy Object. Dva prostory jsou shodné, pokud mají stejný název. Tato
     * metoda je důležitá z hlediska správného fungování seznamu východů (Set).
     *
     * Bližší popis metody equals je u třídy Object.
     *
     * @param o object, který se má porovnávat s aktuálním
     * @return hodnotu true, pokud má zadaný prostor stejný název, jinak false
     */  
      @Override
    public boolean equals(Object o) {
        // porovnáváme zda se nejedná o dva odkazy na stejnou instanci
        if (this == o) {
            return true;
        }
        // porovnáváme jakého typu je parametr 
        if (!(o instanceof Prostor)) {
            return false;    // pokud parametr není typu Prostor, vrátíme false
        }
        // přetypujeme parametr na typ Prostor 
        Prostor druhy = (Prostor) o;

        //metoda equals třídy java.util.Objects porovná hodnoty obou názvů. 
        //Vrátí true pro stejné názvy a i v případě, že jsou oba názvy null,
        //jinak vrátí false.

       return (java.util.Objects.equals(this.nazev, druhy.nazev));       
    }

    /**
     * metoda hashCode vraci ciselny identifikator instance, ktery se pouziva
     * pro optimalizaci ukladani v dynamickych datovych strukturach. Pri
     * prekryti metody equals je potreba prekryt i metodu hashCode. Podrobny
     * popis pravidel pro vytvareni metody hashCode je u metody hashCode ve
     * tride Object
     */
    @Override
    public int hashCode() {
        int vysledek = 3;
        int hashNazvu = java.util.Objects.hashCode(this.nazev);
        vysledek = 37 * vysledek + hashNazvu;
        return vysledek;
    }
      

    /**
     * Vrací název prostoru (byl zadán při vytváření prostoru jako parametr
     * konstruktoru)
     *
     * @return název prostoru
     */
    public String getNazev() {
        return nazev;       
    }

    /**
     * Vrací "dlouhý" popis prostoru, který může vypadat následovně: Jsi v
     * mistnosti/prostoru vstupni hala budovy VSE na Jiznim meste. vychody:
     * chodba bufet ucebna
     *
     * @return Dlouhý popis prostoru
     */
    public String dlouhyPopis() {
        return "Jsi v mistnosti/prostoru " + popis + ".\n"
                + popisVychodu() + "\n" + popisVeci() + "\n" + popisPostav();
    }

    /**
     * Vrací textový řetězec, který popisuje sousední východy, například:
     * "vychody: hala ".
     *
     * @return Popis východů - názvů sousedních prostorů
     */
    public String popisVychodu() {
        String vracenyText = "východy:";

        for (Prostor sousedni : vychody) {
            vracenyText += " " + sousedni.getNazev();
        }

        return vracenyText;
    }

    /**
     * Metoda pro získání textového výpisu věcí v aktuálním prostoru.
     *
     * @return Textový řetězec obsahující popis věcí v prostoru.
     */
    public String popisVeci() {
        String vracenyText = "věci:";

        for (Vec vec : veci) {
            vracenyText += " " + vec.getNazev();
        }

        return vracenyText;
    }

    /**
     * Metoda pro získání textového výpisu postav v aktuálním prostoru.
     *
     * @return Textový řetězec obsahující popis postav v prostoru.
     */
    public String popisPostav() {
        String vracenyText = "postavy:";

        for (Postava postava : postavy) {
            vracenyText += " " + postava.getJmeno();
        }

        return vracenyText;
    }

    /**
     * Vrací prostor, který sousedí s aktuálním prostorem a jehož název je zadán
     * jako parametr. Pokud prostor s udaným jménem nesousedí s aktuálním
     * prostorem, vrací se hodnota null.
     *
     * @param nazevSouseda Jméno sousedního prostoru (východu)
     * @return Prostor, který se nachází za příslušným východem, nebo hodnota
     * null, pokud prostor zadaného jména není sousedem.
     */
    public Prostor vratSousedniProstor(String nazevSouseda) {
        List<Prostor>hledaneProstory = 
            vychody.stream()
                   .filter(sousedni -> sousedni.getNazev().equals(nazevSouseda))
                   .collect(Collectors.toList());
        if(hledaneProstory.isEmpty()){
            return null;
        }
        else {
            return hledaneProstory.get(0);
        }
    }

    /**
     * Vrací kolekci obsahující prostory, se kterými tento prostor sousedí.
     * Takto získaný seznam sousedních prostor nelze upravovat (přidávat,
     * odebírat východy) protože z hlediska správného návrhu je to plně
     * záležitostí třídy Prostor.
     *
     * @return Nemodifikovatelná kolekce prostorů (východů), se kterými tento
     * prostor sousedí.
     */
    public Collection<Prostor> getVychody() {
        return Collections.unmodifiableCollection(vychody);
    }

}
