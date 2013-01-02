package com.prealpha.scaledbridge.client.drawing

import com.prealpha.scalaslick.geom.Vector2f

class Camera(var position: Vector2f, val screenDims: Vector2f, var scale: Float) {
    def this(screenDims: Vector2f){
        this(new Vector2f(0,0), screenDims, 1.0f)
    }

    def center: Vector2f = {
        new Vector2f(
            position.x + screenDims.x /2,
            position.y + screenDims.y /2
        )
    }

    def globalAngleToScreen(globalAngle: Float) = (globalAngle + 90) % 360

    /**
     * Given an in-game position, compute the position on the screen
     * @param globalPosition The in-game position
     * @return The screen position
     */
    def globalToScreen(globalPosition: Vector2f) = {
        val toReturn = globalPosition.copy
        toReturn -= position
        toReturn *= scale
        toReturn += screenDims * 0.5f

        toReturn
    }

    /**
     * Given a point on the screen, calculate the in-game point that
     * it corresponds to.
     * @param screenPosition The screen position
     * @return The in-game position
     */
    def screenToGlobal(screenPosition: Vector2f) = {
        val toReturn = screenPosition.copy
        toReturn -= screenDims * 0.5f
        toReturn /= scale
        toReturn += position

        toReturn
    }

    /**
     * Returns true if the given position is on the screen
     * @param screenPosition The screen-local position
     * @return If the position is on the screen
     */
    def inBounds(screenPosition: Vector2f): Boolean = {
        val Vector2f(x,y) = screenPosition
        (
            (x > 0) && (y > 0) &&
            (x < screenDims.x) &&
            (y < screenDims.y)
        )
    }

    def inBounds(screenPos: Vector2f, radius: Float): Boolean = {
        import org.newdawn.slick.geom.{Circle, Rectangle}

        new Circle(screenPos.x, screenPos.y, radius).intersects(new Rectangle(0,0,screenPos.x, screenPos.y))
    }
}
