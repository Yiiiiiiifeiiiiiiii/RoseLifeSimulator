package rose.cheny16.projectfragment.models

import android.content.Context
import rose.cheny16.projectfragment.R

class RandomEvent1(context: Context) : Event(context) {
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

    override var choice1: Word = Word("choice", "1. My pleasure");

    override var choice2: Word = Word("choice", "2. Errr... \nSorry I must review for my test now");

    override var eventName = "RandomEvent1"

    override lateinit var ite0: Iterator<Word>

    override lateinit var ite1: Iterator<Word>

    override lateinit var ite2: Iterator<Word>

    init{
        textContent0.add(Word("Girl", "Heyy! Can you give a favor?"));
        textContent0.add(Word("Girl", "Can you go to my dorm room and bring my laptop here?"));
        textContent0.add(Word("Girl", "I'm in middle of something!"))

        textContent0.add(choice1)
        textContent0.add(choice2)


        ite0 = textContent0.iterator()
        ite1 = textContent1.iterator()
        ite2 = textContent2.iterator()
        sta.actionPoint = sta.actionPoint - 10;



    }

    override fun makeChoice(c: Int) {
        state = c
        if(c == 1){
            sta.GirlFriendR = sta.GirlFriendR + 3
            sta.actionPoint = sta.actionPoint - 10
            textContent0.add(Word("Girl", "Thanks! I love you!"))
        }else{
            sta.GirlFriendR = sta.GirlFriendR - 3
            sta.GPA = sta.GPA + 0.3f
            textContent0.add(Word("Girl", "Okay... \nI will find someone else"))
        }
        textContent0.add(Word("You", "Some status changed"))
    }





}