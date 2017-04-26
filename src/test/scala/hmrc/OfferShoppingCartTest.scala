package hmrc

import hmrc.offer.{Melon3For2Offer, AppleBanana2For1Cheapest, Orange3For2Offer, AppleBuy1Get1Offer}
import hmrc.product.{Melon, Banana, Orange, Apple}
import hmrc.services.OfferShoppingCart
import org.scalatest.FlatSpec

/**
  * Created by Abhishek on 14/03/2017.
  */
class OfferShoppingCartTest extends FlatSpec {
  var offerShoppingCart = new OfferShoppingCart(List(Orange3For2Offer, AppleBanana2For1Cheapest, Melon3For2Offer))

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

  "Shopping basket with 2 bananas and 2 apples" should "cost £1.20 with the deal" in {
    val apples = List(Apple, Apple)
    val bananas = List(Banana, Banana)

    assert(offerShoppingCart.checkout(apples ::: bananas) == BigDecimal("1.20"))
  }

  "Shopping basket with 3 melons" should "cost £2.0 with the deal" in {
    val melons = List.fill(3)(Melon)
    assert(offerShoppingCart.checkout(melons) == BigDecimal("2.00"))
  }

}
