package DS.DynamicProgramming;

import Exception.InvalidInputArgument;

/*
Poor Pigs

There are buckets buckets of liquid, where exactly one of the buckets is poisonous.
To figure out which one is poisonous, you feed some number of (poor) pigs the liquid to see whether
they will die or not. Unfortunately, you only have minutesToTest minutes to determine which bucket is poisonous.

You can feed the pigs according to these steps:

Choose some live pigs to feed.

For each pig, choose which buckets to feed it. The pig will consume all the chosen buckets simultaneously
and will take no time.

Wait for minutesToDie minutes. You may not feed any other pigs during this time.

After minutesToDie minutes have passed, any pigs that have been fed the poisonous bucket will die,
and all others will survive.

Repeat this process until you run out of time.

Given buckets, minutesToDie, and minutesToTest, return the minimum number of pigs needed to figure out
which bucket is poisonous within the allotted time.

Example 1:
Input: buckets = 1000, minutesToDie = 15, minutesToTest = 60
Output: 5

Example 2:
Input: buckets = 4, minutesToDie = 15, minutesToTest = 15
Output: 2

Example 3:
Input: buckets = 4, minutesToDie = 15, minutesToTest = 30
Output: 2

Constraints:

1 <= buckets <= 1000
1 <= minutesToDie <= minutesToTest <= 100

*/

public class PoorPigs {
    public Integer buckets = null;
    public Integer minutesToDie = null;
    public Integer minutesToTest = null;

    public void acceptBuckets(Integer buckets) throws Exception {
        if(null == buckets){
            throw new InvalidInputArgument(buckets);
        }
        this.buckets = buckets;
    }

    public void acceptMinutesToDie(Integer minutesToDie) throws Exception {
        if(null == minutesToDie){
            throw new InvalidInputArgument(minutesToDie);
        }
        this.minutesToDie = minutesToDie;
    }

    public void acceptMinutesToTest(Integer minutesToTest) throws Exception {
        if(null == minutesToTest){
            throw new InvalidInputArgument(minutesToTest);
        }
        this.minutesToTest = minutesToTest;
    }

    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {

        int testPossibleWithOnePig =  minutesToTest/minutesToDie + 1;
        int pigCount=0;

        while (Math.pow(testPossibleWithOnePig, pigCount) < buckets){
            pigCount++;
        }

        return pigCount;
    }

}