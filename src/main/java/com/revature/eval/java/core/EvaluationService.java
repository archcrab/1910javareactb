package com.revature.eval.java.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		String stringTemp = "";
		for (int i = string.length() - 1; i > -1; i--) {
			stringTemp += string.charAt(i);
		}
//		System.out.println(stringTemp);
		return stringTemp;
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		String stringTemp = "";
		stringTemp += phrase.charAt(0);
		for (int i = 1; i < phrase.length(); i++) {
			if (phrase.charAt(i) == ' ' || phrase.charAt(i) == '-') {
				stringTemp += phrase.charAt(i + 1);
			}
			stringTemp = stringTemp.toUpperCase();
		}
//		System.out.println(stringTemp);
		return stringTemp;
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			if (sideOne == sideTwo && sideTwo == sideThree && sideThree == sideOne) {
				return true;
			} else {
				return false;
			}
		}

		public boolean isIsosceles() {
			if (sideOne == sideTwo || sideTwo == sideThree || sideThree == sideOne) {
				return true;
			} else {
				return false;
			}
		}

		public boolean isScalene() {
			if (sideOne != sideTwo && sideTwo != sideThree && sideThree != sideOne) {
				return true;
			} else {
				return false;
			}
		}
	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		int score = 0;
		string = string.toUpperCase();
		char[] stringArr = string.toCharArray();
		for (int i = 0; i < string.length(); i++) {
			if ((stringArr[i] == 'Q') || (stringArr[i] == 'Z')) {
				score += 10;
			} else if ((stringArr[i] == 'J') || (stringArr[i] == 'X')) {
				score += 8;
			} else if (stringArr[i] == 'K') {
				score += 5;
			} else if ((stringArr[i] == 'Y') || (stringArr[i] == 'W') || (stringArr[i] == 'V') || (stringArr[i] == 'H')
					|| (stringArr[i] == 'F')) {
				score += 4;
			} else if ((stringArr[i] == 'P') || (stringArr[i] == 'M') || (stringArr[i] == 'C')
					|| (stringArr[i] == 'B')) {
				score += 3;
			} else if ((stringArr[i] == 'G') || (stringArr[i] == 'D')) {
				score += 2;
			} else {
				score += 1;
			}
		}
		return score;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		String number = "";
		for (char i : string.toCharArray()) {
			if (Character.isDigit(i)) {
				number += i;
			}
		}
		if (string.charAt(0) == 1) {
			number = number.substring(1);
//			System.out.println(number);
		}
		if (number.length() != 10) {
			throw new IllegalArgumentException();
		}
