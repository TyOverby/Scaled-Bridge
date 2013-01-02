import com.prealpha.scalaslick.geom.Vector2f
import com.prealpha.scalaslick.util.BasicGameApp
import com.prealpha.scaledbridge.shared.entity.components.PhysicsComponent
import com.prealpha.scaledbridge.shared.entity.components.physicsTracker
import com.prealpha.scaledbridge.shared.entity.Entity
import org.newdawn.slick.{Graphics, GameContainer}

object Slick2dTest extends BasicGameApp("this is a test"){
    def init(container: GameContainer) {
        val test = new Entity with PhysicsComponent{
            var rotation = 0f

            var position = Vector2f(0,0)

            var velocity = Vector2f(0,0)

            var acceleration = Vector2f(0,0)
        }

        println(physicsTracker.size)
    }

    def update(container: GameContainer, delta: Int) {}

    def render(container: GameContainer, g: Graphics) {
        g.drawString("this is a test", 100, 100)
    }
}
