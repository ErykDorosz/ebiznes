package com.ebiznes.elektronik.controller;

import java.util.HashMap;
import java.util.Map;

import com.ebiznes.elektronik.entity.Checkout;
import com.ebiznes.elektronik.entity.CheckoutPayment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;

@RestController
@RequestMapping(value = "/api")
public class StripeController {
// create a Gson object
	private static Gson gson = new Gson();

	@PostMapping("/payment")
	/**
	 * Payment with Stripe checkout page
	 * 
	 * @throws StripeException
	 */
	public String paymentWithCheckoutPage(@RequestBody CheckoutPayment payment) throws StripeException {
		// We initilize stripe object with the api key
		init();
		// We create a  stripe session parameters
		SessionCreateParams params = SessionCreateParams.builder()
				// We will use the credit card payment method 
				.addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
				.setMode(SessionCreateParams.Mode.PAYMENT).setSuccessUrl(payment.getSuccessUrl())
				.setCancelUrl(
						payment.getCancelUrl())
				.addLineItem(
						SessionCreateParams.LineItem.builder().setQuantity(payment.getQuantity())
								.setPriceData(
										SessionCreateParams.LineItem.PriceData.builder()
												.setCurrency(payment.getCurrency()).setUnitAmount(payment.getAmount())
												.setProductData(SessionCreateParams.LineItem.PriceData.ProductData
														.builder().setName(payment.getName()).build())
												.build())
								.build())
				.build();
  // create a stripe session
		Session session = Session.create(params);
		Map<String, String> responseData = new HashMap<>();
    // We get the sessionId and we putted inside the response data you can get more info from the session object
		responseData.put("id", session.getId());
      // We can return only the sessionId as a String
		return gson.toJson(responseData);
	}

	private static void init() {
		Stripe.apiKey = "sk_test_51L6uLQEZl3zkpMmaxUdT8eSJ1U9ZlRNlg4gBPrt9PLIauitp1Lwtka3kMhe4vPslnrZpifZmHHX4a28QWhJTGxP900L4Oxkbq0";
	}

    @PostMapping("/subscription")
	/**
	 * Used to create a subscription with strpe checkout page 
	 * @param checkout
	 * @return the subscription id
	 * @throws StripeException
	 */
	public String subscriptionWithCheckoutPage(@RequestBody Checkout checkout) throws StripeException {
		SessionCreateParams params = new SessionCreateParams.Builder().setSuccessUrl(checkout.getSuccessUrl())
				.setCancelUrl(checkout.getCancelUrl()).addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
				.setMode(SessionCreateParams.Mode.SUBSCRIPTION).addLineItem(new SessionCreateParams.LineItem.Builder()
						.setQuantity(1L).setPrice(checkout.getPriceId()).build())
				.build();

		try {
			Session session = Session.create(params);
			Map<String, Object> responseData = new HashMap<>();
			responseData.put("sessionId", session.getId());
			return gson.toJson(responseData);
		} catch (Exception e) {
			Map<String, Object> messageData = new HashMap<>();
			messageData.put("message", e.getMessage());
			Map<String, Object> responseData = new HashMap<>();
			responseData.put("error", messageData);
			return gson.toJson(responseData);
		}
	}
}