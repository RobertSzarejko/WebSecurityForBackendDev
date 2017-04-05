package pl.itdonat.demo.wsfbd.encryption;

/**
 * Created by r.szarejko on 2017-03-22.
 */
public enum Algorithm {

    MD5("MD5"),
    SHA1("SHA-1"),
    SHA256("SHA-256"),
    SHA512("SHA-512"),
    BCRYPT("BCrypt"),
    PBKDF("Pbkdf"),
    SCRYPT("SCrypt");

    private String description;

    Algorithm(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
