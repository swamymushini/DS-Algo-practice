package com.stacks;

import java.util.Stack;

public class MInStack {
	    
	    Stack<Integer> stack = new Stack<>();
	 Stack<Integer> mins = new Stack<>();

	 int min = Integer.MAX_VALUE;
	 
	    public void push(int x) {
	       
	    stack.push(x);

	        if(min>=x){              
	            min = x;
	            mins.push(min);
	        }            
	    }

	    public void pop() {

	        if(stack.isEmpty())
	            return;
	           
	        int x  = stack.pop();  

	           if(x==mins.peek()){
	               mins.pop();	
	               if(!mins.isEmpty())
	                    min = mins.peek();
	               else
	                    min = Integer.MAX_VALUE;                       
	           }     

	    }

	    public int top() {
	        if(stack.isEmpty()){
	            return -1;
	        }  
	        else{          
	          return stack.peek();  
	        }
	    }

	    public int getMin() {
	       if(stack.isEmpty()){
	           return -1;
	       }
	       else{
	           return mins.peek();
	       }
	    }
	

}
