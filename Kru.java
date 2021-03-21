import java.util.*;
 
public class Kru{

int fathers[] = new int[1000];


int find(int x){
	if(fathers[x] == x){
		return x;
	}
	return find(fathers[x]);
}
 
void unite(int x, int y){
	int fx = find(x);
	int fy = find(y);
	fathers[fx] = fy;
}
 

public static void main(String args[]){
	Scanner stdin = new Scanner(System.in);
	Kru samp = new Kru();

	for(int i=0;i<100;i++){
		samp.fathers[i]=i;
	}

	int n,m;
	int a,b,w;
	ArrayList<Pair> edges = new ArrayList<Pair>();

	n = stdin.nextInt();
	m = stdin.nextInt();
	for(int i=0;i<m;i++){
		a = stdin.nextInt();
		b = stdin.nextInt();
		w = stdin.nextInt();
		edges.add(new Pair(w,a,b));
	}
	

	System.out.println();

	int mst_weight = 0, mst_edges = 0;
	int	mst_ni = 0;

	 Collections.sort(edges, new Comparator<Pair>() {
	        @Override 
	        public int compare(Pair p1, Pair p2) {
	            return p1.w - p2.w;
	        }
	 });

	while( ( mst_edges < n-1) || (mst_ni < m) ){

		a = edges.get(mst_ni).a;
		b = edges.get(mst_ni).b;
		w = edges.get(mst_ni).w;

		if( samp.find(a) != samp.find(b) ) {

			samp.unite(a,b);

			mst_weight += w;

			System.out.println(a + " " + b + " " + w);
			mst_edges++;
		}

		mst_ni++;
	}

	System.out.println( "\nWeight of the MST is " + mst_weight);

}
 
}