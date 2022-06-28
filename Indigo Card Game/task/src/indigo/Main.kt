package indigo

fun main() {
    val deck = Deck()
    val table = deck.getHand(Hand.TABLE_SIZE)
    val player = Player(deck.getHand(Hand.DEAL_SIZE), "indigo.Player")
    val computer = Player(deck.getHand(Hand.DEAL_SIZE))
    var isPlayerTurn: Boolean
    val playerWentFirst: Boolean
    var exit = false

    println("Indigo Card Game")
    isPlayerTurn = getPlayerTurn().also { playerWentFirst = it }
    println("Initial cards on the table: " + table.cards())

    while (!exit) {
        printCardsOnTable(table)
        if (isEmpty(player.hand, computer.hand, deck)) break
        if (isPlayerTurn) exit = playerTurn(player, computer, table) else computerTurn(computer, player, table)
        isPlayerTurn = !isPlayerTurn
    }
    if (!exit) player.finalScore(playerWentFirst, computer, table)
    println("Game Over")
}

private fun getPlayerTurn(): Boolean {
    while (true) {
        when (getString("Play first?")) {
            "yes" -> return true
            "no" -> return false
        }
    }
}

private fun printCardsOnTable(table: Hand) {
    when {
        table.isEmpty() -> println("\nNo cards on the table")
        else -> println("\n" + table.size() + " cards on the table, and the top card is " + table.topCard())
    }
}

private fun isEmpty(player: Hand, computer: Hand, deck: Deck): Boolean {
    if (deck.isEmpty() && player.isEmpty() && computer.isEmpty()) return true
    if (player.isEmpty() && computer.isEmpty()) {
        player.add(deck.getCards(Hand.DEAL_SIZE))
        computer.add(deck.getCards(Hand.DEAL_SIZE))
    }
    return false
}

private fun playerTurn(player: Player, computer: Player, table: Hand): Boolean {
    println("Cards in hand: " + player.hand.cardsNumbered())

    while (true) {
        val action = getString("Choose a card to play (1-${player.hand.size()}):")
        if (action == "exit") return true
        val card = player.hand.take(action.toIntOrNull() ?: continue) ?: continue
        if (isWin(player, card, table)) player.printScore(computer)
        return false
    }
}

private fun computerTurn(computer: Player, player: Player, table: Hand) {
    val card: String by lazy { computer.hand.bestMove(table.topCard()) }

    println(computer.hand.cards())
    println("Computer plays $card")
    if (isWin(computer, card, table)) player.printScore(computer)
}

private fun isWin(player: Player, card: String, table: Hand): Boolean {
    return table.isWin(card).also { isWin ->
        table.add(card)
        if (isWin) player.win(table)
    }
}

private fun getString(message: String): String {
    println(message)
    return readln()
}

class Deck {
    private val deck = ArrayDeque<String>()

    init {
        val ranks = "A 2 3 4 5 6 7 8 9 10 J Q K".split(" ")
        val suits = "♦ ♥ ♠ ♣".split(" ")

        suits.flatMap { suit -> ranks.map { rank -> rank + suit } }.shuffled().toCollection(deck)
    }

    fun getHand(num: Int) = Hand.create(getCards(num))

    fun getCards(num: Int) = if (deck.size >= num) (1..num).map { deck.removeLast() } else emptyList()

    fun isEmpty() = deck.isEmpty()
}

class Hand {
    private val hand = ArrayDeque<String>()

    fun add(cards: List<String>) = cards.toCollection(hand)

    fun add(card: String) = hand.add(card)

    fun take(card: Int) = if (card in 1..hand.size) hand.removeAt(card - 1) else null

    fun reset() = hand.clear()

    fun size() = hand.size

    fun topCard() = if (hand.isNotEmpty()) hand.last() else ""

    fun cards() = hand.joinToString(" ")

    fun cardsNumbered() = hand.mapIndexed { index, card -> "${index + 1})$card" }.joinToString(" ")

    fun isEmpty() = hand.isEmpty()

    fun isWin(playerCard: String, topCard: String = topCard()) = topCard.isNotEmpty()
            && (topCard.dropLast(1) == playerCard.dropLast(1) || topCard.last() == playerCard.last())

    fun sumPoints() = hand.map { if (points.contains(it.dropLast(1))) 1 else 0 }.sum()

    fun bestMove(topCard: String) = when {
        hand.size == 1 -> hand.first()
        topCard.isEmpty() -> worstCard()
        else -> bestCard(topCard)
    }.also { hand.remove(it) }

    private fun worstCard(): String {
        val suits = hand.filter { card -> hand.count { card.last() == it.last() } > 1 }
        val ranks: List<String> by lazy { hand.filter { card -> hand.count { card.first() == it.first() } > 1 } }

        return when {
            suits.isNotEmpty() -> selectCard(suits, false)
            ranks.isNotEmpty() -> selectCard(ranks, false)
            else -> selectCard(hand, false)
        }
    }

    private fun bestCard(topCard: String): String {
        val suits = hand.filter { topCard.last() == it.last() }
        val ranks: List<String> by lazy { hand.filter { topCard.first() == it.first() } }

        return when {
            suits.size > 1 -> selectCard(suits, true)
            ranks.size > 1 -> selectCard(ranks, true)
            suits.isNotEmpty() || ranks.isNotEmpty() -> selectCard(suits + ranks, true)
            else -> worstCard()
        }
    }

    companion object {
        const val DEAL_SIZE = 6
        const val TABLE_SIZE = 4
        private val points = "A 10 J Q K".split(" ")

        fun create(cards: List<String>) = Hand().also { it.add(cards) }

        private fun selectCard(cards: List<String>, selectBest: Boolean): String {
            val filterCards = if (selectBest) cards::filter else cards::filterNot
            val selected = filterCards { points.contains(it.dropLast(1)) }

            return if (selected.isNotEmpty()) selected.random() else cards.random()
        }
    }
}

class Player(val hand: Hand, private val name: String = "Computer") {
    private var score = 0
    private var cards = 0

    fun win(table: Hand) {
        score += table.sumPoints()
        cards += table.size()
        table.reset()
        lastWinner = this
        println("$name wins cards")
    }

    fun printScore(computer: Player) {
        println("Score: $name $score - " + computer.name + " " + computer.score)
        println("Cards: $name $cards - " + computer.name + " " + computer.cards)
    }

    fun finalScore(playerWentFirst: Boolean, computer: Player, table: Hand) {
        if (!table.isEmpty()) {
            val cardsWinner = lastWinner ?: if (playerWentFirst) this else computer

            cardsWinner.score += table.sumPoints()
            cardsWinner.cards += table.size()
        }
        val playerGetsPoints = cards > computer.cards || (cards == computer.cards && playerWentFirst)

        if (playerGetsPoints) score += 3 else computer.score += 3
        printScore(computer)
    }

    companion object {
        private var lastWinner: Player? = null
    }
}