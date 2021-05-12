package net.ofnir.groovymacromusings

import spock.lang.Specification

class StringMacroSpec extends Specification {
    def "upper"() {
        when:
        def result = upper("Hello")

        then:
        result == "HELLO"
    }
}
