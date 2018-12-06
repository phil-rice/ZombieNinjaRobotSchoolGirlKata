package org.invertthepyramid.dragon
import org.invertthepyramid.game.Hitpoints
import org.invertthepyramid.optics.Lens

case class Dragon( head: Head)
object Dragon {
  def chestL: Lens[Dragon, Chest] = ???
  def stomachContentsL: Lens[Dragon, List[AnyRef]] = ???
}
case class Body(chest: Chest, leg: List[Leg])
case class Chest(stomach: Stomach, lungs: Lungs, heart: Heart, hitpoints: Hitpoints)
object Chest {
  def stomachL: Lens[Chest, Stomach] = ???
}
case class Leg(claws: Claw, position: Int)
case class Claw(sharpness: Int, damage: Int, hitpoints: Hitpoints)
case class Stomach(contents: List[AnyRef])
object Stomach {
  def contentsL: Lens[Stomach, List[AnyRef]] = ???
}
case class Lungs(capacity: Int, hitpoints: Hitpoints)
case class Heart(beatsPerMinute: Int, volumn: Int, hitpoints: Hitpoints)
case class Head(teeth: List[Tooth], hitpoints: Hitpoints)
case class Tooth(size: Int)



