package net.ofnir.groovymacromusings

import spock.lang.Specification

class MacroSpec extends Specification {
    def "map"() {
        given:
        def a = 42

        when:
        def m = mapOf(a)

        then:
        m == [a: 42]
    }
}
