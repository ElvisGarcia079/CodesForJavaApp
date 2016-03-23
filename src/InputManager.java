
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;




public class InputManager implements KeyListener, MouseListener, MouseMotionListener{

   
    public static class Keyboard{
       private int numKeys = 500;
       
       private boolean[] keyTyped = new boolean[numKeys]; 
       private boolean[] keyPressed = new boolean[numKeys]; 
       private boolean[] keyReleased = new boolean[numKeys]; 
       
       protected void toggleKeyTyped(int keyCode, boolean toggle){
           keyTyped[keyCode] = toggle;
       }
       
       protected void toggleKeyPressed(int keyCode, boolean toggle){
           keyPressed[keyCode] = toggle;
       }
       
       protected void toggleKeyReleased(int keyCode, boolean toggle){
           keyReleased[keyCode] = toggle;
       }
       
       public boolean keyTyped(int keyCode){
           return keyTyped[keyCode];
       }
       
       public boolean isKeyTyped(int keyCode){
           return keyTyped[keyCode];
       }
       
       public boolean isKeyPressed(int keyCode){
           return keyPressed[keyCode];
       }
       
       public boolean isKeyReleased(int keyCode){
           boolean r = keyReleased[keyCode];
           keyReleased[keyCode] = false;
           return r;
       }
       
       
    }
    
    
    public static class Mouse{
        
        private int numButtons = 10;
        
        private boolean[] buttonClicked = new boolean[numButtons];
        private boolean[] buttonPressed = new boolean[numButtons];
        private boolean[] buttonReleased = new boolean[numButtons];
        private int x,y;
        private boolean inScreen;
        
        protected void toggleButtonClicked(int buttonCode, boolean toggle){
            
            buttonClicked[buttonCode] = toggle;
        }
        
        protected void toggleButtonPressed(int buttonCode, boolean toggle){
            buttonPressed[buttonCode] = toggle;
        
        }
        
        protected void toggleButtonReleased(int buttonCode, boolean toggle){
            buttonReleased[buttonCode] = toggle;
        }
        
        protected void updateCoordinates(int x, int y){
            this.x = x;
            this.y = y;
        }
        
        protected void toggleInScreen(boolean toggle){
            inScreen = toggle;
        }
        public int getX(){
            return x;
        }
        
        public int getY(){
            return y;
        }
        
        public boolean isMouseClicked(int button){
            return buttonClicked[button];
        }
        
        public boolean isMousePressed(int button){
            return buttonPressed[button];
        }
        
        public boolean isMouseReleased(int button){
            boolean b = buttonReleased[button];
            buttonReleased[button] = false;
            return b;
        }
        
        public boolean isInScreen(){
            return inScreen;
        }
    }
    
    private Keyboard keyboard = new Keyboard();
    private Mouse mouse = new Mouse();
    
    public InputManager(Component c){
        c.addKeyListener(this);
        c.addMouseListener(this);
        c.addMouseMotionListener(this);
     }
    
    public Keyboard getKeyboard(){
        return keyboard;
    }
    
    
    public Mouse getMouse(){
        return mouse;
    }
    
    @Override
    public void keyTyped(KeyEvent ke) {
        keyboard.toggleKeyTyped(ke.getKeyCode(), true);
       
    }

    @Override
    public void keyPressed(KeyEvent ke) {
         keyboard.toggleKeyTyped(ke.getKeyCode(), false);
       
        
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        keyboard.toggleKeyReleased(ke.getKeyCode(), true);
        keyboard.toggleKeyPressed(ke.getKeyCode(),false);
        keyboard.toggleKeyTyped(ke.getKeyCode(), false);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        mouse.toggleButtonClicked(me.getButton(), true);
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
        mouse.toggleButtonPressed(me.getButton(), true);
    }

    @Override
    public void mouseReleased(MouseEvent me) {
       mouse.toggleButtonReleased(me.getButton(), true);
       mouse.toggleButtonClicked(me.getButton(), false);
       mouse.toggleButtonPressed(me.getButton(), false);
       
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        mouse.toggleInScreen(true);
    }

    @Override
    public void mouseExited(MouseEvent me) {
        mouse.toggleInScreen(false);
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        mouse.updateCoordinates(me.getX(), me.getY());
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        mouse.updateCoordinates(me.getX(), me.getY());
    }
    
   
}