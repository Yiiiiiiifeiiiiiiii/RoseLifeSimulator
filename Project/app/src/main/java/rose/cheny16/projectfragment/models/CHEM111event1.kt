package rose.cheny16.projectfragment.models

import android.content.Context
import rose.cheny16.projectfragment.R

class CHEM111event1(context: Context) : Event(context) {
    override var place: Int = R.drawable.classroom

    override var place2: Int = R.drawable.classroom


    var con = context as Status.IgetStatus
    var sta = con.getStatus()
    override var state = 0

    override var textContent0: ArrayList<Word>
            = ArrayList()

    override var textContent1: ArrayList<Word>
            =ArrayList()

    override var textContent2: ArrayList<Word>
            =ArrayList()

    override var choice1: Word = Word("choice", "A: Green and Blue")

    override var choice2: Word = Word("choice", "B: Red and Green")

    override var eventName = "CHEM111event1"

    override lateinit var ite0: Iterator<Word>

    override lateinit var ite1: Iterator<Word>

    override lateinit var ite2: Iterator<Word>

    init{
        textContent0.add(Word("You", "This is a lab…"))
        textContent0.add(Word("You", "Which 2 solutions you want to put together?"))

        textContent0.add(choice1)
        textContent0.add(choice2)

        ite0 = textContent0.iterator()
        ite1 = textContent1.iterator()
        ite2 = textContent2.iterator()

        sta.happiness = sta.happiness + 1

        sta.actionPoint = sta.actionPoint - 10


    }

    override fun makeChoice(c: Int) {
        state = c
    }
}