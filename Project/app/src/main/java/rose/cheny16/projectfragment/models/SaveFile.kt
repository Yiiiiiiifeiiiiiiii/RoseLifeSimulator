package rose.cheny16.projectfragment.models

class SaveFile(
    var relationship: Relationship? = null,
    var health: Int? = null,
    var happiness: Int? = null,
    var actionPt: Int? = null,
    var playerName: String? = null,
    var gameTime: String? = null
) {


    fun getSaveString(i: Int): String {

        return "save " + i + ": \n" +
               "     " + playerName + "\n" +
               "     " + gameTime


    }
}