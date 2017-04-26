package hmrc.services

import hmrc.product.Product

/**
  * Created by Abhishek on 14/03/2017.
  */
trait Cart {
  def checkout(selectedItems : List[Product] ) : BigDecimal
}
