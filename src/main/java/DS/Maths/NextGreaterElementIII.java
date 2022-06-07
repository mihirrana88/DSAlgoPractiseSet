package DS.Maths;

import Exception.InvalidInputArgument;

public class NextGreaterElementIII {
    public Integer n = null;

    public void acceptInput(Integer n) throws Exception {
        if(null == n){
            throw new InvalidInputArgument(n);
        }
        this.n = n;
    }

    public int nextGreaterElement() {
        int[] powers = new int[10];
        powers[0] = 1;
        for (int i = 1; i < powers.length; i++) {
            powers[i] = 10 * powers[i - 1];
        }
        int left, right = 0;
        long diff = 0;
        outer:
        for (left = 1; n > powers[left]; left++) {
            int current = (n / powers[left]) % 10;
            if (current < (n / powers[left - 1]) % 10) {
                for (right = 0; right < left; right++) {
                    int previous = (n / powers[right]) % 10;
                    if (previous > current) {
                        diff = previous - current;
                        break outer;
                    }
                }
            }
        }

        if (diff == 0) {
            return -1;
        }

        long result = diff * (powers[left] - powers[right]) + n;
        for (int i = 0; i < left; i++) {
            for (int j = i + 1; j < left; j++) {
                long current = (result / powers[i]) % 10;
                long next = (result / powers[j]) % 10;
                if (current < next) {
                    result += (next - current) * (powers[i] - powers[j]);
                }
            }
        }

        return result > Integer.MAX_VALUE ? -1 : (int) result;
    }
}
