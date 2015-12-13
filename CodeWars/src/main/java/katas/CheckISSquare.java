package katas;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class CheckISSquare {
	public static void main(String[] args) {
		System.out.println("Checking square");
		System.out.println("4 " + isSquare(4));
		System.out.println("-4 " + isSquare(-4));
		System.out.println("227253721 " + isSquare(227253721));
                
        }

	public static boolean isSquare(int n) {

		for (int i = 0; i*i <= n; i++) {
			if (i * i == n) {
				return true;
			}
		}
		return false;
	}

	/// Clever solution
	public static boolean isSquare1(int n) {
		return Math.sqrt(n) % 1 == 0;
	}

	@Test
	public void shouldWorkForSomeExamples() throws Exception {
		assertEquals("negative numbers aren't square numbers", false,
				CheckISSquare.isSquare(-1));
		assertEquals("3 isn't a square number", false,
				CheckISSquare.isSquare(3));
		assertEquals("4 is a square number", true, CheckISSquare.isSquare(4));
		assertEquals("25 is a square number", true, CheckISSquare.isSquare(25));
		assertEquals("26 isn't a square number", false, CheckISSquare.isSquare(26));
	}

	@Test
	public void shouldWorkForRandomSquareNumbers() throws Exception {
		Random rand = new Random();
		for (int i = 0; i < 100; ++i) {
			int randomNum = rand.nextInt(0x0fff);
			int randomSq = randomNum * randomNum;
			assertEquals(String.format("%d is a square number", randomSq),
					true, CheckISSquare.isSquare(randomSq));
		}
	}
}
