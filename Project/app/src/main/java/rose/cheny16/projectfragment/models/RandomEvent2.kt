package rose.cheny16.projectfragment.models

import android.content.Context
import rose.cheny16.projectfragment.R

class RandomEvent2(context: Context) : Event(context) {
    override var place: Int = R.drawable.whitechapel

    override var place2: Int = R.drawable.whitechapel

    var con = context as Status.IgetStatus
    var sta = con.getStatus()
    override var state = 0;

    override var textContent0: ArrayList<Word>
            = ArrayList()

    override var textContent1: ArrayList<Word>
            =ArrayList()

    override var textContent2: ArrayList<Word>
            =ArrayList()

    override var choice1: Word = Word("choice", "I love sports");

    override var choice2: Word = Word("choice", "Sorry I must finish homework");

    override var eventName = "RandomEvent2"

    override lateinit var ite0: Iterator<Word>

    override lateinit var ite1: Iterator<Word>

    override lateinit var ite2: Iterator<Word>

    init{
        textContent0.add(Word("Bob", "${sta.name}! Go to SRC with me! We need some sports!"));


        textContent0.add(choice1)
        textContent0.add(choice2)

        textContent0.add(Word("You", "Some status changed"))



        ite0 = textContent0.iterator()
        ite1 = textContent1.iterator()
        ite2 = textContent2.iterator()

    }

    override fun makeChoice(c: Int) {
        state = c
        if(c == 1){
            sta.happiness = sta.happiness + 30
            sta.actionPoint = sta.actionPoint - 20
            sta.BobR = sta.BobR + 5
            textContent0.add(Word("Bob", "Sports is the best way makeing you happy healthy"))

        }else{
            sta.BobR = sta.BobR - 5
            sta.GPA = sta.GPA + 0.05f
            textContent0.add(Word("Bob", "Fine, goodbye nerd."))
        }
        }





}