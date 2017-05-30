import java.io.*;
import java.util.Timer;
import java.util.*;
import java.lang.Math.*;

public class Primes {
	
	//Checking if a number is prime
	public static boolean isPrime(int i) {
		int j = 2;
		boolean answer;
		
		if(i == 1 || i == 2) {
			answer = true;
			return answer;
		} else {
			while(j < i) {
				if(i % j == 0) {
					answer = false;
					return answer;
				}
				j++;
			}
		}
		
		answer = true;
		
		return answer;
	}
	
	
	//Finding a specific prime and all the primes that are lower than input.
	
	public static int[] findPrimes(int number, int specific) {
		int[] primes = new int[number]; //Gets a little too big
		
		//Adjusting array size
		if(number < 10) {
			primes = new int[number];
		} else if(number < 100) {
			primes = new int[number / 2];
		} else if(number < 1000) {
			primes = new int[number / 3];
		} else {
			double j = (double) number;
			int k = (int)Math.ceil(Math.log(j) / 2);
			primes = new int[number / k];
		}
		
		int counter = 0;
		int i = 0;
		
		long starTime = System.currentTimeMillis();
		
		while(i < number) {
			if(isPrime(i)) {
				primes[counter] = i;
				counter++;
			}
			i++;
		}
		
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("");
		System.out.println("The execution took: " + (endTime - starTime) + " ms");
		System.out.println("");
		System.out.println("Prime number " + specific + " is: " + primes[specific]);
		System.out.println("");
		System.out.println("Biggest prime lower than " + number + " is: " + primes[counter - 1]);
		System.out.println("");
		
		return primes;
	}

	public static void main(String[] args) {
		//isPrime(10);
		//findPrimes(5000, 5);
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Enter an integer to find all primes smaller than that number: ");
		int limit = Integer.parseInt(reader.nextLine());
		
		System.out.println("Enter an integer to find the prime at that specific point in the prime array: ");
		int spec = Integer.parseInt(reader.nextLine());
		
		reader.close();
		
		int[] primes = findPrimes(limit,spec);
		
		//Setting parameters and printing out the array
		int br = primes.length / 13;
		
		if(primes.length % 13 > 0) {
			br += 1;
		}
		
		System.out.println("Here comes the prime array in a 13x" + br + " grid");
		
		for(int i = 0; i < primes.length; i++) {
			System.out.print(primes[i] + " ");
			
			if(i % 13 == 0) {
				System.out.println("");
			}
		}
	}

}
