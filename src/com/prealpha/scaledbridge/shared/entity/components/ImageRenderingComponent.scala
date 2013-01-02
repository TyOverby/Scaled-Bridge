package com.prealpha.scaledbridge.shared.entity.components

import com.prealpha.scaledbridge.client.drawing.{Camera, ImageManager}
import org.newdawn.slick.{Image, Graphics}
import com.prealpha.scalaslick.geom.Vector2f

trait ImageRenderingComponent extends RenderComponent {
    /** The url for the file that is going to be drawn */
    def imageUrl: String

    private[this] /** The hash of the image url used for retrieval */
    val urlHash = imageUrl.hashCode
    ImageManager.place(urlHash,imageUrl)

    def render(implicit graphics: Graphics, camera: Camera){
        val drawPos: Vector2f = camera.globalToScreen(position)
        val image: Image = ImageManager.get(urlHash)


        val scale: Float = camera.scale * this.scale
        image.setCenterOfRotation((image.getWidth / 2) * scale, (image.getHeight / 2) * scale)
        image.setRotation(this.rotation + 90)

        image.draw(drawPos.x - (image.getWidth / 2) * scale,
                   drawPos.y - (image.getWidth / 2 * scale), scale)


        graphics.drawRect(drawPos.x - 1, drawPos.y - 1, 3, 3)
    }
}
