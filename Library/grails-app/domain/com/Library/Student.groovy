package com.Library

class Student {
String name
String email
String studentid
Course course

String toString(){
"$name,$studentid,$course"

}

    static constraints = {
name()
email()
studentid()
course()
    }
}
