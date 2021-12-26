public class ReverseBits {
    // you need treat n as an unsigned value
    /**Reverse bits of a given 32 bits unsigned integer. */
    public int reverseBits(int n) {
        int ret = 0,power = 31;
        while (power>=0) {
            ret += (n & 1) << power;
            n = n >> 1;
            power -= 1;
        }
        return ret;
    }
}
