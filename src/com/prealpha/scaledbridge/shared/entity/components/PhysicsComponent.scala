package com.prealpha.scaledbridge.shared.entity.components

import com.prealpha.scalaslick.geom.Vector2f

object physicsTracker extends ComponentTracker[PhysicsComponent]

trait PhysicsComponent extends Component{
    physicsTracker.add(this)

    // In degrees
    var rotation: Float

    var position: Vector2f
    var velocity: Vector2f
    var acceleration: Vector2f
}
