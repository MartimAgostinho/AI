import distanceMatrix.DistanceMatrix;

import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {
        Main m = new Main();

        m.mq();
    }
        public void mq() {
        String mtr = "/home/porcaontas/IdeaProjects/TP2/src/Distancias.txt";
        DistanceMatrix dist = new DistanceMatrix(mtr);
        ArrayList<String> c = dist.getCities();

        this.seq = c;
        swap( 20,8,100 );
    }

    public ArrayList<String> seq;
    public void swap( int i,int j,int c ) {

        i = i == seq.size() - 1 ? 0 : 1 + i;

        for( String s: seq ){
            System.out.print(" "+s);
        }
        int lpn = dist( i,j,seq );
        System.out.println("\n"+lpn);
        for(;lpn > 0;--lpn){
           System.out.println(i+" "+j);

            swap_seq(i,j);
            for( String s: seq ){
                System.out.print(" "+s);
            }
            System.out.println();
            if( i == seq.size() - 1 ){
                i = 0;
            }else{
                ++i;
            }
            if( j == 0 ){
                j = seq.size() - 1;
            }else{
                --j;
            }
        }
        for( String s: seq ){
            System.out.print(" "+s);
        }

    }

    private static int dist( int i, int j, ArrayList<String> seq ){

        if( i<j ){return i-j;}

        return (seq.size() - i) + j;

    }
    private void swap_seq( int i, int j ) {

        String s = seq.get(i);
        seq.set(
                i ,
                seq.get(j));

        seq.set( j, s );
    }
}