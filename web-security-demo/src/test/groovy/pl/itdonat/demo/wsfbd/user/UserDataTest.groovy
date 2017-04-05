package pl.itdonat.demo.wsfbd.user

import spock.lang.Specification

/**
 * Created by Robert on 2017-03-11.
 */
class UserDataTest extends Specification {


    def "prepare correct full user name"(){

        given:
        def user = UserData.builder().firstName(FIRST_NAME).middleName(MIDDLE_NAME).surname(SURNAME).build()

        expect:
        user.getFullName() == FULL_NAME

        where:
        FIRST_NAME  | MIDDLE_NAME | SURNAME     | FULL_NAME
        "Adam"      | "Paweł"     | "Kowalski"  | "Adam Paweł Kowalski"
        "Adam"      | ""          | "Kowalski"  | "Adam Kowalski"
        "Adam"      | null        | "Kowalski"  | "Adam Kowalski"
        "Adam"      | "Paweł"     | "Kowalski"  | "Adam Paweł Kowalski"
        null        | "Paweł"     | "Kowalski"  | "Paweł Kowalski"
        "Adam"      | "Paweł"     | null        | "Adam Paweł"
        ""          | ""          | null        | ""

    }

}
