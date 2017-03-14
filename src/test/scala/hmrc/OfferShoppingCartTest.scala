package hmrc

import hmrc.offer.{Orange3For2Offer, AppleBuy1Get1Offer}
import hmrc.product.{Orange, Apple}
import hmrc.services.OfferShoppingCart
import org.scalatest.FlatSpec

/**
  * Created by Abhishek on 14/03/2017.
  */
class OfferShoppingCartTest extends FlatSpec {
  var offerShoppingCart = new OfferShoppingCart(List(AppleBuy1Get1Offer, Orange3For2Offer))

  "Shopping basket with ten apples " should "cost £3.0 with the deal" in {
    assert(offerShoppingCart.checkout(List.fill(10)(Apple)) == BigDecimal("3.00"))
  }

  "Shopping basket with 3 oranges " should "cost £0.5 with the deal" in {
    assert(offerShoppingCart.checkout(List.fill(3)(Orange)) == BigDecimal("0.50"))
  }

  "Shopping basket with 2 oranges " should "cost £0.5 with the deal" in {
    assert(offerShoppingCart.checkout(List.fill(2)(Orange)) == BigDecimal("0.50"))
  }

  "Shopping basket with 1 apple " should "cost £0.6 with the deal" in {
    assert(offerShoppingCart.checkout(List(Apple)) == BigDecimal("0.60"))
  }

  "Shopping basket with 10 apples 6 oranges " should "cost £4 with the deal" in {
    val oranges = List.fill(6)(Orange)
    val apples = List.fill(10)(Apple)
    assert(offerShoppingCart.checkout(apples ::: oranges) == BigDecimal("4.00"))
  }

  "Shopping basket with 11 apples 8 oranges " should "cost £4 with the deal" in {
    val oranges = List.fill(8)(Orange)
    val apples = List.fill(11)(Apple)
    assert(offerShoppingCart.checkout(apples ::: oranges) == BigDecimal("5.10"))
  }
}
