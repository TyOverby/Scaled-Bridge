package com.prealpha.scaledbridge.shared.entity.components

import com.prealpha.scalaslick.geom.Vector2f

object renderTracker extends ComponentTracker[RenderComponent]

trait RenderComponent extends Component{
    def position: Vector2f

    // In degrees
    def rotation: Float
}
