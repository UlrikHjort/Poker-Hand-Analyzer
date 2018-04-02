/*******************************************************************************
 *                                                                             *
 *                            Poker Hand Analyzer                              *
 *                                                                             *
 *                                  Hand.java                                  *
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
import java.util.Collections;

/**
 * 
 * @author uhh
 * 
 */
public class Hand {

	private Deck m_deck;
	private int[] m_hand;
	private ArrayList<Integer> m_handList = new ArrayList<Integer>();

	/**
	 * 
	 */
	public Hand() {
		m_deck = Deck.getInstance();
	}

	/**
	 * 
	 */
	public void dealHand() {
		m_handList.clear();
		m_hand = m_deck.drawCards(2);
		for (int i = 0; i < 2; i++) {
			m_handList.add(m_hand[i]);
		}
	}

	/**
	 * 
	 * @param cardIndex
	 * @return
	 */
	private String getCardString(int cardIndex) {
		return m_deck.getCardString(cardIndex);
	}

	/**
	 * 
	 * @param flop
	 */
	public void analyzeHand(ArrayList<Integer> flop) {
		ArrayList<Integer> fullHand = flop;

		// Collections.copy(fullHand, flop);
		for (int i = 0; i < m_hand.length; i++) {
			fullHand.add(m_hand[i]);
		}

		// printFullHand(fullHand);
		// Collections.sort(fullHand);
		// printFullHand(fullHand);

		ArrayList<String> fullHandStrings = new ArrayList<String>();
		for (int i = 0; i < fullHand.size(); i++) {
			fullHandStrings.add(m_deck.getCardString(fullHand.get(i)));
		}
		// System.out.println("-------------");
		// printFullHandString(fullHandStrings);
		// Collections.sort(fullHandStrings);
		// System.out.println("-------------");
		// printFullHandString(fullHandStrings);
		// System.out.println("-------------");

		/*
		 * ArrayList<Integer> il = new ArrayList<Integer>(); il.add(13);
		 * il.add(22); il.add(23); il.add(24); il.add(25); il.add(4); il.add(7);
		 */
		AnalyzeHand ah = new AnalyzeHand();

		int retVal;

		retVal = ah.straightFlush(fullHand);

		if (retVal == 0) {
			retVal = ah.fourOfAkind(fullHand);
		}

		if (retVal == 0) {
			retVal = ah.fullHouse(fullHand);
		}

		if (retVal == 0) {
			retVal = ah.threeOfAkind(fullHand);
		}

		if (retVal == 0) {
			retVal = ah.twoPair(fullHand);
		}

		if (retVal == 0) {
			retVal = ah.pair(fullHand);
		}
	}

	/**
	 * 
	 * @param fullHand
	 */
	private void printFullHand(ArrayList<Integer> fullHand) {
		for (int i = 0; i < fullHand.size(); i++) {
			System.out.print(m_deck.getCardString(fullHand.get(i)) + " ");
		}
		System.out.println();
	}

	/**
	 * 
	 * @param fullHand
	 */
	private void printFullHandString(ArrayList<String> fullHand) {
		for (int i = 0; i < fullHand.size(); i++) {
			System.out.print(fullHand.get(i) + " ");
		}
		System.out.println();
	}

	/**
	 * 
	 */
	public void printHand() {
		System.out.println(getCardString(m_hand[0]) + " "
				+ getCardString(m_hand[1]));
	}
}
