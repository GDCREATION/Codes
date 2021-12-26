import java.io.*;


public class ShiftAndOrder {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i = 0; t_i < T; t_i++)
        {
            int N = Integer.parseInt(br.readLine().trim());
            int K = Integer.parseInt(br.readLine().trim());
            String[] arr_H = br.readLine().split(" ");
            int[] H = new int[N];
            for(int i_H = 0; i_H < arr_H.length; i_H++)
            {
            	H[i_H] = Integer.parseInt(arr_H[i_H]);
            }

            String out_ = all_happy(N, K, H);
            System.out.println(out_);
            
         }

         wr.close();
         br.close();
    }
    static String all_happy(int N, int K, int[] H){
       // Write your code here
        for(int i = 1 ; i<N; i++){
            if(H[i]<H[i-1]){
                for(int m = i;m>=0;m=m-K) {
                	if(m!=0 && H[m]<H[m-1]){
                	for(int j=0;j<K;j++){
	                    if(m-j-1>=0 && H[m-j]<H[m-1-j]){
	                        int t = H[m-j];
	                        H[m-j] = H[m-1-j];
	                        H[m-1-j]  = t;
	                    }
	                    else
	                        return "NO";
                	}
                	}
                }
            }
        }
        return "YES";
    
    }
}