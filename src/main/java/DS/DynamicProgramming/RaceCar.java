package DS.DynamicProgramming;

import Exception.InvalidInputArgument;
import javafx.util.Pair;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/*
Race Car

Your car starts at position 0 and speed +1 on an infinite number line. Your car can go into negative positions.
Your car drives automatically according to a sequence of instructions 'A' (accelerate) and 'R' (reverse):

When you get an instruction 'A', your car does the following:
position += speed
speed *= 2
When you get an instruction 'R', your car does the following:
If your speed is positive then speed = -1
otherwise speed = 1
Your position stays the same.
For example, after commands "AAR", your car goes to positions 0 --> 1 --> 3 --> 3,
and your speed goes to 1 --> 2 --> 4 --> -1.

Given a target position target, return the length of the shortest sequence of instructions to get there.


Example 1:
Input: target = 3
Output: 2
Explanation:
The shortest instruction sequence is "AA".
Your position goes from 0 --> 1 --> 3.

Example 2:
Input: target = 6
Output: 5
Explanation:
The shortest instruction sequence is "AAARA".
Your position goes from 0 --> 1 --> 3 --> 7 --> 7 --> 6.

Constraints:

1 <= target <= 104

*/


public class RaceCar {
    public Integer target = null;

    public void acceptInput(Integer target) throws Exception {
        if(null == target){
            throw new InvalidInputArgument(target);
        }
        this.target = target;
    }

    public int racecar() {

        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        HashSet<Pair<Integer, Integer>> visited = new HashSet<>();

        //pos, speed
        queue.add(new Pair(0,1));
        visited.add(new Pair(0,1));
        int moves = 0;
        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i=0;i<size;i++){
                Pair<Integer, Integer> node = queue.poll();
                int position = node.getKey();
                int speed = node.getValue();

                //once we hit target, return instructions count
                if(position == target){
                    return moves;
                }

                else{
                    if(!visited.contains(new Pair(position + speed, speed *2))){
                        visited.add(new Pair(position + speed, speed * 2));
                        queue.offer(new Pair(position + speed, speed*2));
                    }

                    boolean first = ((position + speed) > target ) && speed > 0;
                    boolean second = ((position + speed) < target)  && speed < 0;
                    if(first || second){
                        speed = speed > 0 ? -1 :  1;
                        if(!visited.contains(new Pair(position, speed))){
                            visited.add(new Pair(position, speed));
                            queue.offer(new Pair(position, speed));

                        }

                    }
                }
            }
            moves++;

        }

        return -1;
    }
}
