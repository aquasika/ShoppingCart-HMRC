package hmrc.services

import hmrc.product.Product

/**
  * Created by aanand on 14/03/2017.
  */
class BasicShoppingCart extends Cart {
  override def checkout(selectedItems: List[Product]) = selectedItems.foldLeft(BigDecimal(0)) { (price, product) =>
    product.price + price
  }
}
