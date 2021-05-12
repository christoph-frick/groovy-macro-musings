package net.ofnir.groovymacromusings

import spock.lang.Specification

class ThreadingMacroSpec extends Specification {

    def "happy path"() {
        given:
        def add1 = { it+1 }
        def mul = { a, b -> a*b }

        when:
        def r = threadFirst(
            42,
            add1,
            mul(5)
        )

        then:
        r == (42+1)*5
    }

    def "single argument"() {
        when:
        def r = threadFirst(
            42
        )

        then:
        r == 42
    }

    def "empty call"() {
        given:
        def add1 = { it+1 }
        def mul = { a, b -> a*b }

        when:
        def r = threadFirst(
            42,
            add1(),
            mul(5)
        )

        then:
        r == (42+1)*5
    }

    def "method call first argument"() {
        given:
        def add1 = { it+1 }
        def mul = { a, b -> a*b }

        when:
        def r = threadFirst(
            add1(42),
            mul(5)
        )

        then:
        r == (42+1)*5
    }

}
