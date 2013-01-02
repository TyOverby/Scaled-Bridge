package com.prealpha.scaledbridge.shared.entity

import components.{RenderComponent, PhysicsComponent, Component}
import com.prealpha.scalaslick.geom.Vector2f

case class Entity(val name: String) extends Serializable with SelflyLinkedList {
    def this() = this(toString)
}