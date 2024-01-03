import java.util.ArrayList;
import java.util.Iterator;

import static java.lang.Math.abs;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class game {

    char[][] board;
    int col,lin;

    public game(int l,int c){

        if(     l < 0
            ||  l > 2
            ||  c < 0
            ||  c > 2){
            return;
        }

        int n = 0;

        col = c;
        lin = l;
        board = new char[3][3];
        board[l][c] = ' ';

        for( int i = 0; i < 3 ;i++  ){
            for( int j = 0; j < 3 ;j++  ){
                if( board[i][j] != ' ' ){
                    board[i][j] = (char) (++n + (int)'0' );
                }
            }
        }
    }

    public void print(){

        for( int i = 0; i < 3 ;i++  ){
            for( int j = 0; j < 3 ;j++  ){
                System.out.print( board[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    private static void cpy_board( char[][] src, char[][] dest ){

        for( int l = 0;l < 3;++l ){
            for( int c = 0; c < 3 ;++c ){
                dest[l][c] = src[l][c];
            }
        }
    }

    public game move( String action ){

        int lm = 0,
            cm = 0;

        switch (action){

            case "up":
                lm = -1;
                break;
            case "down":
                lm = 1;
                break;
            case "right":
                cm = 1;
                break;
            case "left":
                cm = -1;
                break;
            default:
                return null;
        }

        if(    col + cm < 0
            || lin + lm < 0
            || col + cm > 2
            || lin + lm > 2 ){
            return null;
        }

        game g = new game( lin + lm,col + cm );
        cpy_board( board, g.board );

        g.board[lin][col] = board[lin + lm][col + cm];
        g.board[lin + lm][col + cm] = ' ';

        return g;
    }

    public int calc_dist( game g ){

        int dist = 0;
        int[] cord;

        for( int l = 0;l < 3;++l ){
            for( int c = 0; c < 3 ;++c ){

                cord = g.get_pos( board[l][c] );
                dist += abs( cord[0] - l ) + abs( cord[1] - c );

            }
        }
        return dist;
    }

    private int[] get_pos( char elem ){
        int[] pos = new int[2];

        for( int l = 0;l < 3;++l ){
            for( int c = 0; c < 3 ;++c ){
                if( board[l][c] == elem ){
                    pos[0] = l;
                    pos[1] = c;
                    return pos;
                }
            }
        }
        return null;
    }

    public ArrayList<String> Solve2( game goal ){

        frontier f = new frontier();
        node n = new node( this );
        node Dbg_n = n;
        ArrayList<String> path;
        int dist;

        //Primeiro passo ADHOC
        n.get_children();
        for( node c : n.child ){
            c.cost = c.state.calc_dist( goal );
            if( c.cost == 0 ){
                path = new ArrayList<String>(1);
                path.add( c.move );
                return path;
            }
        }
        f.add( n.child );

        while( true ){

            //desenvolever o caminho mais barato
            f.remove( n );
            n = f.get_cheap();
            n.get_children();

            for( node c:n.child ){

                dist = c.state.calc_dist( goal );
                c.cost = dist + c.depth;

                if( dist == 0 ){
                    path = c.getpath();
                    //c.print_path();
                    return path;
                }
                f.add( c );
            }
        }
    }

    public ArrayList<String> Solve1( game goal ){

        node nit, n = new node( this );
        //ArrayList<node> front = new ArrayList<node>();
        Iterator<node> it;
        int l_cost,dist;

        while ( true ){

            if( !n.move.equals( "up"    ) ){  n.child( "up"    ); }
            if( !n.move.equals( "right" ) ){  n.child( "right" ); }
            if( !n.move.equals( "down"  ) ){  n.child( "down"  ); }
            if( !n.move.equals( "left"  ) ){  n.child( "left"  ); }

            it = n.child.iterator();
            l_cost = Integer.MAX_VALUE;

            while( it.hasNext() ){

                nit = it.next();
                if( nit.state == null ){ continue; }

                dist = calc_dist(goal);
                nit.cost = dist + nit.depth;

                if( dist == 0 ){ return nit.getpath(); }

                if( nit.cost < l_cost ){
                    l_cost = nit.cost;
                    n = nit;
                }
            }
            n.state.print();
            System.out.println();
        }
    }

}