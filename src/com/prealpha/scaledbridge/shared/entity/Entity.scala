package com.prealpha.scaledbridge.shared.entity

import components.{RenderComponent, PhysicsComponent, Component}
import com.prealpha.scalaslick.geom.Vector2f

class Entity(val name: String) extends Serializable {
    def this() = this(toString)
}


