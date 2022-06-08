package indigo

import java.util.*
import kotlin.random.Random.Default.nextInt

enum class CardRank(val sign: String, val score: Int) {
    ACE("A", 1),
    TWO("2", 0),
    THREE("3", 0),
    FOUR("4", 0),
    FIVE("5", 0),
    SIX("6", 0),
    SEVEN("7", 0),
    EIGHT("8", 0),
    NINE("9", 0),
    TEN("10", 1),
    JACK("J", 1),
    QUEEN("Q", 1),
    KING("K", 1);
    companion object {
        override fun toString(): String = values().joinToString(" ") { it.sign }
    }
}

enum class CardSuit(val sign: Char){
    DIAMONDS('♦'),
    HEARTS('♥'),
    SPADES('♠'),
    CLUBS('♣');
    companion object {
        override fun toString(): String = values().joinToString(" ") { it.sign.toString() }
    }
}

class Deck {
    private val cards: MutableList<Card> = mutableListOf()
    val mainStack: Stack<Card> = Stack<Card>()
    constructor() {
        generateCards()
    }
    private fun generateCards() {
        for (suit in CardSuit.values()) {
            for (rank in CardRank.values()){
                cards.add(Card(rank,suit))
            }
        }
        shuffle()
    }
    fun reset() {
        cards.clear()
        mainStack.clear()
        generateCards()
    }
    fun collectRemainingCard() {
        mainStack.forEach { cards.add(it) }
        mainStack.clear()
    }
    fun shuffle() {
        val length = cards.size
        for (i in 0 until length) {
            val n: Int = nextInt(cards.size)
            val randomCard = cards[n]
            mainStack.push(randomCard)
            cards.remove(randomCard)
        }
    }
    fun getCards(n: Int): MutableList<Card> {
        val temp: MutableList<Card> = mutableListOf()
        for (i in 0 until n) {
            temp.add(mainStack.pop())
        }
        return temp
    }

    override fun toString(): String = cards.joinToString(" ") { it.toString() }
}

class Card(val rank: CardRank, val suit: CardSuit){
    override fun toString(): String = this.rank.sign + this.suit.sign
}

fun resetCommand(deck: Deck) {
    deck.reset()
    println("Card deck is reset.")
}

fun shuffleCommand(deck: Deck) {
    deck.collectRemainingCard()
    deck.shuffle()
    println("Card deck is shuffled.")
}
fun getCommand(deck: Deck) {
    println("Number of cards:")
    val input = readLine()!!
    try {
        val n = input.toInt()
        if (n in 1..52) {
            println(deck.getCards(n).joinToString(" "))
        }
        else {

            println("Invalid number of cards.")
        }
    } catch (e: NumberFormatException){ println("Invalid number of cards.")}
    catch (e: Exception) {
        println("The remaining cards are insufficient to meet the request.")
    }
}

fun menu() {
    val deck: Deck = Deck()
    while (true) {
        println("Choose an action (reset, shuffle, get, exit):")
        when(readLine()!!){
            "reset" -> resetCommand(deck)
            "shuffle" -> shuffleCommand(deck)
            "get" -> getCommand(deck)
            "exit" -> {
                println("Bye")
                return
            }
            else -> {
                println("Wrong action.")
            }
        }
    }
}

fun main() {
    //val allRanks = "A 2 3 4 5 6 7 8 9 10 J Q K"
    //val allSuits = "♦ ♥ ♠ ♣"
    //val allDeckCards = "A♠ 2♠ 3♠ 4♠ 5♠ 6♠ 7♠ 8♠ 9♠ 10♠ J♠ Q♠ K♠ A♥ 2♥ 3♥ 4♥ 5♥ 6♥ 7♥ 8♥ 9♥ 10♥ J♥ Q♥ K♥ A♦ 2♦ 3♦ 4♦ 5♦ 6♦ 7♦ 8♦ 9♦ 10♦ J♦ Q♦ K♦ A♣ 2♣ 3♣ 4♣ 5♣ 6♣ 7♣ 8♣ 9♣ 10♣ J♣ Q♣ K♣"
    menu()
}

