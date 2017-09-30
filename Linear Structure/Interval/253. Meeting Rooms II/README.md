### Pointers
*  When we need extra room, end event occurs and there is a starting event happened before that ( generate overlapping)
* Create a variable "current end time" to point to the current end event, and move the start event pointer

```
|_____|
      |______|
|________|
        |_______|

```
Then, the start time array and end time array after sorting appear link follows

```
||    ||
     |   |   |  | 
```
Initially, endsItr points to the first end event, and we move i which is the start event pointer. As we examine the start events, we’ll find the first two start events happen before the end event that endsItr points to, so we need two rooms (we magically created two rooms), as shown by the variable rooms. Then, as i points to the third start event, we’ll find that this event happens after the end event pointed by endsItr, then we increment endsItr so that it points to the next end event. What happens here can be thought of as one of the two previous meetings ended, and we moved the newly started meeting into that vacant room, thus we don’t need to increment rooms at this time and move both of the pointers forward.
Next, because endsItr moves to the next end event, we’ll find that the start event pointed by i happens before the end event pointed by endsItr. Thus, now we have 4 meetings started but only one ended, so we need one more room. And it goes on as this.



```
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for(int i=0; i<intervals.length;i++){
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int count = 0;
        int curEnd = 0; 
        for( int i = 0 ; i < start.length ; i++){
            if( start[i] < end[curEnd]) count++;
            else curEnd++;
        }
        return count;
    }
}
```

### Heap
* minHeap for saving the end times

```
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if ( intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, (a,b)->(a.start - b.start));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (Interval i : intervals) {
            if ( !minHeap.isEmpty() && minHeap.peek() <= i.start){
                minHeap.poll();    
            }
            minHeap.offer(i.end);
        }
        return minHeap.size();
    }
}
```


### TreeMap
* Sort using TreeMap by start and end 

```
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        Map<Integer,Integer> map = new TreeMap<Integer,Integer>();
        for(Interval i : intervals){
            map.put(i.start,map.getOrDefault(i.start,0)+1);
            map.put(i.end,map.getOrDefault(i.end,0)-1);
        }
        int count = 0 , curRoom = 0;
        for( int i : map.keySet()){
            count = Math.max(count,curRoom += map.get(i));
        }
        return count;
    }
}
```