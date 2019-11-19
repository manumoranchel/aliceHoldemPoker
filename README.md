# Alice Hold'em Poker

## Scope
The purpose of this exercise is to showcase the technical ability during the hiring process at Alice. Project must be completed within 48h


## The problem
We would like for you to build the game of Texas Hold'em Poker using the command line in Java. The game has some interesting rules and is a great parallel for various business rules we encounter in real projects. Our objective is to see how you organize your thoughts and implement major OO principles into your work. We will also assess your overall coding skills in the Java language. The end product must be a PLAYABLE GAME. This does not mean all the rules need to be perfect, but the general gameplay should be implemented.

This should be a command-line program, you will be playing against a very rudimentary poker robot that you will write. THE ROBOT DOES NOT NEED TO BE GOOD AT POKER. It can randomly select moves (i.e. always calls but never raises), but it must make those moves within the allowed rules of the game. If you want to make it fun and are daring, you can make multiple poker bots to play against.

The particular game we want to play is called Tournament Style where everyone starts with the same amount of chips with the value of $10,000. After each game, the chips go to the winner.

A description of the game can be found here.

http://www.pokerlistings.com/poker-rules-texas-holdem

The betting style we want to use is No-Limit

http://www.pokerlistings.com/texas-holdem-betting-rules

Though the rules can get involved, the available actions available are quite simple. The command line should show whose move it is and allow you to select one of these four:

(1) Fold (2) Check (3) Raise (4) Call

If raising you should indicate how much. Each raise needs to be validated against a set of rules, and feedback is given when the raise is inappropriate. At the appropriate times, we should show the flop, turn, and then the river. After the game ends the program should declare a winner and ask for a new game. As the program runs, the total bank accounts of the two players should be shown and updated. Each player starts with $1000.

## Problem solving
The steps taken are:
1. Understanding the Game, its rules and identifying entities
2. Draft an initial blueprint
3. Study the state of art
4. review the initial draft, perform the required changes and come with a unique solution
5. Estimate the cost of performing the solution
6. Given the time constraint, define an **MVP** (Minimum Value Product) That can be deliver within the allocated time
7. Implement the solution with test coverage
8. Define documentation

Working on a distributed environment requires special attention to the documentation and code readability. This exercise has been performed in such fashion

## Technical solution
### UML
### Why visitor pattern

## Extra steps
### Further level of abstraction
ALl card games present a repetitive structure. Further level of abstraction can help build a framework where almost every game can be implemented. For this exercise building such structure is overengineering but the components have been defined so it can be easily adapted to the metioned framework:
1. Define the players
2. Setup game (shuffle, placing cards on the table..)
3. Loop rounds until end of the game (limited rounds like poker, a winner has been found like blakcjack...)
    1. Loop players
        1. players perform action
4. define winner
 
### AI
It has been decided to 
