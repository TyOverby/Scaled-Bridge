package com.prealpha.scaledbridge.shared.entity.components

import com.prealpha.scalaslick.geom.Vector2f

trait FixedPositionComponent extends Component{
    // In meters
    def position: Vector2f

    // In degrees
    def rotation: Float
}
