//import com.prealpha.scalaslick.geom.Vector2f;
//import com.prealpha.scaledbridge.client.drawing.Camera;
//import com.prealpha.scaledbridge.client.drawing.ImageManager;
//import org.newdawn.slick.Graphics;
//import org.newdawn.slick.Image;
//
//public class JavaPastebin {
//    public void render(Camera camera, Graphics gr){
//        Vector2f drawPos = camera.globalToScreen(parent.getPosition());
//        Image image = ImageManager.getOrPutImage(id, url);
//
//        float scale = camera.getZoom()*this.parent.getScale();
//        image.setCenterOfRotation((image.getWidth()/2)*scale, (image.getHeight()/2)*scale);
//        image.setRotation(parent.getRotation()+90);
//
//        image.draw(drawPos.getX()-(image.getWidth()/2)*scale, drawPos.getY()-(image.getWidth()/2*scale),scale);
//        gr.drawRect(drawPos.getX()-1, drawPos.getY()-1, 3, 3);
//
//        // Don't bother with any of this
//        Vector2f inFront = new Vector2f(parent.getRotation());
//        inFront.timesEquals(50);
//        inFront.plusEquals(parent.getPosition());
//        inFront = camera.globalToScreen(inFront);
//        gr.drawRect(inFront.getX()-1, inFront.getY()-1, 3, 3);
//    }
//}
