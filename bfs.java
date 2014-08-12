import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


// java generics cannot be directly created to arrays. This is a flaw in java generics. On hack is  done here. Is an uncecked type casting.
// Another two are create a class which extends the generic type and create an array of it.
// one more is Linkedlist<Linkedlist<Integer>>
public class Bfs {

	private LinkedList<Integer>[] larray;
	private boolean[] visited;
	private int[] previous;
	private int[] hops;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	@SuppressWarnings("unchecked")
	Bfs(int n)
	{
		larray = (LinkedList<Integer>[])new LinkedList[n+1];
		visited = new boolean[n+1];
		previous = new int[n+1];
		hops = new int[n+1];
		for(int i=0;i<n;i++)
		{
			larray[i+1]=new LinkedList<Integer>();
		}
		
	}
	public  void inputGraph() throws IOException
	{
		
		for(int i=1;i<larray.length;i++)
		{
			System.out.println("enter the vertices connected to "+(i));
			String c[]= br.readLine().split(" ");
			for(int j=0;j<c.length;j++)
			{
				larray[i].add(Integer.parseInt(c[j]));
			}
		}
		
	}
	public void performTraversal() throws NumberFormatException, IOException
	{
		Queue<Integer> que = new LinkedList<>();
		System.out.println("enter the root node ");

		int root_trav = Integer.parseInt(br.readLine());
		for(int i=0;i<larray.length;i++)
		{
			hops[i]=1000;
			previous[i]=-1;
		}
		visited[root_trav]=true;
		hops[root_trav]=0;
		que.add(root_trav);
		while(!que.isEmpty())
		{
			int x = que.remove();
			System.out.println(x);
			for(int a:larray[x])
			{
				if(visited[a]==false)
				{
					visited[a]=true;
					hops[a]=hops[x]+1;
					previous[a]=x;
					que.add(a);
				}
			}
		}
		for(int i=0;i<hops.length;i++)
			System.out.print(hops[i]+" ");
		
		
	}
	
	public static void main(String... args) throws IOException
	{
		System.out.println("enter number of vertices ");
		
		int n  = Integer.parseInt(br.readLine());
		
		Bfs bfs = new Bfs(n);
		bfs.inputGraph();
		
		bfs.performTraversal();
		
	}
}
