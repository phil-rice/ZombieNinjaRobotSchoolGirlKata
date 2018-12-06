package org.invertthepyramid.dragon
import org.invertthepyramid.game.Hitpoints

case class Dragon (chest: Chest, leg: List[Leg], head: Head)
case class Chest(stomach: Stomach, lungs: Lungs, heart: Heart, hitpoints: Hitpoints)
case class Leg(claws: Claw,position: Int)
case class Claw(sharpness: Int, damage: Int, hitpoints: Hitpoints)
case class Stomach(contents: List[AnyRef])
case class Lungs(capacity: Int, hitpoints: Hitpoints)
case class Heart(beatsPerMinute: Int, volumn: Int, hitpoints: Hitpoints)
case class Head(teeth: List[Tooth], hitpoints: Hitpoints)
case class Tooth(size: Int)

