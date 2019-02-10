package rose.cheny16.projectfragment.models

import android.content.Context
import rose.cheny16.projectfragment.R

class GirlfriendEvent2(context: Context) : Event(context) {
    override var place: Int = R.drawable.whitechapel

    override var place2: Int = R.drawable.subway


    var con = context as Status.IgetStatus
    var sta = con.getStatus()
    override var state = 0;

    override var textContent0: ArrayList<Word>
            = ArrayList()

    override var textContent1: ArrayList<Word>
            =ArrayList()

    override var textContent2: ArrayList<Word>
            =ArrayList()

    override var choice1: Word = Word("choice", "1. I want to know your preference");

    override var choice2: Word = Word("choice", "2. Just lazy to build my own one");

    override var eventName = "GirlfriendEvent2"

    override lateinit var ite0: Iterator<Word>

    override lateinit var ite1: Iterator<Word>

    override lateinit var ite2: Iterator<Word>

    init{
        textContent0.add(Word("Girl", "Hey remember me?"));
        textContent0.add(Word("You", "Of course Tina."));
        textContent0.add(Word("Girl", "But I forget about you. Have we met anywhere?"));
        textContent0.add(Word("You", "…I’m hurt."));
        textContent0.add(Word("Girl", "Hahahaha. I’m just kidding!"));
        textContent0.add(Word("You", "Tina you bad girl."));
        textContent0.add(Word("Girl", "Thank you and shall we go to Subway! I can’t wait!"));
        textContent0.add(Word("You", "Sure let’s go."));
        textContent0.add(Word("switch", ""))
        textContent0.add(Word("You", "(Arrived at Subway)"));
        textContent0.add(Word("Girl", "Nice. I’ll order meetball + lettuce + tomato + cheese + barbecue saurce."));
        textContent0.add(Word("You", "Same. "));
        textContent0.add(Word("Girl", "Why?"));
        textContent0.add(choice1)
        textContent0.add(choice2)
        textContent1.add(Word("Girl", "Oh, sweet…"));

        textContent2.add(Word("Girl", "…OK."));

        ite0 = textContent0.iterator()
        ite1 = textContent1.iterator()
        ite2 = textContent2.iterator()
        sta.actionPoint = sta.actionPoint - 10;


    }

    override fun makeChoice(c: Int) {
        state = c
        if(c == 1){
            sta.GirlFriendR = sta.GirlFriendR + 5
        }else{
            sta.GirlFriendR = sta.GirlFriendR - 5
        }
    }





}