/*
Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may exist one celebrity. The definition of a celebrity is that all the other n - 1 people know him/her but he/she does not know any of them.

Now you want to find out who the celebrity is or verify that there is not one. The only thing you are allowed to do is to ask questions like: "Hi, A. Do you know B?" to get information of whether A knows B. You need to find out the celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).

You are given a helper function bool knows(a, b) which tells you whether A knows B. Implement a function int findCelebrity(n), your function should minimize the number of calls to knows.
*/
/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        if ( n <= 0 ) return -1;
        if ( n == 1 ) return 0;
        // step 1 : find candidate
        int candidate = 0;
        for ( int i = 1 ; i < n ; i++ ){
            if(knows(candidate,i)) candidate = i;
        }
        // step 2 : check the candidate 
        // check 1 : knows(candidate,i) ; i for all others before candidate -> false
        // check 2 : knows(i,candidate) , i for all ohters -> true (double check)
        for(int i = 0 ; i < n ; i++){
            if(i<candidate && knows(candidate,i)) return -1;
            if(!knows(i,candidate)) return -1;
        }
        return candidate;
        
    }
}