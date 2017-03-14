package hmrc.services

import hmrc.offer.Offer
import hmrc.product.Product

/**
  * Created by Abhishek on 14/03/2017.
  */
class OfferShoppingCart(offers: List[Offer] = Nil) extends Cart {
  override def checkout(selectedItems: List[Product]): BigDecimal = {
    var totalDiscount = BigDecimal("0.0")
    for (offer <- offers) {
      totalDiscount += offer.calculateDiscount(selectedItems)
    }
    val defaultCheckout = new BasicShoppingCart
    defaultCheckout.checkout(selectedItems) - totalDiscount
  }
}
