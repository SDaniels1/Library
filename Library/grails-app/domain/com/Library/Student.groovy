package com.Library

class Student {
String name
String email
String studentid
String course

String toString(){
"$name,$email,$studentid"

}

    static constraints = {
name()
email()
studentid()
course()
    }
}
