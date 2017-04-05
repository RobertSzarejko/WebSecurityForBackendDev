package pl.itdonat.demo.wsfbd.card;

/**
 * Created by r.szarejko on 2017-03-13.
 */
public enum CreditCardKind {

    VISA("V"),
    MASTERCARD("M"),
    AMERICAN_EXPRESS("AE");


    private String db;
    CreditCardKind(String db) {
        this.db = db;
    }

    public String getDb() {
        return db;
    }
}
