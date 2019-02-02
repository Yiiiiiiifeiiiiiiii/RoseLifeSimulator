package rose.cheny16.projectfragment.models

data class Status(
    var CSSE120GPA: Float
    ,var MA113GPA: Float
    ,var CLSK100GPA: Float
,var JP111GPA: Float
,var CHEM111GPA: Float
, var name: String
, var happiness: Int
, var health: Int
    , var actionPoint: Int
, var BobR: Int      //Bob's relation
, var GirlFriendR: Int // GF's relation
, var DrBR: Int, // Dr.B's relation
    var BobEventProgress: Int //Bob's event progress
, var GirlFriendEventProgress: Int //GF's event progress
    , var DrBEventProgress: Int//DrB's event progress
, var Day: Int
    ) {
}