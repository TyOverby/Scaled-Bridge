package com.prealpha.scaledbridge.shared

import com.prealpha.scaledbridge.shared.entity.Entity

trait Game{
    def objects: Iterable[Entity]

    def update(deltaM: Int){

    }
}
