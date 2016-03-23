
package Stacks;

public class Stack {
    int top = -1;
    int[] numbers;
    
    
    
    public void push(int number){
        top++;
        numbers[top] = number;
        
    }
    
    public void pop(){
        top--;
        
    }
    
    public boolean isEmpty(){
        if(top == -1){
            return true;
        }
        
        return false;
        
    }
    
    public void peek(){
        System.out.println(numbers[top]);
    }
    
    public Stack(){
        
    }
}
