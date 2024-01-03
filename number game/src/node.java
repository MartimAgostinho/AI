import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class node {

    node father;
    ArrayList<node> child;
    game state;
    String move;
    int depth;
    int cost;

    public node(game g){

        father  = null;
        child   = new ArrayList<node>();
        state   = g;
        move    = "nothing";
        depth   = 0;
        cost    = 0;
    }

    public void get_children(){

        String f_move = move;

        /*if( this.father != null ){
            f_move = this.father.move;
        }*/
        //up
        if( this.state.lin != 0 && !Objects.equals(f_move, "down" ) ){
            this.child("up");
        }
        if( this.state.lin != 3 && !Objects.equals(f_move, "up") ){
            this.child("down");
        }
        if( this.state.col != 3 && !Objects.equals(f_move, "left") ){
            this.child("right");
        }
        if( this.state.col != 0 && !Objects.equals(f_move, "right") ){
            this.child("left");
        }
    }



    public void child( String move){

        node n = new node( state.move( move ) );
        if (n.state  == null) return;
        child.add( n );
        n.depth  = depth + 1;
        n.father = this;
        n.move = move;
    }

    public void print_path(){

        ArrayList<String> path = this.getpath();

        for( String str : path ){
            System.out.println( str );
        }
    }

    public ArrayList<String> getpath(){

        node n = this;
        ArrayList<String> path = new ArrayList<String>(depth + 1);

        while( n.depth > 0 ){
            path.addFirst( n.move);
            //System.out.println(n.depth+""+n.move);
            n = n.father;
        }

        return path;
    }

    public void print(){ print_fn(this); }
    private static void print_fn(node n){

        if( n == null ){ return; }

        for( int i = 0; i < n.depth;++i ){
            System.out.print( "│  " );
        }
        System.out.print( "├──" );
        System.out.println(n.depth+""+n.move.charAt(0));

        for( node c : n.child ){ print_fn( c ); }

    }

}

class NodeComparator implements Comparator<node> {

    public int compare( node n1,node n2 ){
        return Integer.compare(n1.cost, n2.cost);
    }
}