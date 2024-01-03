public class Galo {

    private byte[][] board;

    public Galo(){
        board = new byte[3][3];
    }

    public void print(){

        char c;
        for( int i = 0; i < 3 ;++i ){
            for( int j = 0; j < 3 ;++j ){

                System.out.print("| " +
                        switch ( board[i][j] ){
                            case 2  -> 'X';
                            case 1  -> 'O';
                            default -> ' ';
                        }+" ");
            }
            System.out.println("|");
        }
    }
}
