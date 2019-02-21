package com.huang

class Person {
    String name ='huang'
    int age =10
    def increaseAge(int years) {
        this.age=this.age + years
    }

    def hello(){
        println('hello')
    }
}
