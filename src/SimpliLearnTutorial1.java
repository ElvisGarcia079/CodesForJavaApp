
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;



class SimpliLearnTutorial1  {

   public static void main(String[] args){
        
       Application app;
       app = new Application("My first App", 800, 600) {
           @Override
           public void addRenderables(){
               getRenderManager().add(new Renderable() {
                   
                   private int x = 100;
                   private int y = 100;
                   @Override
                   public void draw(Graphics g) {
                      g.setColor(Color.blue);
                      g.fillOval(x, y, 200, 200);
                      
                      if(getInputManager().getKeyboard().isKeyPressed(KeyEvent.VK_LEFT)){
                          x -= 10;
                          y -= 10;
                      }
                      else if(getInputManager().getKeyboard().isKeyPressed(KeyEvent.VK_RIGHT)){
                          x += 10;
                          y -= 10;
                      }
                   }
               });
               
               getRenderManager().add(new Renderable() {

                   @Override
                   public void draw(Graphics g) {
                       g.setColor(Color.blue);
                       g.fillRect(getInputManager().getMouse().getX(), getInputManager().getMouse().getY(), 50, 50);
                       
                   }
               });
               
               getRenderManager().add(new Renderable(){
                   
                   @Override
                   public void draw(Graphics g){
                       g.setColor(Color.orange);
                       g.fillRect(getInputManager().getMouse().getX(), getInputManager().getMouse().getY(), 100, 100);
                   }
               });
               
           
           }
           
           @Override
           public void update(){
               
           }
       };
       
       app.start();
   }
}

   

   


        
              
