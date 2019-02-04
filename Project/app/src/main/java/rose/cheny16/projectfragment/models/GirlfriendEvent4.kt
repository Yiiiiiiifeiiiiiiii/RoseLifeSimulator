package rose.cheny16.projectfragment.models

import android.content.Context

class GirlfriendEvent4(context: Context) : Event(context) {
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

    override var eventName = "GirlfriendEvent4"

    override lateinit var ite0: Iterator<Word>

    override lateinit var ite1: Iterator<Word>

    override lateinit var ite2: Iterator<Word>

    init{
        textContent0.add(Word("You", "It’s been a while dating with Tina. I should ask her to be my girlfriend."));
        textContent0.add(Word("You", "......"))
        if(sta.GirlFriendR >= 10){
            textContent0.add(Word("You", "Tina Agreed! You are now in relationship!"))
            sta.GirlFriendR = sta.GirlFriendR + 1000
        }else{
            textContent0.add(Word("Girl", "I thought we are friends…"))
            sta.GirlFriendR = sta.GirlFriendR -1000
        }

        ite0 = textContent0.iterator()
        ite1 = textContent1.iterator()
        ite2 = textContent2.iterator()

        sta.actionPoint = sta.actionPoint - 10;

    }

    override fun makeChoice(c: Int) {
        state = c

    }





}