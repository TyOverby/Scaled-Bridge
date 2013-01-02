package com.prealpha.scaledbridge.shared.entity.components

import com.prealpha.scalaslick.geom.Vector2f
import org.newdawn.slick.Graphics
import com.prealpha.scaledbridge.client.drawing.Camera

object renderTracker extends ComponentTracker[RenderComponent]

trait RenderComponent extends Component{
    /** In meters */
    def position: Vector2f

    /** In degrees */
    def rotation: Float

    /** 1.0 is a 1:1 scaling to the image */
    var scale: Float = 1.0f

    /** The radius of this image, used for clipping */
    def boundingRadius: Float

    /** The method to be called when this component is rendered */
    def render(implicit graphics: Graphics, camera: Camera)
}
