import spock.lang.Specification


/**
 * Created by mtumilowicz on 2018-11-27.
 */
class RecursiveFactorialTest extends Specification {

    def "recursive factorial results in MissingMethodException"() {
        given:
        def factorial = {
            it == 1 ? 1G : it * factorial(it - 1)
        }
        
        when:
        factorial(5)
        
        then:
        thrown(MissingMethodException)
    }

    def "recursive factorial predefined"() {
        given:
        def factorial
        factorial = {
            it == 1 ? 1G : it * factorial(it - 1)
        }

        expect:
        factorial(5) == 120
    }

    def "recursive factorial with inner call"() {
        given:
        def factorial = {
            it == 1 ? 1G : it * call(it - 1)
        }

        expect:
        factorial(5) == 120
    }
}