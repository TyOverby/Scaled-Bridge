package com.prealpha.scaledbridge.shared.entity.components

import com.prealpha.scalaslick.geom.Vector2f

object physicsTracker extends ComponentTracker[PhysicsComponent]

trait PhysicsComponent extends Component{
    physicsTracker.add(this)

    var rotation: Float                // In degrees
    var rotationalVelocity: Float      // In degrees/s
    var rotationalAcceleration: Float  // In degrees/s/s

    var position: Vector2f             // In meters
    var velocity: Vector2f             // In meters/s
    var acceleration: Vector2f         // In meters/s/s


    var mass: Float  // In kg

    abstract override
    def update(deltaM: Int){
        // Because deltaM is in milliseconds, we have to convert it to
        // seconds before we can do any real calculations with it.
        val inSeconds = deltaM.toFloat / 1000

        velocity += acceleration * inSeconds
        position += velocity * inSeconds

        rotationalVelocity += rotationalAcceleration *inSeconds
        rotation += rotationalVelocity * inSeconds

//        super.update
    }
}
