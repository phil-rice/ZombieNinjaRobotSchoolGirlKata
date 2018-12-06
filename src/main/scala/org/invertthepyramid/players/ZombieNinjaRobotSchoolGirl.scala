package org.invertthepyramid.players

import org.invertthepyramid.game.Hitpoints

import scala.concurrent.duration.Duration

case class ZombieNinjaRobotSchoolGirl(name: String, address: Address, health: Health, inventory: List[Item], arms: (Arm, Arm), legs: (Leg, Leg), appetite: Int, brain: Brain)
case class Address(line1: String, line2: String, city: String, postcode: String)
case class Health(hitpoint: Hitpoints, vitality: Vitality, timeSinceLastAteBrain: Duration)

trait Item
trait Weapon extends Item
case class DiscombobulatingSword(discombobulationFrequency: Int, damage: Int, timesUsed: Int ) extends Weapon
case class SwordOfBifuraction(length: Int) extends Weapon
case class Vitality(int: Int)

trait Location{
  def hitpoints: Hitpoints
}
case class Arm(cyberware: List[Cyberware], hitpoints: Hitpoints)
case class Leg(cyberware: List[Cyberware], hitpoints: Hitpoints)

trait Cyberware
case class BuiltInMinigun(roundsOfAmmo: Int) extends Cyberware
case class JumpingJacks(metresExtraJump: Int) extends Cyberware
case class Brain(iq: Int, eq: Int)


