public class NumberofOneBits {
        // you need to treat n as an unsigned value
        /**Write a function that takes an unsigned integer and returns the number of '1' bits it has
         *  (also known as the Hamming weight). */
        public int hammingWeight(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;
        }

        public int hammingWeight2(int n) {
            int sum = 0;
            while (n != 0) {
                sum++;
                n &= (n - 1);
            }
            return sum;
        }

    }
