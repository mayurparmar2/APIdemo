package com.demo.example


fun main() {

    for (i in -3..3){
        if (i==1){
            println(-1)
            continue
        }
        println("$i")
    }
}