import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StreamFilter {

	/* We can use Streams to make our code clean. Below we can see a way to fo a for loop without 
	 * use a for loop, just using stream.
	 * */

	@Test
	public void streamOfFilter() {
		
		ArrayList<String> names = new ArrayList<String>();
		names.add("Jessica");
		names.add("Alex");
		names.add("Carol");
		names.add("Luana");
		names.add("Alice");
		
		/*
		 * If we would to count the number elements of the arrays that starts with the letter A, without stream
		 * we should have something like this:
		 * int count = 0;
		 * for(int i =0; i < names.size(); i++){
		 * String actual = names.get(i);
		 * 	if(actual.startsWith("A"))
		 * 	{
		 * 		count++;
		 * 	}
		 * }
		 * System.out.println(count);
		 * 
		 * */
		
		//Now, using stream
		
		names.stream().filter(s->s.startsWith("A")).count();
		
		/*The code above transform the arrayList in a stream of string. In case we dont want to do that, we can create a Stream, like below
		In this example we will count how many names starts with the A letter*/
		
		
		
		System.out.println(Stream.of("Jessica","Alex","Carol","Luana","Alice").filter(s->s.startsWith("A")).count());
		
		
		//More one example, now, the number of names that the lenght are gatter then 4
		
		names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		
		//Now, filtering the names that have lenght gratter than 4, but just the first one
		
		names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));

	/*
	 * We can also manipulate our Stream filter results throug map method, for example, lets get our result and 
	 * transform this in a uppercase name*/
		
		names.stream().filter(s->s.length()>4).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		//Now lets try print names that have a letter in the firts position, as uppercase and sorted by alphabet order
		
		names.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		//With Stream, we can also merge lists. Lets do it using to lists
		
		ArrayList<String> listToMerge1 = new ArrayList<String>();
		listToMerge1.add("Maria da Fé");
		listToMerge1.add("Americana");
		listToMerge1.add("Joinville");
		
		
		ArrayList<String> listToMerge2 = new ArrayList<String>();
		listToMerge2.add("MG");
		listToMerge2.add("SP");
		listToMerge2.add("SC");
		
		Stream streamOfMergedList = Stream.concat(listToMerge1.stream(), listToMerge2.stream());
		
		streamOfMergedList.sorted().forEach(s->System.out.println(s));
		
		//And another interesting method os Stream class is the method match. Lets create a new Stream to test this
		
		Stream<String>streamToMatch = Stream.concat(listToMerge1.stream(), listToMerge2.stream());
		
		boolean foundMatch = streamToMatch.anyMatch(s->s.equalsIgnoreCase("maria da fé"));
		System.out.println(foundMatch);
		Assert.assertTrue(foundMatch);
		
		/*
		 * We transform our list in a Stream, to use all methods that this class can offers us to improve our code, to put
		 * our code in best practices, but after do every manipulation that we want with out stream, we can rollback and transform 
		 * stream in a list again. Lets see the example below*/
		
		List<String> scannerToList = Stream.of("January","February","March","April","May","June","July","August","September","October","November","December")
		.filter(s->s.startsWith("J")).map(s->s.toUpperCase()).collect(Collectors.toList());
		
		System.out.println(scannerToList.get(0));
		
		/*Stream can be also used with lists that are not Lists of String, for example, Integer list. And the Stream its so powerfull that 
		 * help us to sort and array of list and show just one value of each one, when its repeated inside the list. If we do not use 
		 * stream, it also can be done but the code come more difficult to write and understand. Once, stream comes to make our code clean
		 * and easily readable. Lets see an example*/
		
		List<Integer> arrayOfInts = Arrays.asList(1,4,2,6,4,2,8,7,1,1,3);
		arrayOfInts.stream().distinct().sorted().forEach(s->System.out.println(s));	
	}
}