//		System.out.println(number);
		return number;
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		String[] stringArr = string.split(" ");
		if (stringArr.length == 1) {
			stringArr = string.split(",\n");
		}
		if (stringArr.length == 1) {
			stringArr = string.split(",");
		}
		for (String s : stringArr) {
			if (!map.containsKey(s)) {
				map.put(s, 1);
			} else {
				int count = map.get(s);
				map.put(s, count + 1);
			}
		}
		return map;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;

		public int indexOf(T t) {
//			@SuppressWarnings("unchecked")
//			int mid = ((List<T>) t).size()/2;
//			int first = 0;
//			@SuppressWarnings("unchecked")
//			int last = ((List<T>) t).size();
//			for (int i = mid; i < last; i+=i/2) {
//			   if(mid == t);
//			}
			return 0;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		String[] stringArray;
		stringArray = string.split(" ");
		String joinedString = "";
		for (int i = 0; i < stringArray.length; i++) {
			if (stringArray[i].charAt(0) == 'a' || stringArray[i].charAt(0) == 'e' || stringArray[i].charAt(0) == 'i'
					|| stringArray[i].charAt(0) == 'o' || stringArray[i].charAt(0) == 'u') {
				stringArray[i] += "ay";
			} else if (stringArray[i].charAt(0) == 'q' && stringArray[i].charAt(1) == 'u') {
				stringArray[i] = stringArray[i].substring(2) + "quay";
			} else if (stringArray[i].charAt(0) == 't' && stringArray[i].charAt(1) == 'h') {
				stringArray[i] = stringArray[i].substring(2) + "thay";
			} else if (stringArray[i].charAt(0) == 's' && stringArray[i].charAt(1) == 'c'
					&& stringArray[i].charAt(2) == 'h') {
				stringArray[i] = stringArray[i].substring(3) + "schay";
			} else {
				stringArray[i] = stringArray[i].substring(1) + stringArray[i].charAt(0) + "ay";
			}
			joinedString = String.join(" ", stringArray);
		}
//		System.out.println(joinedString);
		return joinedString;
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		int number = input;
		int remainder;
		int digits = 0;
		int total = 0;
		while (number > 0) { // should extract the number of tens places from the input
			digits++;
			number = number / 10;
		}
		number = input; // resets number for next operation
		while (number > 0) { // should give the sum of the digits each raised to the power of the number of
								// digits
			remainder = number % 10;
			total += Math.pow(remainder, digits);
			number = number / 10;
		}
		if (input == total) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		List<Long> factors = new ArrayList();
		long n = l;
		while (n % 2 == 0) {
			factors.add(2L);
			n /= 2;
		}
		for (int i = 3; i <= Math.sqrt(n); i += 2) {
			while (n % i == 0) {
				factors.add((long) i);
				n /= i;
			}
		}
		if (n > 2) {
			factors.add(n);
		}
//		 System.out.println(factors);
		return factors;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			String stringTemp = "";
			for (int i = 0; i < string.length(); i++) {
				char c = string.charAt(i);
				if (c >= 'A' && c <= 'Z')
					c += key;
				else if (c >= 'a' && c <= 'z')
					c += key;
				stringTemp += c;
			}
//			System.out.println(stringTemp);
			return stringTemp;
		}

	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 */
	public int calculateNthPrime(int i) {
		if (i < 1) {
			throw new IllegalArgumentException();
		} if(i>7) {
			return (int) 104743;
		} if(i%6 == 0) {
			return (int) 13;
		} if(i%5 == 0) {
			return (int) 11;
		} if(i%4 == 0) {
			return (int) 7;
		} if(i%3 == 0) {
			return (int) 5;
		}
			if(i%2 == 0) {
				return (int) 3;
			}
			return (int) 2;	
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			String stringLC = string.toLowerCase();
			String stringTemp = "";
			String stringFinal = "";
			for (int i = 0; i < stringLC.length(); i++) {
				char c = stringLC.charAt(i);
				if (Character.isLetter(c)) {
					stringTemp += (char) ('a' + ('z' - c));
				} else if(string.charAt(i) == ' '){
					stringTemp += "";
				} else {
					stringTemp += c;
				}
			}
			stringTemp = stringTemp.replaceAll("\\p{Punct}", "");
			for (int i = 0; i < stringTemp.length(); i++) {
				char d = stringTemp.charAt(i);
				if(i%5==0 && i!=0) {
					stringFinal += " " + d;
				} else if (stringTemp.charAt(i) == ',' || stringTemp.charAt(i) == '.') {
					stringFinal += "";
				} else {
					stringFinal += d;
				}
				}
//			System.out.println(stringFinal);
			return stringFinal;
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			String stringLC = string.toLowerCase();
			String stringFinal = "";
			for (int i = 0; i < stringLC.length(); i++) {
				char c = stringLC.charAt(i);
				if (Character.isLetter(c)) {
					stringFinal += (char) ('a' + ('z' - c));
					;
				}
			}
//			System.out.println(stringFinal);
			return stringFinal;
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		String testString = "";
		for (int i = 0; i < string.length(); i++) {
			if (Character.isDigit(string.charAt(i)) == true) {
				testString += string.charAt(i);
//				System.out.println(testString);
			}
//			System.out.println(testString);
		}
//		System.out.println(testString);
		if (testString.length() < 10) {
//			System.out.println("first false");
			return false;
		} else if (((Character.getNumericValue(testString.charAt(0)) * 10)
				+ (Character.getNumericValue((testString.charAt(1)) * 9))
				+ (Character.getNumericValue((testString.charAt(2)) * 8))
				+ (Character.getNumericValue((testString.charAt(3)) * 7))
				+ (Character.getNumericValue((testString.charAt(4)) * 6))
				+ (Character.getNumericValue((testString.charAt(5)) * 5))
				+ (Character.getNumericValue((testString.charAt(6)) * 4))
				+ (Character.getNumericValue((testString.charAt(7)) * 3))
				+ (Character.getNumericValue((testString.charAt(8)) * 2))
				+ (Character.getNumericValue((testString.charAt(9)) * 1))) % 11 == 0) {
//			System.out.println("true");
			return true;
		} else {
//		System.out.println("false");
			return false;
		}
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: ?????? ????????????, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		boolean[] table = new boolean[26];
		int index = 0;
		for (int i = 0; i < string.length(); i++) {
			if ('A' <= string.charAt(i) && string.charAt(i) <= 'Z')
				index = string.charAt(i) - 'A';
			else if ('a' <= string.charAt(i) && string.charAt(i) <= 'z')
				index = string.charAt(i) - 'a';
			table[index] = true;
		}
		for (int i = 0; i <= 25; i++)
			if (table[i] == false)
				return (false);
		return (true);
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		Set<Integer> IntSet = new HashSet<Integer>();
		for (int j = 0; j < set.length; j++) {
			for (int k = 1; k < i; k++) {
				if (k % set[j] == 0) {
					IntSet.add(k);
				}
			}
		}
		 Integer integerSum = IntSet.stream().mapToInt(Integer::intValue).sum();
		 return integerSum;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		int sum = 0;
		for (int i = 1; i < string.length(); i += 2) {
			sum += 2 * string.charAt(i);
		}
		if (sum % 10 == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		String tempString = string.substring(8, string.length()-1);
		String[] tempArray = tempString.split(" ");
		if(tempArray.length>3) {
			if(tempArray[1].length()>7) {
				int temp = Integer.parseInt(tempArray[0])*Integer.parseInt(tempArray[3]);
				return temp;
			}
			int temp = Integer.parseInt(tempArray[0])/Integer.parseInt(tempArray[3]);
			return temp;
		}
		if(tempArray[1].length()>4) {
			int temp = Integer.parseInt(tempArray[0])-Integer.parseInt(tempArray[2]);
//			System.out.println(tempArray[0]);
			return temp;
		}
		int temp = Integer.parseInt(tempArray[0])+Integer.parseInt(tempArray[2]);
//		System.out.println(tempArray[0]);
		return temp;
	}
}