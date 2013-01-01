import collection.mutable.ListBuffer
import com.prealpha.scalaslick.geom.Vector2f
import com.prealpha.scalaslick.util.BasicGameApp
import com.prealpha.scaledbridge.shared.entity.components.PhysicsComponent
import com.prealpha.scaledbridge.shared.entity.components.physicsTracker
import com.prealpha.scaledbridge.shared.entity.Entity
import java.util
import org.newdawn.slick.{Graphics, GameContainer}

object Slick2dTest extends BasicGameApp("this is a test"){
    def init(container: GameContainer) {
        val test = new Entity with PhysicsComponent{
            // In degrees
            var rotation = 0f

            var position = null

            def velocity = null

            def acceleration = null
        }

        println(physicsTracker.size)
    }

    def update(container: GameContainer, delta: Int) {}

    def render(container: GameContainer, g: Graphics) {
        g.drawString("this is a test", 100, 100)
    }
}
