import java.util.ArrayList;
import java.util.Iterator;

public class frontier {

    ArrayList<node> f;

    public frontier() { f = new ArrayList<node>(); }

    public Iterator<node> Iterator(){ return f.iterator(); }

    public boolean remove( node e ){ return f.remove( e ); }

    public boolean remove( node[] e ){

        boolean res = true;

        for( node n : e ){
            res = res && this.remove( n );
        }
        return res;
    }

    public boolean add(node e){
        //TODO do better
        boolean r1 = f.add(e);
        f.sort( new NodeComparator() );

        return r1;
    }

    public node get_cheap(){

        if ( f.isEmpty() ) return null;

        return f.get(0);
    }
    public boolean add( ArrayList<node> e ){

        boolean res = true;
        for( node n: e ){
            res = res && f.add( n );
        }
        return res;
    }
}
