package rose.cheny16.projectfragment.models

import android.content.Context
import rose.cheny16.projectfragment.MainActivity

class BobAtClub1(context: Context): Event(context) {
    var con = context as Status.IgetStatus

    override var textContent0: ArrayList<Word>
            = ArrayList()

    override var textContent1: ArrayList<Word>
            =ArrayList()

    override var textContent2: ArrayList<Word>
            =ArrayList()

    override var choice1: Word = Word("choice", "");

    override var choice2: Word = Word("choice", "");

    override var eventName = "BobAtClub1"

    override lateinit var ite0: Iterator<Word>

    override lateinit var ite1: Iterator<Word>

    override lateinit var ite2: Iterator<Word>

    init{
        textContent0.add(Word("Bob", "Hey you come!"));
        textContent0.add(Word("Bob", "We are making this nice robot, join us! "));
        textContent0.add(Word("You", "(Programming...)"));
        textContent0.add(Word("You", "I'm " + con.getStatus().name + " . Nice to meet you Bob."  ));

        ite0 = textContent0.iterator()
        ite1 = textContent1.iterator()
        ite2 = textContent2.iterator()



    }


}