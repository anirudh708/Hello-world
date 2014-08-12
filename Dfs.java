import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

import javax.annotation.PostConstruct;


public class Dfs 
{
	private LinkedList<Integer>[] larray;
	private int[] visited;
	private int[] previous;
	private int[] prev_time;
	private int[] post_time;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	Dfs(int n)
	{
		larray = (LinkedList<Integer>[])new LinkedList[n];
		visited = new int[n];
		previous = new int[n];
		prev_time=new int[n];
		post_time=new int[n];
		for(int i=0;i<n;i++)
		{
			larray[i]=new LinkedList<Integer>();
		}
		
	}
	public  void inputGraph() throws IOException
	{
		
		for(int i=0;i<larray.length;i++)
		{
			System.out.println("enter the vertices connected to "+(i));
			String c[]= br.readLine().split(" ");
			for(int j=0;j<c.length;j++)
			{
				larray[i].add(Integer.parseInt(c[j]));
			}
		}
		
	}
	public void DepthFirstSearch()
	{
		for(int i=0;i<larray.length;i++)
		{
			visited[i]=-1;
			previous[i]=-1;
		}
		for(int i=0;i<larray.length;i++)
		{
			if(visited[i]==-1)
				Dfs_visit(i);
		}
	}
	int time=0;
	public void Dfs_visit(int i)
	{
		System.out.println(i);
		visited[i]=0;
		time=time+1;
		prev_time[i]=time;
		for(int a:larray[i])
		{
			if(visited[a]==-1)
			{
				previous[a]=i;
				Dfs_visit(a);
			}
		}
		visited[i]=1;
		post_time[i]=time=time+1;
		
	}
	public  void print_all()
	{
		for(int i=0;i< prev_time.length;i++)
			System.out.print(prev_time[i]+" ");
		System.out.println();
		for(int i=0;i< post_time.length;i++)
			System.out.print(post_time[i]+" ");
	}
		

	public static void main(String[] args) throws NumberFormatException, IOException
	{
		System.out.println("enter number of vertices ");
		
		int n  = Integer.parseInt(br.readLine());
		
		Dfs dfs = new Dfs(n);
		dfs.inputGraph();
		
		
		dfs.DepthFirstSearch();
		dfs.print_all();
		
		
		
	}

}
