/*******************************************************************************
 *                                                                             *
 *                            Poker Hand Analyzer                              *
 *                                                                             *
 *                            PokerAnalysis.java                               *
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
public class PokerAnalysis {

	/**
	 * 
	 */
	public void run() {
		Game game = new Game(5);

		game.dealHands();

		// game.printHands();

		game.dealFlop();
		// game.printFlop();
		game.dealTurn();
		// game.printFlop();
		game.dealRiver();
		// game.printFlop();

		game.analyzeHand(0);
		/*
		 * game.analyzeHand(1); game.analyzeHand(2); game.analyzeHand(3);
		 * game.analyzeHand(4);
		 */

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int i = 0;
		while (true) {
			// for (i = 0; i < 4; i++) {
			i++;
			System.out.println("Itertions:" + i);
			PokerAnalysis a = new PokerAnalysis();
			a.run();
		}
	}
}
