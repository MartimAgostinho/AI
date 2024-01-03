import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {


        game goal   = new game( 0,0 );
        game b      = new game( 1, 1);
        game tmp    = new game( 1, 1);

        int n = 1;
        for( int l = 2;l >= 0;--l ){
            for( int c = 2;c >= 0;--c ) {
                if( b.board[l][c] == ' ' ){ continue; }
                b.board[l][c] = (char) (n++ + (int) '0');
            }
        }
        ArrayList<String> path =  b.Solve2( goal );

        System.out.println(path.size());
        System.out.println( "\ngoal" );
        goal.print();
        System.out.println( "\nobj" );
        b.print();
        //b = b.move("right");

        for( String str : path ){
            b = b.move(str);
            b.print();
            System.out.println(str);
        }

    }

}