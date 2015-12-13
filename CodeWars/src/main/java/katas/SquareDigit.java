package katas;

import static org.junit.Assert.*;

import org.junit.Test;

/*
 * Welcome. In this kata, you are asked to square every digit of a number.

For example, if we run 9119 through the function, 811181 will come out.

Note: The function accepts an integer and returns an integer
 */

public class SquareDigit {
	public static void main(String[] args) {
		System.out.println("Squery");
		System.out.println(squareDigits(9119));
	}

	public static int squareDigits(int n) {
		String number = n + "", result = "";

		for(int i = 0; i< number.length();i ++){
			int digit = Character.getNumericValue(number.charAt(i));
			result += digit * digit;
		}

		return Integer.parseInt(result);
	}

	@Test
	public void test() {

		assertEquals(811181, new SquareDigit().squareDigits(9119));

	}


	/// Clever solutions
	public static int squareDigits1(int n) {
		String result = "";

		while (n != 0) {
			int digit = n % 10;
			result = digit * digit + result;
			n /= 10;
		}

		return Integer.parseInt(result);
	}

	///  public int squareDigits(int n) {
/*    return Integer.parseInt(String.valueOf(n)
            .chars()
            .map(i -> Integer.parseInt(String.valueOf((char) i)))
            .map(i -> i * i)
            .mapToObj(String::valueOf)
            .collect(Collectors.joining("")));
}*/
}
