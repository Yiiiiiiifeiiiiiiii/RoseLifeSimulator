package rose.cheny16.projectfragment.models

import android.content.Context

class drBevent1 (context: Context): Event(context) {
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

    override var eventName = "drBevent1"

    override lateinit var ite0: Iterator<Word>

    override lateinit var ite1: Iterator<Word>

    override lateinit var ite2: Iterator<Word>

    init{
        textContent0.add(Word("Dr. Boutell", "Hi. I’m Dr.Boutell. I can teach a lot of CSSE courses. "));
        textContent0.add(Word("Dr. Boutell", "You will be probably with me sometime in the next couples of years."));
        textContent0.add(Word("Dr. Boutell", "And tell you a secret. I’m the game master of this game, too."));
        textContent0.add(Word("Dr. Boutell", "Come and draw a card from me. You will get a random present."));
        textContent0.add(Word("Dr. Boutell", "And if you come here more  than 10 times, I’ll tell you a secret. "));

        ite0 = textContent0.iterator()
        ite1 = textContent1.iterator()
        ite2 = textContent2.iterator()
        sta.actionPoint = sta.actionPoint - 10;



    }

    override fun makeChoice(c: Int){

    }


}