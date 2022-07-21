package com.stacks;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class RedundantBraces {

	public static void main(String[] args) {
		System.out.println(new RedundantBraces().braces("(a+(a+b))"));
	}

	public int braces(String A) {

        Stack<Character> st = new Stack<>();

        boolean flag = true;

        Set<Character> set = new HashSet<>();

        set.add('*');
        set.add('+');
        set.add('-');
        set.add('/');

        for(int i =0;i<A.length();i++){

            char ch = A.charAt(i);

            if(ch=='(')
                st.push(ch);
            else if(ch==')'){
                
                if(st.isEmpty())
                    return 0;
                
                if(set.contains(st.peek())){
                    st.pop();

                if(st.isEmpty())
                    return 0;

                    st.pop();
                }else
                    return 1;

            }else if(set.contains(ch)&&(st.isEmpty()||!set.contains(st.peek())))
                    st.push(ch);
            
        }

        return 0;
    }
}
