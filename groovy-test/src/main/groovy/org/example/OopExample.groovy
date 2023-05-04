package org.example

import groovy.transform.Canonical

@Canonical
class Hippo {
    private def weight
    private def age
    private def sex
    private def eyeColor

    Hippo(weight, age, sex, eyeColor) {
        this.weight = weight
        this.age = age
        this.sex = sex
        this.eyeColor = eyeColor
    }

    Hippo(Map<String, Object> args) {
        //Hippo(args.weight, args.age, args.sex, args.eyeCOlor)
    }

    def doSomething(int a, int b) {
        println("${a} ${b}")
    }

    def doSomething(Map<String, Integer> args) {
        doSomething(args.a, args.b)
    }
}

Hippo hippo = new Hippo(weight: 100.0, age: 10, sex: 'M', eyeColor: 'green')
hippo.doSomething(a: 10, b: 20)

trait EatableTrait {
    def weight

    def eat() {
        println('eat')
    }
}

def hippo2 = hippo.withTraits(EatableTrait)
hippo2.eat()

def key = {
    print "key closure"
}

def value = { val ->
    print "value closure ${val}"
}

def mapExample = [
        a: 10,
        key: value
]
println(mapExample.key())

class Employee {
    String name
    int hourlyRate
    int numHoursWorkedPerWeek
    int numOfSalesPerYear
}

// our system script
def totalSalary = {salaryCl, bonusesCl, employee ->
    salaryCl(employee) + bonusesCl(employee)
}

def salaryCl = {
    it.numHoursWorkedPerWeek * it.hourlyRate
}

def bonusesCl = {
    it.numOfSalesPerYear * 100
}

totalSalary = totalSalary.curry(salaryCl, bonusesCl)

// customer script
def employee = new Employee(name: 'Vasya', hourlyRate: 25, numHoursWorkedPerWeek: 40, numOfSalesPerYear: 100)
println totalSalary(employee)

class EmailDsl {
    private String messageText
    private String fromText
    private String toText

    static def make(Closure closure) {
        EmailDsl emailDsl = new EmailDsl()
        closure.delegate = emailDsl
        closure()
        emailDsl.sendEmail()
    }

    def sendEmail() {
        println("from=${fromText}, to=${toText}, body=${messageText}")
    }

    def body (String text) {
        messageText = text
    }

    def from (String text) {
        fromText = text
    }

    def to (String text) {
        toText = text
    }
}

EmailDsl.make {
    to "Vasya"
    from "Petya"
    body "How are you?"
}

def please(action)  {
    [
            the: { what ->
                [of: {n ->
                    action(what(n))
                }]
            }
    ]
}

def show = {
    println it
}

def square_root = {
    Math.sqrt(it)
}

please show the square_root of 100

