package com.Library

class Librarian {
String name
String email
String userName
String password
String telephone

String toString(){
"$name,$userName,$email"

}

    static constraints = {
name()
email()
userName()
password()
telephone maxsize: 11
    }
}
