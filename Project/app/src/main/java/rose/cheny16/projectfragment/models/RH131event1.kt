package rose.cheny16.projectfragment.models

import android.content.Context
import rose.cheny16.projectfragment.R

class RH131event1(context: Context) : Event(context) {
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

    override var choice1: Word = Word("choice", "")

    override var choice2: Word = Word("choice", "")

    override var eventName = "RH131event1"

    override lateinit var ite0: Iterator<Word>

    override lateinit var ite1: Iterator<Word>

    override lateinit var ite2: Iterator<Word>

    init{
        textContent0.add(Word("You", "This class we watched a movie…"))

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