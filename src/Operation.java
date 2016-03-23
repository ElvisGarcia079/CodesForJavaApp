


public class Operation implements Runnable {
    
    private Thread opThread;
    private boolean running = false;
    
    @Override
    public void run(){
        long startTime = System.currentTimeMillis();
        
        long timeAtLastUpdate = 0;
        
        int ups = 60;
        
        double timeBetweenUpdates = 1000/ups;
        
        int updates = 0;
        long timeAtLastUpdateCheck = 0;
        
        while(running){
            //App Logic
            long currentTime = System.currentTimeMillis();
            if((currentTime - timeAtLastUpdate) > timeBetweenUpdates){
                // Update Logic
                timeAtLastUpdate = currentTime;
                updates++;
            }
            
            if(currentTime - timeAtLastUpdateCheck > 1000){
                System.out.println("UPS:" + updates);
                updates = 0;
                timeAtLastUpdateCheck = currentTime;
            }
            
        }
        //App Finished
        System.out.println("App ran for: " + (System.currentTimeMillis() - startTime) / 1000 + " seconds."); 
    }
    
    public void start(){
        if(!running){
            running = true;
            opThread = new Thread(this);
            opThread.start();
        }
    }
    
    public void stop(){
        running = false;
    }
}
