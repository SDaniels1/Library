package com.Library

class Library {
String book
String student
String location
String openingHours
String librarian

String toString(){

"$location,$openingHours"

}

static constraints = {
book()
student()
location()
openingHours()
librarian()
    }
}
