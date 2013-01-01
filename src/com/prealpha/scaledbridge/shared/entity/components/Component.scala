package com.prealpha.scaledbridge.shared.entity.components

import com.prealpha.scaledbridge.shared.entity.Entity

import scala.collection.mutable.MutableList


class ComponentTracker[A] extends Iterable[A]{
    private[this]
    val componentList:MutableList[A] = MutableList()

    def add(component: A){
        componentList += component
    }

    def iterator: Iterator[A] = componentList.par.iterator
}

trait Component extends Entity
