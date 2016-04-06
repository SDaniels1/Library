package com.Library

class Course {
String title
String code
String tutor
String department
String description

String toString(){
"$title,$code,department"

}

    static constraints = {
title()
code()
tutor()
department()
description maxSize: 200
    }
}
