package com.Library

class Library {
String location
String openingHours

static hasMany=[librarians:Librarian, students:Student, books:Book]

String toString(){

"$location,$openingHours"}

static constraints = {
location()
openingHours()
    }
}
