package rose.cheny16.projectfragment.models

import android.content.Context
import rose.cheny16.projectfragment.R

class JP111event2(context: Context) : Event(context) {
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

    override var choice1: Word = Word("choice", "A: Tokyo")

    override var choice2: Word = Word("choice", "B: Kyoto")

    override var eventName = "JP111event2"

    override lateinit var ite0: Iterator<Word>

    override lateinit var ite1: Iterator<Word>

    override lateinit var ite2: Iterator<Word>

    init{

        textContent0.add(Word("Dr. Hirotani", "Surprise!"))
        textContent0.add(Word("Dr. Hirotani", "Simple quiz question!"))
        textContent0.add(Word("Dr. Hirotani", "Where is Fuji mountain located at?"))
        textContent0.add(Word("You", "I'm not sure. Let me guess..."))

        textContent0.add(choice1)
        textContent0.add(choice2)

        textContent1.add(Word("Dr. Hirotani", "Congratulations!"))
        textContent1.add(Word("You", "Yeah!"))
        textContent1.add(Word("You", "Some status changed"))

        textContent2.add(Word("Dr. Hirotani", "You are wrong..."))
        textContent2.add(Word("You", "Some status changed"))

        ite0 = textContent0.iterator()
        ite1 = textContent1.iterator()
        ite2 = textContent2.iterator()

        sta.actionPoint = sta.actionPoint - 10


    }

    override fun makeChoice(c: Int) {
        state = c
        if(c == 1){
            sta.JP111GPA = sta.JP111GPA + 0.1f
            sta.GPA = (sta.GPA * 4 + 0.1f) / 4
            sta.happiness = sta.happiness + 5
        }else{
            sta.JP111GPA = sta.JP111GPA - 0.1f
            sta.GPA = (sta.GPA * 4 - 0.1f) / 4
        }
    }
}