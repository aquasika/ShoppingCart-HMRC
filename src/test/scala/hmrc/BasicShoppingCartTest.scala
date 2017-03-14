package hmrc

import hmrc.product.{Apple, Orange, Product}
import hmrc.services.BasicShoppingCart
import org.scalatest.FlatSpec

/**
  * Created by Abhishek on 14/03/2017.
  */
class BasicShoppingCartTest extends FlatSpec {
  var basicShoppingCart = new BasicShoppingCart

  "Shopping basket" should " handle the empty list of items" in {

    val total = basicShoppingCart.checkout(List.empty[Product])
    assert(total == BigDecimal("0"))
  }

  "Shopping basket with only one orange" should " cost £0.25" in {
    val total = basicShoppingCart.checkout(List(Orange))
    assert(total == BigDecimal("0.25"))
  }

  "Shopping basket with only one apple" should " cost £0.60 " in {
    val total = basicShoppingCart.checkout(List(Apple))
    assert(total == BigDecimal("0.60"))
  }

  "Shopping basket with three apples and one orange" should " cost £2.05 " in {
    val total = basicShoppingCart.checkout(List(Apple, Apple, Orange, Apple))
    assert(total == BigDecimal("2.05"))
  }
}
