package rose.cheny16.projectfragment.models

import android.content.Context
import rose.cheny16.projectfragment.R

class RH131event2(context: Context) : Event(context) {
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

    override var choice1: Word = Word("choice", "Write anyway")

    override var choice2: Word = Word("choice", "Give up")

    override var eventName = "RH131event2"

    override lateinit var ite0: Iterator<Word>

    override lateinit var ite1: Iterator<Word>

    override lateinit var ite2: Iterator<Word>

    init{
        textContent0.add(Word("Dr. Carvill", "Let's write an in-class essay."))
        textContent0.add(Word("You", "I do not know what to write..."))
        textContent0.add(Word("You", "It's not much point. Should I just give up?"))

        textContent0.add(choice1)
        textContent0.add(choice2)

        textContent1.add(Word("You", "Okay. Let me try."))
        textContent1.add(Word("You", "Some status changed"))
        textContent2.add(Word("You", "That's fine!"))
        textContent2.add(Word("Dr. Carvill", "You should write it!"))
        textContent2.add(Word("You", "Some status changed"))

        ite0 = textContent0.iterator()
        ite1 = textContent1.iterator()
        ite2 = textContent2.iterator()

        sta.actionPoint = sta.actionPoint - 10

    }

    override fun makeChoice(c: Int) {
        state = c
        if(c == 1){
            sta.RH131GPA = sta.RH131GPA + 0.1f
            sta.GPA = (sta.GPA * 4 + 0.1f) / 4
        }else{
            sta.RH131GPA = sta.RH131GPA - 0.3f
            sta.GPA = (sta.GPA * 4 - 0.3f) / 4
        }
    }
}