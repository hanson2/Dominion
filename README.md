# Definition of Done

- [x] Have a game the chooses a winner once 3 or more of the supply piles run
  out or all the Province cards run out and that turn ends. In case of a tie,
  the player with the fewest turns of tied players wins, if still a tie, all
  still tied players win. (Implemented with e6340eaa)

    - [ ] BVA: 0 pile, 1 pile, 3 pile, 4 pile
	
- [x] Have a design that incredibly easy to expand, thus utilizing card
  keywords in design. (Implemented using a state machine.  See commit 1868d8b3
  for details)
  
    - [x] Thinking out the design well such that it is particularly easy to add
      cards. It should be easy enough to add new game mechanics, but because
      expansions are primarily cards and minor game mechanics. (See b153440a
      for details)
	 
    - [x] Ability to have 2 to 4 players and generates the proper setup for a
      game including randomly choosing 10 supply piles, or choosing from
      preselected recommended sets. (Implemented with bc78e4fa)

        - [ ] Have turns consisting of an action phase, a buy phase, and a
          cleanup phase.  At no point should it go in any other order than
          that.
	
    - [ ] The action phase begins automatically when the turn is passed to a
      new player. Each player starts the action phase with one buy and one
      action.  Actions can be used to play action cards, where they give
      bonuses to the player. These include more actions, more buys, more cards,
      and more money.  They can also require other players to carry out
      actions. Cards must be played to completion before a new card can be
      played, and each require one action unless specified otherwise. The
      action phase ends once the player has no more actions, has no more action
      cards, or decides to move to the buy phase via a gui button.
	
        - [ ] BVA: if the players actions are done (0 actions remaining), If
          they have no action cards, if they voluntarily end phase with card
          and action, cards and action, card and actions, cards and actions
	
    - [x] The buy phase begins once a player exits the action phase. All that
      player’s remaining treasure cards get put into play at this point. That
      player has as many buys as they have accumulated during the action phase
      plus their automatic 1 buy. The player may use their treasure from the
      turn to buy cards from non-empty supply piles. Once the player is out of
      money, out of buys, or doesn’t want to buy anything more, the buy phase
      ends.
	
        - [ ] BVA: If the player has buys or money remaining after they have
          exited the buy phase, their buys and money are set to 0.
	
    - [ ] The cleanup phase begins once the buy phase is over. The player has
      no input over this phase, but what happens is all played cards are
      discarded and all cards remaining in hand are discarded. The player then
      receives 5 new cards off the top of their deck. If there are not five
      cards. The player’s discard pile is shuffled and placed underneath the
      player’s drawpile. They then draw 5 new cards. The cleanup phase ends
      when the player has 5 new cards in their hand. The turn then gets passed
      to the next player to have their action phase.
	
        - [ ] Edges cases: if there are no cards in draw pile and discard
          shuffles, if there are less than 5 cards in draw pile and discard
          shuffles, if there are no cards in draw or discards, you cannot draw
          a card.
	
- [ ] Have a number displayed on top of the draw pile to show how many cards
  are remaining in the draw pile.
	
    - [x] BVA: No cards left to draw (implemented in aa1fcfd3)
