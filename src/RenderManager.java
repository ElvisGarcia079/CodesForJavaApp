




import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import java.util.ArrayList;


public class RenderManager {
    private Canvas screen;
    
    private ArrayList<Renderable> renderables = new ArrayList();
    
    public RenderManager(Canvas screen){
        this.screen = screen;
    }

    RenderManager() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void add(Renderable r){
        renderables.add(r);
    }
    
    public void update(){
       if(screen.isDisplayable()){
           
       
       BufferStrategy b = screen.getBufferStrategy();
       
        if(b == null){
            screen.createBufferStrategy(2);
            return;
        }
       
    
        Graphics g = b.getDrawGraphics();
        g.clearRect(0, 0, screen.getWidth(), screen.getHeight());
        
        
        for (Renderable r : renderables ){
            r.draw(g);
        }
        b.show();
        g.dispose();
    }
    
  }
    
    
    
}
