package com.prealpha.scaledbridge.client.drawing

import collection.mutable.HashMap

import org.newdawn.slick.Image

object ImageManager {
    private[this]
    val map: HashMap[Int, Image]  = new HashMap

    def place(hash: Int, path: String){
        map += hash -> new Image(path)
    }

    def get(hash: Int) = {
        map(hash)
    }
}
