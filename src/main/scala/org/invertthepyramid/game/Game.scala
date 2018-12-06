package org.invertthepyramid.game
import org.invertthepyramid.dragon.Dragon
import org.invertthepyramid.players.ZombieNinjaRobotSchoolGirl

object Game {

  def eat(dragon: Dragon, thing: AnyRef): Dragon = ???
  def regurgitate(dragon: Dragon, thing: AnyRef): Dragon = ???
  def foreachStomachItem(dragon: Dragon, fn: AnyRef => Unit) = ???


  //reduce the dragon's chest hitpoints and add one to the number of times the sword is used
  def attackDragonInChestWithDiscombobulatingSwordHeldInFirstArm(dragon: Dragon, zombieNinjaRobotSchoolGirl: ZombieNinjaRobotSchoolGirl): (Dragon, ZombieNinjaRobotSchoolGirl) = ???


}
