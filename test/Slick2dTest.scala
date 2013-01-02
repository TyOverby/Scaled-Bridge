import com.prealpha.scalaslick.geom.Vector2f
import com.prealpha.scalaslick.util.BasicGameApp
import com.prealpha.scaledbridge.client.drawing
import com.prealpha.scaledbridge.client.drawing.Camera
import com.prealpha.scaledbridge.shared.entity.components.{ImageRenderingComponent, PhysicsComponent}
import com.prealpha.scaledbridge.shared.entity.Entity
import org.newdawn.slick.{Graphics, GameContainer}
import com.prealpha.scalaslick.geom.vector2fConversions._

object Slick2dTest extends BasicGameApp("this is a test"){
    var plane: Entity with ImageRenderingComponent with PhysicsComponent = null
    implicit var camera: Camera = null// extends Camera(new Vector2f(100, 100))

    def init(container: GameContainer) {
        this.plane = new Entity with PhysicsComponent with ImageRenderingComponent{
            var rotation = 0f

            var position = Vector2f(0,0)

            var velocity = Vector2f(0,0)

            var acceleration = Vector2f(0,0)
            var rotationalVelocity: Float = 0
            var rotationalAcceleration: Float = 0
            var mass: Float = 0


            /** The radius of this image, used for clipping */
            def boundingRadius: Float = 50

            /** The url for the file that is going to be drawn */
            def imageUrl: String = "resources/plane.png"
        }
        this.camera = new drawing.Camera(new Vector2f(container.getWidth, container.getHeight))
    }

    def update(container: GameContainer, deltaM: Int) {
        this.plane.velocity = (0f,10f)
        this.plane.update(deltaM)
    }

    def render(container: GameContainer, g: Graphics) {
        this.plane.render(g,camera)
    }
}
