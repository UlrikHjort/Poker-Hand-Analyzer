/*******************************************************************************
 *                                                                             *
 *                            Poker Hand Analyzer                              *
 *                                                                             *
 *                           AnalyseHand.java                                  *
 *                                                                             *
 *                                   Module                                    *
 *                                                                             *
 *                    Copyright (C) 2008 Ulrik H¿rlyk Hjort                    *
 *                                                                             *
 *   Poker Hand Analyzer is free software;  you can  redistribute it           *
 *   and/or modify it under terms of the  GNU General Public License           *
 *   as published  by the Free Software  Foundation;  either version 2,        *
 *   or (at your option) any later version.                                    *
 *   Poker Hand Analyzer is distributed in the hope that it will be            *
 *   useful, but WITHOUT ANY WARRANTY;  without even the  implied warranty     *
 *   of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.                   *
 *   See the GNU General Public License for  more details.                     *
 *   You should have  received  a copy of the GNU General                      *
 *   Public License  distributed with Yolk.  If not, write  to  the  Free      *
 *   Software Foundation,  51  Franklin  Street,  Fifth  Floor, Boston,        *
 *   MA 02110 - 1301, USA.                                                     *
 *                                                                             *
 ******************************************************************************/
package com.game.analysis.poker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author uhh
 * 
 */
public class AnalyzeHand {

	/**
	 * 
	 * @param hand
	 * @param flop
	 * @return
	 */
	public int holdEm(int[] hand, int[] flop) {

		return 0;

	}

	/**
	 * 
	 * @param hand
	 * @return
	 */
	private int handValue(ArrayList<Integer> hand) {
		int value = 0;
		for (Integer i : hand) {
			value += i;

			// Count Ace as highest:
			if (i == 0) {
				value += 14;
			}
		}
		return value;
	}

	/**
	 * 
	 * @param hand
	 * @param flop
	 * @return
	 */
	public static int[] concat(int[] hand, int[] flop) {
		int[] result = Arrays.copyOf(hand, hand.length + flop.length);
		System.arraycopy(flop, 0, result, hand.length, flop.length);
		return result;
	}

	/**
	 * 
	 * @param hand
	 * @param flop
	 * @return
	 */
	private int highCard(int[] hand, int[] flop) {
		return 0;
	}

	/**
	 * 
	 * @param hand
	 * @return
	 */
	public int pair(ArrayList<Integer> hand) {

		ArrayList<Integer> pairList = new ArrayList<Integer>();

		int retVal = 0;

		for (Integer i : hand) {
			for (Integer j : hand) {
				if ((i != j) && ((i % 13) == (j % 13))) {
					pairList.add(i);
				}
			}
		}

		if (!pairList.isEmpty()) {
			retVal = handValue(hand) + 100;
			System.out.println("PAIR:");
			ArrayList<String> sl = Deck.toStringList(hand);
			for (String s : sl) {
				System.out.print(s + " ");
			}

		}

		// return hand val + 100
		return retVal;
	}

	/**
	 * 
	 * @param hand
	 * @return
	 */
	public int twoPair(ArrayList<Integer> hand) {

		ArrayList<Integer> pairList = new ArrayList<Integer>();

		int retVal = 0;

		for (Integer i : hand) {
			for (Integer j : hand) {
				if ((i != j) && ((i % 13) == (j % 13))) {
					pairList.add(i);
				}
			}
		}

		if (pairList.size() >= 4) {
			System.out.println("Two PAIR:");
			ArrayList<String> sl = Deck.toStringList(hand);
			for (String s : sl) {
				System.out.print(s + " ");
			}

			retVal = handValue(hand) + 1000;
		}

		// for (Integer ii : pairList) {
		// System.out.println("two PAITLIST " + ii + " " + pairList.size());
		// }
		// return hand val + 1000

		return retVal;
	}

	/**
	 * 
	 * @param hand
	 * @return
	 */
	public int threeOfAkind(ArrayList<Integer> hand) {

		int retVal = 0;

		for (Integer i : hand) {
			for (Integer j : hand) {
				for (Integer k : hand) {
					if ((i != j) && (i != k) && (j != k)) {
						if (((i % 13) == (j % 13)) && ((i % 13) == (k % 13))) {
							retVal = handValue(hand) + 100000;
						}
					}
				}
			}
		}

		if (retVal != 0) {
			System.out.println("3 of a kind: ");
			ArrayList<String> sl = Deck.toStringList(hand);
			for (String s : sl) {
				System.out.print(s + " ");
			}
		}
		// return hand val + 10 000
		return retVal;
	}

	/**
	 * 
	 * @param hand
	 * @param flop
	 * @return
	 */
	private int straight(int[] hand, int[] flop) {
		// return hand val + 100 000

		return 0;
	}

	/**
	 * 
	 * @param hand
	 * @param flop
	 * @return
	 */
	private int flush(int[] hand, int[] flop) {
		// return hand val + 1000 000

		return 0;
	}

	/**
	 * 
	 * @param hand
	 * @return
	 */
	public int fullHouse(ArrayList<Integer> hand) {

		int retVal = 0;

		if ((pair(hand) != 0) && (twoPair(hand) != 0)
				&& (threeOfAkind(hand) != 0)) {
			System.out.println("Full House ");
			ArrayList<String> sl = Deck.toStringList(hand);
			for (String s : sl) {
				System.out.print(s + " ");
			}
			retVal = handValue(hand) + 10000000;
		}

		// return hand val + 10 000 000
		return 0;
	}

	/**
	 * 
	 * @param hand
	 * @return
	 */
	public int fourOfAkind(ArrayList<Integer> hand) {

		int retVal = 0;

		for (Integer i : hand) {
			for (Integer j : hand) {
				for (Integer k : hand) {
					for (Integer l : hand) {
						if ((i != j) && (i != k) && (i != l) && (j != k)
								&& (j != l) && (k != l)) {
							if (((i % 13) == (j % 13))
									&& ((i % 13) == (k % 13))
									&& (k % 13) == (l % 13)) {
								retVal = handValue(hand) + 100000000;
							}
						}
					}
				}
			}
		}

		if (retVal != 0) {
			System.out.println("4 of a kind: ");
			ArrayList<String> sl = Deck.toStringList(hand);
			for (String s : sl) {
				System.out.print(s + " ");
			}
		}
		// return hand val + 100 000 000
		return retVal;
	}

	/**
	 * 
	 * @param hand
	 * @return
	 */
	public int straightFlush(ArrayList<Integer> hand) {

		ArrayList<Integer> handTmp = new ArrayList<Integer>(hand.size());

		int retVal = 0;

		for (Integer i : hand) {
			handTmp.add(i);
		}
		// System.out.println("LLL: " + hand.size() + " " + handTmp.size());
		if ((hand.contains(0) && hand.contains(9) && hand.contains(10)
				&& hand.contains(11) && hand.contains(12))
				||

				(hand.contains(13) && hand.contains(22) && hand.contains(23)
						&& hand.contains(24) && hand.contains(25))
				||

				(hand.contains(26) && hand.contains(35) && hand.contains(36)
						&& hand.contains(37) && hand.contains(38))
				||

				(hand.contains(39) && hand.contains(48) && hand.contains(49)
						&& hand.contains(50) && hand.contains(51))

		) {
			System.out.println("RS FLUSH!");

			ArrayList<String> sl = Deck.toStringList(hand);
			for (String s : sl)
				System.out.print(s + " ");

			retVal = handValue(hand) + 1000000000;
			// System.exit(1);
		}

		// return hand val + 1000 000 000
		return retVal;
	}

}
