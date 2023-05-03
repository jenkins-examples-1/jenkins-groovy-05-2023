package org.example

import java.time.LocalDate

def placements = [
        new Placement(booked: true, wPrice: 100, creationDate: LocalDate.of(2022, 10, 20), category: 'sport'),
        new Placement(booked: false, wPrice: 123, creationDate: LocalDate.of(2021, 10, 20), category: 'it'),
        new Placement(booked: true, wPrice: 12, creationDate: LocalDate.of(2019, 10, 20), category: 'it')
]

def placements2 = placements.findAll{it.booked}
    .sort {o1, o2 -> o2.wPrice <=> o1.wPrice ?: o1.creationDate <=> o2.creationDate}
println(placements2)

class Payee {}

class Agency {
    def payees
}

class Period {
    def payee
}

Period getPrevInYear() {
    new Period()
}

Agency getAgency() {
    new Agency()
}

def payee
def agency

(payee?:getPrevInYear()?.payee)?:getAgency()?.payees

def lst = ['foo', 'bar', 'baz']
def mapLst = lst.collectEntries {[it, it.toUpperCase()]}
println mapLst

def map = [foo:'FOO', bar:'BAR', baz:'BAZ']
def map2 = map.collectEntries {[it.key*2, it.value*2]}
println(map2)


