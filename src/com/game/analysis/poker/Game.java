/*******************************************************************************
 *                                                                             *
 *                            Poker Hand Analyzer                              *
 *                                                                             *
 *                                  Game.java                                  *
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

/**
 * 
 * @author uhh
 * 
 */
public class Game {

	Hand[] hands;
	Flop flop;

	/**
	 * 
	 */
	public Game() {
		initHands(10);
	}

	/**
	 * 
	 * @param numberOfPlayers
	 */
	public Game(int numberOfPlayers) {
		initHands(numberOfPlayers);
		Deck.getInstance().newGame();
	}

	/**
	 * 
	 * @param numberOfPlayers
	 */
	private void initHands(int numberOfPlayers) {
		hands = new Hand[numberOfPlayers];
		for (int i = 0; i < hands.length; i++) {
			hands[i] = new Hand();
		}

		flop = new Flop();
	}

	/**
	 * 
	 */
	public void dealHands() {
		for (int i = 0; i < hands.length; i++) {
			hands[i].dealHand();
		}
	}

	/**
	 * 
	 */
	public void dealFlop() {
		flop.dealFlop();
	}

	/**
	 * 
	 */
	public void dealTurn() {
		flop.dealTurn();
	}

	/**
	 * 
	 */
	public void dealRiver() {
		flop.dealRiver();
	}

	/**
	 * 
	 */
	public void printHands() {
		for (int i = 0; i < hands.length; i++) {
			hands[i].printHand();
		}
	}

	/**
	 * 
	 */
	public void printFlop() {
		flop.printFlop();
	}

	/**
	 * 
	 * @param handNumber
	 */
	public void analyzeHand(int handNumber) {
		hands[handNumber].analyzeHand(flop.getFlop());

	}
}
