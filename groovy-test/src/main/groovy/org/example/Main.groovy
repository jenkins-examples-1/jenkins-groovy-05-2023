package org.example

class RomanNumber {
    static def numbers = ['I', 'II', 'III', 'IV', 'V']

    def number

    RomanNumber(number) {
        this.number = number
    }

    RomanNumber plus(RomanNumber other) {
        Integer res = numbers.indexOf(number.toUpperCase()) + numbers.indexOf(other.number.toUpperCase()) + 1
        if (res >= numbers.size()) {
            throw new UnsupportedOperationException("Sorry, number is too big")
        }
        //number = numbers[res]
        new RomanNumber(numbers[res])
    }


    @Override
    public String toString() {
        return "RomanNumber{" +
                "number=" + number +
                '}';
    }
}




static void main(String[] args) {
    println "Hello world!"
    def one = new RomanNumber('i')
    def two = new RomanNumber('II')
    def three = one + two
    println three
}
