package com.prealpha.scaledbridge

import org.newdawn.slick.geom.{Vector2f => VectorOld}
import com.prealpha.scalaslick.geom.{Vector2f => VectorNew}

package object util {
    implicit def vectorOld2New(old: VectorOld): VectorNew = new VectorNew(old.x,old.y)
}
