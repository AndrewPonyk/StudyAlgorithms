package katas;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.*;

public class EANValidation {

	public static void main(String[] args) {
		System.out.println("Ean validation");
		System.out.println(EANValidator.validate("4003301018398")); // True
		System.out.println(EANValidator.validate("4003301018392")); // False
		System.out.println(EANValidator.validate("4003301018398"));
	}
}

class EANValidator {
	public static boolean validate(final String eanCode) {
		int number = 0;
		int sum = 0;

		for (int i = 0; i < 11; i += 2) {
			System.out.print(eanCode.charAt(i));
			number = Character.getNumericValue(eanCode.charAt(i));
			sum += number;
		}

		for (int i = 1; i < 12; i += 2) {
			System.out.print(eanCode.charAt(i));
			number = Character.getNumericValue(eanCode.charAt(i));
			sum += number * 3;
		}

		int checksum = 0;
		if (sum % 10 != 0) {
			checksum = 10 - (sum % 10);
		}

		return checksum == Character.getNumericValue(eanCode.charAt(12));
	}

	public static class EANValidatorTest {
		@Test
		public void test_01() {
			assertTrue(EANValidator.validate("9783815820865"));
		}

		@Test
		public void test_02() {
			assertFalse(EANValidator.validate("9783815820864"));
		}

		@Test
		public void test_03() {
			assertTrue(EANValidator.validate("9783827317100"));
		}

	}
}


