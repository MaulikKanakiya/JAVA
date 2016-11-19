import java.io.*;
import java.util.*;

class TestPerformance
{
	public static void addElements(List list)
	{
		for(int i=0 ; i<50000 ; i++)
		{
			list.add(i+1);
		}
	}
	
	public static void print(List list)
	{
		for(int i=0 ; i<list.size() ; i++)
		{
			System.out.print(list.get(i)+"\t");
		}
	}

	public static void main ( String args [] ) throws Exception
	{
		List array = new ArrayList();
		List list = new LinkedList();
		long startArr,endArr,startList,endList;
		
		startArr = new java.util.Date().getTime();
		addElements(array);
		print(array);
		endArr = new java.util.Date().getTime();
		
		startList = new java.util.Date().getTime();
		addElements(list);
		print(list);
		endList = new java.util.Date().getTime();
		
		System.out.println("\n---> Required time to add elements into the ArrayList is "+(endArr-startArr)/1000+" sec");
		System.out.println("\n---> Required time to add elements into the LinkedList is "+(endList-startList)/1000+" sec");
	}
}

/*

OUTPUT :->

---> Required time to add elements into the ArrayList is 3 sec

---> Required time to add elements into the LinkedList is 7 sec

*/