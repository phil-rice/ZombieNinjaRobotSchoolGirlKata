package org.invertthepyramid.dragon
import org.invertthepyramid.game.Hitpoints
import org.invertthepyramid.optics.Lens

case class Dragon(chest: Chest, leg: List[Leg], head: Head)
object Dragon {
  def chestL = Lens[Dragon, Chest](_.chest, (d, c) => d.copy(chest = c))
  def stomachContentsL = chestL andThen Chest.stomachL andThen Stomach.contentsL
}
case class Chest(stomach: Stomach, lungs: Lungs, heart: Heart, hitpoints: Hitpoints)
object Chest {
  def stomachL = Lens[Chest, Stomach](_.stomach, (c, s) => c.copy(stomach = s))
}
case class Leg(claws: Claw, position: Int)
case class Claw(sharpness: Int, damage: Int, hitpoints: Hitpoints)
case class Stomach(contents: List[AnyRef])
object Stomach {
  def contentsL = Lens[Stomach, List[AnyRef]](_.contents, (s, l) => s.copy(contents = l))
}
case class Lungs(capacity: Int, hitpoints: Hitpoints)
case class Heart(beatsPerMinute: Int, volumn: Int, hitpoints: Hitpoints)
case class Head(teeth: List[Tooth], hitpoints: Hitpoints)
case class Tooth(size: Int)



