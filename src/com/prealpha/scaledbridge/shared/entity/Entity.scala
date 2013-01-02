package com.prealpha.scaledbridge.shared.entity

import collection.mutable

object EntityPool extends Iterable[Entity]{
    import scala.collection.mutable.MutableList

    private[this]
    val pool     = new MutableList[Entity]
    val toRemove = new MutableList[Entity]
    val updated  = new MutableList[Entity]

    def add(entity: Entity){
        entity +=: pool
    }

    def toRemove(entity: Entity){

    }

    def iterator = this.pool.iterator
}

case class Entity(val name: String) {
    def this() = this(getClass.getSimpleName)

    def update(deltaM: Int){
        // Don't do anything
    }

    def flagChanged() {

    }
}