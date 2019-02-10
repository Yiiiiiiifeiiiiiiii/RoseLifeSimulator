package rose.cheny16.projectfragment.models

import android.content.Context
import rose.cheny16.projectfragment.R

class CHEM111event2(context: Context) : Event(context) {
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

    override var choice1: Word = Word("choice", "A: talk to professor about your questions")

    override var choice2: Word = Word("choice", "B: sleep")

    override var eventName = "CHEM111event2"

    override lateinit var ite0: Iterator<Word>

    override lateinit var ite1: Iterator<Word>

    override lateinit var ite2: Iterator<Word>

    init{
        textContent0.add(Word("You", "This class we did some class activity…"))
        textContent0.add(Word("You", "You want to:"))

        textContent0.add(choice1)
        textContent0.add(choice2)

        textContent1.add(Word("Dr. Weatherman", "Hey. What questions do you have?"))
        textContent1.add(Word("You", "Well, I am wondering…"))

        textContent2.add(Word("You", "zzzZZZ......"))

        ite0 = textContent0.iterator()
        ite1 = textContent1.iterator()
        ite2 = textContent2.iterator()

        sta.happiness = sta.happiness + 1

        sta.actionPoint = sta.actionPoint - 10


    }

    override fun makeChoice(c: Int) {
        state = c
        if(c == 1){
            sta.CHEM111GPA = sta.CHEM111GPA + 0.1f
            sta.GPA = (sta.GPA * 5 + 0.1f) / 5
        }else{
            sta.CHEM111GPA = sta.CHEM111GPA - 0.1f
            sta.GPA = (sta.GPA * 5 - 0.1f) / 5
            sta.happiness = sta.happiness + 1
        }
    }
}