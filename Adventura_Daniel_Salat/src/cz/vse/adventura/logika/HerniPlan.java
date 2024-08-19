package cz.vse.adventura.logika;

/**
 *  Třída HerniPlan - třída představující mapu a stav adventury.
 * 
 *  Tato třída inicializuje prvky ze kterých se hra skládá:
 *  vytváří všechny prostory,
 *  propojuje je vzájemně pomocí východů 
 *  a pamatuje si aktuální prostor, ve kterém se hráč právě nachází.
 *
 *@author     Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova
 *@version    pro školní rok 2016/2017
 */
public class HerniPlan {
    
    private Prostor aktualniProstor;

    private Batoh batoh;

     /**
     *  Konstruktor který vytváří jednotlivé prostory a propojuje je pomocí východů.
     */
    public HerniPlan() {
        zalozProstoryHry();

    }
    /**
     *  Vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví dětský koutek.
     */
    private void zalozProstoryHry() {
        batoh = new Batoh();

        // vytvářejí se jednotlivé prostory
        Prostor detskyKoutek = new Prostor("detsky_koutek","dětský koutek s hračkami, všechno je ulepené...");
        Prostor hrackarstvi = new Prostor("hrackarstvi", "velké hračkářství se vším co by si dítě mohlo přát");
        Prostor rozcesti = new Prostor("rozcesti","rozcestí s posezením a stánkem co prodává bubble tea");
        Prostor obchodSBotami = new Prostor("obchod_s_botami","značkový obchod s krásnými teniskami");
        Prostor zachody = new Prostor("zachody","smradlavé záchody s rozblikaným světlem");
        Prostor chodba = new Prostor("chodba","chodba, která spojuje obchody s občerstvením");
        Prostor foodcourt = new Prostor("foodcourt","foodcourt s různými s restauracemi");
        Prostor kacelarManazera = new Prostor("kancelar_manazera","kancelář, kde si manažer obchodního centra zrovna dává šlofíka, bušení na dveře je k ničemu, potřebuješ klíč");
        Prostor obchodSOblecenim = new Prostor("obchod_s_oblecenim","velký obchod s oblečením a různými doplňky");

        // přiřazují se průchody mezi prostory (sousedící prostory)
        detskyKoutek.setVychod(hrackarstvi);
        hrackarstvi.setVychod(detskyKoutek);
        hrackarstvi.setVychod(rozcesti);
        rozcesti.setVychod(hrackarstvi);
        rozcesti.setVychod(obchodSBotami);
        rozcesti.setVychod(zachody);
        rozcesti.setVychod(chodba);
        obchodSBotami.setVychod(rozcesti);
        zachody.setVychod(rozcesti);
        chodba.setVychod(rozcesti);
        chodba.setVychod(foodcourt);
        chodba.setVychod(kacelarManazera);
        chodba.setVychod(obchodSOblecenim);
        obchodSOblecenim.setVychod(chodba);
        foodcourt.setVychod(chodba);
        kacelarManazera.setVychod(chodba);

        //vytváření jednotlivých věcí
        Vec skluzavka = new Vec("skluzavka", false);
        Vec auticko = new Vec("auticko", true);
        Vec lego = new Vec("lego", true);
        Vec prolezacka = new Vec("prolezacka", false);
        Vec bubbleTea = new Vec("bubble_tea", true);
        Vec lavicka = new Vec("lavicka", false);
        Vec odpadkovyKos = new Vec("odpadkovy_kos", false);
        Vec starePonozky = new Vec("stare_ponozky", true);
        Vec regalySBotama = new Vec("regaly_s_botama", false);
        Vec toaletniPapir = new Vec("toaletni_papir", true);
        Vec prazdnaPlechovka = new Vec("prazdna_plechovka", true);
        Vec kytka = new Vec("kytka", false);
        Vec kfcKyblik = new Vec("kfc_kyblik", true);
        Vec cinskeNudle = new Vec("cinske_nudle", true);
        Vec mikina = new Vec("mikina", true);
        Vec teplaky = new Vec("teplaky", true);
        Vec trenky = new Vec("trenky", true);
        Vec akvarium = new Vec("akvarium", false);

        //quest věci
        Vec happyMeal = new Vec("happy_meal", true);
        Vec zlatyPrsten = new Vec("zlaty_prsten", true);
        Vec klicOdKanclu = new Vec("klic_od_kanclu", true);
        Vec slenecniBryle = new Vec("slunecni_bryle", true);
        Vec uctenkaOdBot = new Vec("uctenka_od_bot", true);
        Vec noveTenisky = new Vec("nove_tenisky", true);

        //přidávání věcí do prostorů
        detskyKoutek.pridejVec(skluzavka);
        detskyKoutek.pridejVec(auticko);
        hrackarstvi.pridejVec(lego);
        hrackarstvi.pridejVec(prolezacka);
        rozcesti.pridejVec(bubbleTea);
        rozcesti.pridejVec(lavicka);
        rozcesti.pridejVec(odpadkovyKos);
        obchodSBotami.pridejVec(starePonozky);
        obchodSBotami.pridejVec(regalySBotama);
        zachody.pridejVec(toaletniPapir);
        zachody.pridejVec(prazdnaPlechovka);
        chodba.pridejVec(kytka);
        foodcourt.pridejVec(kfcKyblik);
        foodcourt.pridejVec(cinskeNudle);
        obchodSOblecenim.pridejVec(mikina);
        obchodSOblecenim.pridejVec(teplaky);
        obchodSOblecenim.pridejVec(trenky);
        obchodSOblecenim.pridejVec(slenecniBryle);
        kacelarManazera.pridejVec(akvarium);
        foodcourt.pridejVec(happyMeal);

        //vytváření jednotlivých postav
        Postava malySpratek = new Postava("maly_spratek", "Ahoj, mam stlašnej hlad, nedonesl bys mi plosím happy meal?", "Mňam, děkuju! Našel jsem tadyten plsten tak si ho vem.");
        Postava uklizecka = new Postava("uklizecka", "Cože? Klíče? Zapomeň, jedině že bys mi našel můj zlatý prsten.", "Tys ho fakt našel! Mockrát děkuju, tady máš ten klíč, ale nikomu to neříkej.");
        Postava prodavacBot = new Postava("prodavac_bot", "Boty že jsi tady nechal. Hm. To je hezký, ale bez účtenky ti nic nedám.", "Tak to je jiná, jedny zapomenuté boty tady máme. Vem si je tentokrát dávej pozor!");
        Postava pubertakUStanku = new Postava("pubertak_u_stanku", "Joo tebe si pamatuju, vyhodil jsi mi tady účtenku no. Ale nedam ti jí jen tak smrade, sežeň mi nový brejle a pak uvidíme.", "Hm, nejsou špatný no. Tady to máš a mazej.");
        Postava zamknuteDvere = new Postava("zamknute_dvere", "", "Strčil jsi klíč do zámku a... pasuje!");

        //přidávání postav do prostorů
        hrackarstvi.pridejPostavu(malySpratek);
        zachody.pridejPostavu(uklizecka);
        obchodSBotami.pridejPostavu(prodavacBot);
        rozcesti.pridejPostavu(pubertakUStanku);
        kacelarManazera.pridejPostavu(zamknuteDvere);

        //vytváření jednotlivých úkolů
        Quest hladovySpratek = new Quest(happyMeal, malySpratek, zlatyPrsten);
        Quest ztracenyPrsten = new Quest(zlatyPrsten, uklizecka, klicOdKanclu);
        Quest vyhozenaUctenka = new Quest(slenecniBryle, prodavacBot, uctenkaOdBot);
        Quest zapomenuteBoty = new Quest(uctenkaOdBot, prodavacBot, noveTenisky);
        Quest spiciManazer = new Quest(klicOdKanclu, zamknuteDvere, true);

        //přidávání úkolů do prostorů
        hrackarstvi.setQuest(hladovySpratek);
        zachody.setQuest(ztracenyPrsten);
        rozcesti.setQuest(vyhozenaUctenka);
        obchodSBotami.setQuest(zapomenuteBoty);
        kacelarManazera.setQuest(spiciManazer);

        aktualniProstor = detskyKoutek;  // hra začíná v dětském koutku
    }

