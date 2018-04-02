/*******************************************************************************
 *                                                                             *
 *                            Poker Hand Analyzer                              *
 *                                                                             *
 *                                  Deck.java                                  *
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
import java.util.Random;

/**
 * 
 * @author uhh
 * 
 */
public class Deck {

	private static String deck[][] = new String[][] {
			{ "Ah", "2h", "3h", "4h", "5h", "6h", "7h", "8h", "9h", "10h",
					"Jh", "Qh", "Kh" },
			{ "Ad", "2d", "3d", "4d", "5d", "6d", "7d", "8d", "9d", "10d",
					"Jd", "Qd", "Kd" },
			{ "As", "2s", "3s", "4s", "5s", "6s", "7s", "8s", "9s", "10s",
					"Js", "Qs", "Ks" },
			{ "Ac", "2c", "3c", "4c", "5c", "6c", "7c", "8c", "9c", "10c",
					"Jc", "Qc", "Kc" } };

	private Boolean[] cardUsed = new Boolean[52];

	/**
	 * 
	 * @author uhh
	 * 
	 */
	private static class SingletonHolder {
		public static final Deck INSTANCE = new Deck();
	}

	/**
	 * 
	 * @return
	 */
	public static Deck getInstance() {
		return SingletonHolder.INSTANCE;
	}

	/**
	 * 
	 */
	private Deck() {
		newGame();
	}

	/**
	 * 
	 * @param il
	 * @return
	 */
	public static ArrayList<String> toStringList(ArrayList<Integer> il) {
		ArrayList<String> sl = new ArrayList<String>(il.size());
		for (Integer i : il) {
			int x = (int) i / 13;
			int y = i % 13;
			sl.add(deck[x][y]);
		}
		return sl;

	}

	/**
	 * 
	 * @param numberOfCards
	 * @return
	 */
	public int[] drawCards(int numberOfCards) {
		int[] hand = new int[numberOfCards];
		for (int i = 0; i < hand.length; i++)
			hand[i] = drawCard();

		return hand;
	}

	/**
	 * 
	 */
	public void newGame() {
		initCardUsed();
	}

	/**
	 * 
	 */
	private void initCardUsed() {
		for (int i = 0; i < cardUsed.length; i++)
			cardUsed[i] = false;
	}

	/**
	 * 
	 * @param index
	 * @return
	 */
	private boolean isCardUsed(int index) {
		return cardUsed[index];
	}

	/**
	 * 
	 * @param index
	 */
	private void markCardUsed(int index) {
		cardUsed[index] = true;
	}

	/**
	 * 
	 * @param index
	 * @return
	 */
	public String getCardString(int index) {
		int x = (int) index / 13;
		int y = index % 13;
		return deck[x][y];
	}

	/**
	 * 
	 * @return
	 */
	private int drawCard() {
		int index;

		do {
			index = getRandomIndex();
		} while (isCardUsed(index));

		markCardUsed(index);

		return index;
	}

	/**
	 * 
	 * @return
	 */
	private int getRandomIndex() {
		Random randomGenerator = new Random();
		return randomGenerator.nextInt(52);
	}

	/**
	 * 
	 * @param limit
	 * @return
	 */
	private int getRandomIndex(int limit) {
		Random randomGenerator = new Random();
		return randomGenerator.nextInt(limit);
	}

}
