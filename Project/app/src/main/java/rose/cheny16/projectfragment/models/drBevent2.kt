package rose.cheny16.projectfragment.models

import android.content.Context
import rose.cheny16.projectfragment.R

class drBevent2 (context: Context): Event(context) {
    override var place: Int = R.drawable.food

    override var place2: Int = R.drawable.food


    var con = context as Status.IgetStatus
    var sta = con.getStatus()
    override var state = 0;
    override var textContent0: ArrayList<Word>
            = ArrayList()

    override var textContent1: ArrayList<Word>
            =ArrayList()

    override var textContent2: ArrayList<Word>
            =ArrayList()

    override var choice1: Word = Word("choice", "");

    override var choice2: Word = Word("choice", "");

    override var eventName = "drBevent2"

    override lateinit var ite0: Iterator<Word>

    override lateinit var ite1: Iterator<Word>

    override lateinit var ite2: Iterator<Word>

    init{
        textContent0.add(Word("Dr. Boutell", "How can I help you today?"))
        textContent0.add(Word("You", "drawing cards..."))
        textContent0.add(Word("You", "Some status changed"))
        sta.CSSE120GPA = sta.CSSE120GPA + 0.2f
        sta.GPA = (sta.GPA * 4 + 0.2f) / 4
        sta.happiness = sta.happiness + 5
        sta.actionPoint = sta.actionPoint - 10

        ite0 = textContent0.iterator()
        ite1 = textContent1.iterator()
        ite2 = textContent2.iterator()


    }

    override fun makeChoice(c: Int) {
        state = c
    }



}