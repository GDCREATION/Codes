public class NumberCompliment {
    /**The complement of an integer is the integer you get when you flip all the 0's to 1's and all the 1's to 0's in its binary representation.

For example, The integer 5 is "101" in binary and its complement is "010" which is the integer 2.
Given an integer num, return its complement. */
    public int findComplement(int num) {
        int todo = num, bit = 1;
        while (todo != 0) {
        // flip current bit
        num = num ^ bit;
        // prepare for the next run
        bit = bit << 1;
        todo = todo >> 1;
        }
        return num;
    }
}
