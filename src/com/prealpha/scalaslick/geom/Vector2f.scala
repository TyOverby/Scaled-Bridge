package com.prealpha.scalaslick.geom

import org.newdawn.slick.geom.{Vector2f=> VectorOld}

case object NaV extends Vector2f(Float.NaN, Float.NaN)
case class Vector2f(nx: Float, ny: Float) extends VectorOld(nx, ny){
    def += (other: Vector2f) = this.add(other)
    def -= (other: Vector2f) = this.sub(other)
    def *= (scalar: Float)   = this.scale(scalar)
    def unary_- = new Vector2f(-x, -y)
}

