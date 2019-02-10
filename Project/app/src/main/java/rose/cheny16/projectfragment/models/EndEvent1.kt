package rose.cheny16.projectfragment.models

import android.content.Context
import rose.cheny16.projectfragment.R

class EndEvent1(context: Context) : Event(context) {
    override var place2: Int = R.drawable.campus

    override var place: Int = R.drawable.campus

    var con = context as Status.IgetStatus
    var sta = con.getStatus()
    override var state = 0

    override var textContent0: ArrayList<Word>
            = ArrayList()

    override var textContent1: ArrayList<Word>
            =ArrayList()

    override var textContent2: ArrayList<Word>
            =ArrayList()

    override var choice1: Word = Word("choice", "Skip")

    override var choice2: Word = Word("choice", "Just do it!!!")

    override var eventName = "FinalExamEvent1"

    override lateinit var ite0: Iterator<Word>

    override lateinit var ite1: Iterator<Word>

    override lateinit var ite2: Iterator<Word>

    init{
        textContent0.add(Word("Dr. Boutell", "You survived this term. Congratulations! "))
        textContent0.add(Word("Dr. Boutell", "Now your GPA is ${sta.GPA}"))
        if(sta.GPA >= 4){
            textContent0.add(Word("Dr. Boutell", "Amazing work!!! How can you do that? \nAre you an alien?"))

        }else if (sta.GPA >= 3.5){
            textContent0.add(Word("Dr. Boutell", "Great work! I am so proud of you"))
        }else if (sta.GPA < 2.5){
            textContent0.add(Word("Dr. Boutell", "Maybe next time try harder?"))
        }else{
            textContent0.add(Word("Dr. Boutell", "Not bad. But I believe you can do better!"))
        }



        ite0 = textContent0.iterator()
        ite1 = textContent1.iterator()
        ite2 = textContent2.iterator()



    }

    override fun makeChoice(c: Int) {
        state = c
    }
}