public class ValidSudoku {
        public boolean isValidSudoku(char[][] board) {
            for(int i=0;i<9;i++){
                int jk[]=new int[10];
                int jk1[]=new int[10];
                int jk2[]=new int[10];
                for(int j=0;j<9;j++){
                    if(board[i][j] != '.'){
                        jk[board[i][j]-'0']++;
                        if(jk[board[i][j]-'0'] == 2)
                            return false;
                    }
                    if(board[3*(i/3)+j/3][3*(i%3)+j%3] != '.'){
                        jk1[board[3*(i/3)+j/3][3*(i%3)+j%3]-'0']++;
                        if(jk1[board[3*(i/3)+j/3][3*(i%3)+j%3]-'0'] == 2)
                            return false;
                        }
                    if(board[j][i] !='.'){
                        jk2[board[j][i]-'0']++;
                        if(jk2[board[j][i]-'0'] == 2)
                            return false;
                        }
                    }
                }
            return true;
        }
    }
