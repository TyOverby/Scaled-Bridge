package com.prealpha.scaledbridge.shared.entity.components

import com.prealpha.scalaslick.geom.Vector2f

object physicsTracker extends ComponentTracker[PhysicsComponent]

trait PhysicsComponent extends Component{
    physicsTracker.add(this)

    // In degrees
    def rotation: Float

    def position: Vector2f
    def velocity: Vector2f
    def acceleration: Vector2f
}
