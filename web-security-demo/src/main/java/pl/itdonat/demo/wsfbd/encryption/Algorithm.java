package pl.itdonat.demo.wsfbd.encryption;

import lombok.Getter;

/**
 * Created by r.szarejko on 2017-03-22.
 */
public enum Algorithm {

    MD5("MD5", 1),
    SHA1("SHA-1", 2),
    SHA256("SHA-256", 3),
    SHA512("SHA-512", 4),
    BCRYPT("BCrypt", 5),
    SCRYPT("SCrypt", 6),
    PBKDF("Pbkdf", 7);

    @Getter
    private final String description;
    @Getter
    private final Integer position;

    Algorithm(String description, int position) {
        this.description = description;
        this.position = position;
    }
}
