package com.madirwx.counterviewmodel

data class CounterModel (
    var count: Int
)

class CounterRepository {
    private var _count = CounterModel(0)

    fun getCounter(): CounterModel {
        return _count
    }


    fun incrementCounter(){
        _count.count++
    }

    fun decrementCounter(){
        _count.count--
    }
}