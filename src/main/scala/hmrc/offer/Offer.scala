package hmrc.offer

import hmrc.product.{Apple, Orange, Product}

/**
  * Created by aanand on 14/03/2017.
  */
trait Offer {
  def calculateDiscount(items: List[Product]): BigDecimal
}

object AppleBuy1Get1Offer extends Offer {

  override def calculateDiscount(items: List[Product]): BigDecimal = {
    val apples = items.filter(_ match { case Apple => true case _ => false })
    val eligibleQuantity = apples.size - (apples.size % 2)
    (eligibleQuantity / 2) * Apple.price
  }
}

object Orange3For2Offer extends Offer {

  override def calculateDiscount(items: List[Product]): BigDecimal = {
    val oranges = items.filter(_ match { case Orange => true case _ => false })
    val eligibleQuantity = oranges.size - (oranges.size % 3)
    (eligibleQuantity / 3) * Orange.price
  }
}