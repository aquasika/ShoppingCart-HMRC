package hmrc.offer

import hmrc.product._

/**
  * Created by aanand on 14/03/2017.
  */
trait Offer {
  def calculateDiscount(items: List[Product]): BigDecimal
  def apply3For2Discount(products: List[Product], price: BigDecimal): BigDecimal = {
    val eligibleQuantity = products.size - (products.size % 3)
    (eligibleQuantity / 3) * price
  }
}

object AppleBuy1Get1Offer extends Offer {

  override def calculateDiscount(items: List[Product]): BigDecimal = {
    val apples = items.filter(_ match { case Apple => true case _ => false })
    apples.take( apples.size / 2 ).map( _.price ).sum
  }
}

object Orange3For2Offer extends Offer {

  override def calculateDiscount(items: List[Product]): BigDecimal = {
    val oranges = items.filter(_ match { case Orange => true case _ => false })
    apply3For2Discount(oranges, Orange.price)
  }
}


object AppleBanana2For1Cheapest extends Offer {

  override def calculateDiscount(items: List[Product]): BigDecimal = {
    val applesAndBananas = items.filter(p=> p == Apple || p == Banana).sortBy(_.price)
    applesAndBananas.take(applesAndBananas.size / 2).map(_.price).sum
  }
}

object Melon3For2Offer extends Offer {

  override def calculateDiscount(items: List[Product]): BigDecimal = {
    val melons = items.filter(p => p == Melon)
    apply3For2Discount(melons, Melon.price)
  }


}
