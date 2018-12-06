package org.invertthepyramid.game

import org.invertthepyramid.dragon._
import org.invertthepyramid.players.{Address, Arm, Brain, BuiltInMinigun, DiscombobulatingSword, Health, JumpingJacks, Vitality, ZombieNinjaRobotSchoolGirl, Leg => ZLeg}
import org.scalatest.{FlatSpec, Matchers}

import scala.concurrent.duration.Duration

trait DragonFixture {
  implicit def toHitpoints: Int => Hitpoints = Hitpoints.apply


  val dragon = Dragon(Body(Chest(Stomach(List()), Lungs(10, 10), Heart(10, 20, 30), 10), List(Leg(Claw(10, 20, 30), 1), Leg(Claw(10, 20, 30), 2))), Head(List(Tooth(1)), 10))
  val dragonHitInChest = Dragon(Body(Chest(Stomach(List()), Lungs(10, 10), Heart(10, 20, 30), -10), List(Leg(Claw(10, 20, 30), 1), Leg(Claw(10, 20, 30), 2))), Head(List(Tooth(1)), 10))
  val dragonEatenItem1 = Dragon(Body(Chest(Stomach(List("item1")), Lungs(10, 10), Heart(10, 20, 30), 10), List(Leg(Claw(10, 20, 30), 1), Leg(Claw(10, 20, 30), 2))), Head(List(Tooth(1)), 10))
  val dragonEatenItem1AndItem2 = Dragon(Body(Chest(Stomach(List("item1", "item2")), Lungs(10, 10), Heart(10, 20, 30), 10), List(Leg(Claw(10, 20, 30), 1), Leg(Claw(10, 20, 30), 2))), Head(List(Tooth(1)), 10))
  val felicity = ZombieNinjaRobotSchoolGirl("Felicity", address = Address("4 Prince Drive", "suburbia", "mega city 1", "1133AX"),
    inventory = List(DiscombobulatingSword(100, 20, 3)),
    arms = (Arm(List(BuiltInMinigun(10000)), 20), Arm(List(), 300)), legs = (ZLeg(List(JumpingJacks(10)), 20), ZLeg(List(JumpingJacks(10)), 40)),
    appetite = 10, health = Health(10, Vitality(10), Duration.fromNanos(1000)), brain = Brain(100, 100))

  val felicityHitsFourTimes = ZombieNinjaRobotSchoolGirl("Felicity", address = Address("4 Prince Drive", "suburbia", "mega city 1", "1133AX"),
    inventory = List(DiscombobulatingSword(100, 20, 4)),
    arms = (Arm(List(BuiltInMinigun(10000)), 20), Arm(List(), 300)), legs = (ZLeg(List(JumpingJacks(10)), 20), ZLeg(List(JumpingJacks(10)), 40)),
    appetite = 10, health = Health(10, Vitality(10), Duration.fromNanos(1000)), brain = Brain(100, 100))


}

class GameSpec extends FlatSpec with Matchers with DragonFixture {

  behavior of "Dragon"

  it should "eat things" in {
    Game.eat(dragon, "item1") shouldBe dragonEatenItem1
    Game.eat(dragonEatenItem1, "item2") shouldBe dragonEatenItem1AndItem2
  }

  it should "regurgitate things " in {
    Game.regurgitate(dragonEatenItem1AndItem2, "item2") shouldBe dragonEatenItem1
    Game.regurgitate(dragonEatenItem1, "item1") shouldBe dragon
  }

  it should "iterate over the stomach items" in {
    def iterate(dragon: Dragon): List[AnyRef] = {
      var list = List[AnyRef]()
      Game.foreachStomachItem(dragon, i => list = list :+ i)
      list
    }
    iterate(dragon) shouldBe List()
    iterate(dragonEatenItem1) shouldBe List("item1")
    iterate(dragonEatenItem1AndItem2) shouldBe List("item1", "item2")
  }

  behavior of "Attack"

  it should "reduce chest hitpoints and add one to the discombobulating sword usage" in {
    Game.attackDragonInChestWithDiscombobulatingSwordHeldInFirstArm(dragon, felicity) shouldBe(dragonHitInChest, felicityHitsFourTimes)
  }

}