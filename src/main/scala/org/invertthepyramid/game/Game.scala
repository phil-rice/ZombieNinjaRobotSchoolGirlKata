package org.invertthepyramid.game
import org.invertthepyramid.dragon.Dragon
import org.invertthepyramid.players.ZombieNinjaRobotSchoolGirl

object Game {


  def eat(dragon: Dragon, thing: AnyRef): Dragon = Dragon.stomachContentsL.transform(dragon, old => old :+ thing)
  def regurgitate(dragon: Dragon, thing: AnyRef): Dragon = Dragon.stomachContentsL.transform(dragon, old => old.filterNot(_ == thing))
  def foreachStomachItem(dragon: Dragon, fn: AnyRef => Unit) = Dragon.stomachContentsL.get(dragon).foreach(fn)


  //reduce the dragon's chest hitpoints and add one to the number of times the sword is used
  def attackDragonInChestWithDiscombobulatingSwordHeldInFirstArm(dragon: Dragon, zombieNinjaRobotSchoolGirl: ZombieNinjaRobotSchoolGirl): (Dragon, ZombieNinjaRobotSchoolGirl) = ???


}
