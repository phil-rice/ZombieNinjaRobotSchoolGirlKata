package org.invertthepyramid.dragon
import org.invertthepyramid.game.Hitpoints
import org.invertthepyramid.optics.Lens

case class Dragon( body: Body, head: Head)
object Dragon {
  def bodyL: Lens[Dragon, Body] = Lens(_.body, (d, b) => d.copy(body=b))
  def stomachContentsL: Lens[Dragon, List[AnyRef]] = ???
}
case class Body(chest: Chest, leg: List[Leg])
object Body {
  def chestL: Lens[Chest, Stomach] = ???
}
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