    /**
     *  Metoda vrací odkaz na aktuální prostor, ve ktetém se hráč právě nachází.
     *
     *@return     aktuální prostor
     */
    public Prostor getAktualniProstor() {
        return aktualniProstor;
    }
    
    /**
     *  Metoda nastaví aktuální prostor, používá se nejčastěji při přechodu mezi prostory
     *
     *@param  prostor nový aktuální prostor
     */
    public void setAktualniProstor(Prostor prostor) {
       aktualniProstor = prostor;
    }

    /**
     * Metoda se pokusí sebrat věc z aktuálního prostoru a přidat jí do batohu.
     * Pokud se tam věc nenachází, vyhodí vyjímku.
     *
     * @param  nazev Název věci co chci sebrat.
     */
    public boolean seberVec(String nazev) throws IllegalStateException {
        Vec vec = aktualniProstor.getVec(nazev);
        batoh.pridejVec(vec);
        return this.aktualniProstor.odeberVec(nazev);
    }

    /**
     * Metoda se pokusí odebrat věc z batohu a položit ji do aktuálního prostoru.
     * Pokud se věc v batohu nenachází, vyhodí vyjímku.
     *
     * @param  nazev Název věci co chci položit.
     */
    public boolean polozVec(String nazev) throws IllegalStateException {
        Vec vec = batoh.odeberVec(nazev);
        return this.aktualniProstor.pridejVec(vec);
    }

    /**
     * Getter batohu.
     * @return  Vrací batoh.
     */
    public Batoh getBatoh() {
        return batoh;
    }

    /**
     * Setter batohu.
     * Slouží pro testování.
     * @param batoh nový batoh.
     */
    public void setBatoh(Batoh batoh) {
        this.batoh = batoh;
    }
}
