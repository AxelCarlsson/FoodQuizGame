package com.example.foodquizgame

class User {

    var id: Int = 0
    var name: String = ""
    var age: Int = 0
    var score: Int = 0

    constructor(name: String, age:Int, score:Int) {
        this.name = name
        this.age = age
        this.score = score
    }

    constructor()
}