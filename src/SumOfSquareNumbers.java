public class SumOfSquareNumbers {

    /**Given a non-negative integer c,
     * decide whether there're two integers a and b such that a2 + b2 = c. */
        public boolean judgeSquareSum(int c) {
            for (long a = 0; a * a <= c; a++) {
                int b = c - (int)(a * a);
                if (binary_search(0, b, b))
                    return true;
            }
            return false;
        }
        public boolean binary_search(long s, long e, int n) {
            if (s > e)
                return false;
            long mid = s + (e - s) / 2;
            if (mid * mid == n)
                return true;
            if (mid * mid > n)
                return binary_search(s, mid - 1, n);
            return binary_search(mid + 1, e, n);
        }
    }
