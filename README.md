[![Build Status](https://travis-ci.com/mtumilowicz/groovy-recursion-MissingMethodException.svg?branch=master)](https://travis-ci.com/mtumilowicz/groovy-recursion-MissingMethodException)

# groovy-recursion-MissingMethodException
How to avoid MissingMethodException during invoking recursive closures.

# project description
In `RecursiveFactorialTest` we provide examples:
1. recursive factorial results in `MissingMethodException`
    ```
    given:
    def factorial = {
        it == 1 ? 1G : it * factorial(it - 1)
    }
    
    when:
    factorial(5)
    
    then:
    thrown(MissingMethodException)
    ```
1. recursive factorial predefined
    ```
    given:
    def factorial
    factorial = {
        it == 1 ? 1G : it * factorial(it - 1)
    }
    
    expect:
    factorial(5) == 120
    ```
1. recursive factorial with inner call
    ```
    given:
    def factorial = {
        it == 1 ? 1G : it * call(it - 1)
    }
    
    expect:
    factorial(5) == 120
    ```

# summary
To avoid `MissingMethodException` you should either:
* not define and implement closure in one place
* use `call` instead of closure in recursive call