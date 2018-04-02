/*******************************************************************************
 *                                                                             *
 *                            Poker Hand Analyzer                              *
 *                                                                             *
 *                                  Flop.java                                  *
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

/**
 * 
 * @author uhh
 * 
 */
public class Flop {

	private Deck m_deck;
	private int[] m_flop;
	private int[] m_turn;
	private int[] m_river;
	private ArrayList<Integer> flopOnTable = new ArrayList<Integer>();

	/**
	 * 
	 */
	public Flop() {
		m_deck = Deck.getInstance();
	}

	/**
	 * 
	 */
	public void dealFlop() {
		flopOnTable.clear();
		m_flop = m_deck.drawCards(3);
		for (int i = 0; i < 3; i++)
			flopOnTable.add(m_flop[i]);

	}

	/**
	 * 
	 */
	public void dealTurn() {
		m_turn = m_deck.drawCards(1);
		flopOnTable.add(m_turn[0]);

	}

	/**
	 * 
	 */
	public void dealRiver() {
		m_river = m_deck.drawCards(1);
		flopOnTable.add(m_river[0]);

	}

	/**
	 * 
	 */
	public void printFlop() {
		for (int i = 0; i < flopOnTable.size(); i++)
			System.out.print(m_deck.getCardString(flopOnTable.get(i)) + " ");
		System.out.println();
	}

	/*
	 * public void printFlop() {
	 * System.out.println(m_deck.getCardString(m_flop[0]) + " " +
	 * m_deck.getCardString(m_flop[1]) + " " + m_deck.getCardString(m_flop[2]));
	 * }
	 */
	
	/**
	 * 
	 */
	public void printTurn() {
		System.out.println(m_deck.getCardString(m_turn[0]));
	}

	/**
	 * 
	 */
	public void printRiver() {
		System.out.println(m_deck.getCardString(m_river[0]));
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<Integer> getFlop() {
		return flopOnTable;
	}

}
