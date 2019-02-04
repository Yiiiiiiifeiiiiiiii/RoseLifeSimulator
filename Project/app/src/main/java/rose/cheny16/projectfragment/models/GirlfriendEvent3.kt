package rose.cheny16.projectfragment.models

import android.content.Context

class GirlfriendEvent3(context: Context) : Event(context) {
    var con = context as Status.IgetStatus
    var sta = con.getStatus()
    override var state = 0;

    override var textContent0: ArrayList<Word>
            = ArrayList()

    override var textContent1: ArrayList<Word>
            =ArrayList()

    override var textContent2: ArrayList<Word>
            =ArrayList()

    override var choice1: Word = Word("choice", "1. Sure");

    override var choice2: Word = Word("choice", "2. No");

    override var eventName = "GirlfriendEvent3"

    override lateinit var ite0: Iterator<Word>

    override lateinit var ite1: Iterator<Word>

    override lateinit var ite2: Iterator<Word>

    init{
        textContent0.add(Word("You", "Hey Tina, Let’s go to chick ’fila!"));
        textContent0.add(Word("Girl", "Sure. I love chick ‘fila."));
        textContent0.add(Word("You", "(driving Tina to chick ‘fila…)"));
        textContent0.add(Word("Girl", "Very delicious. Have you ever tried putting mayo in the burger?"));
        textContent0.add(Word("You", "I haven’t tried that."));
        textContent0.add(Word("Girl", "Try it!"));
        textContent0.add(choice1)
        textContent0.add(choice2)
        textContent1.add(Word("You", "Sure why not! "));
        textContent1.add(Word("Girl", "Like it?"));
        textContent1.add(Word("You", "Yes it’s delicious! Tina you are a genius.  "));
        textContent1.add(Word("Girl", "True!"));

        textContent2.add(Word("You", "Well…I don’t like putting strange things in my burger. "));
        textContent2.add(Word("Girl", "…OK. Nevermind"));

        ite0 = textContent0.iterator()
        ite1 = textContent1.iterator()
        ite2 = textContent2.iterator()



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