@smoke
Feature: Store E2E Scenario to check Store Website Functionality
   # Login
  Background: User logs in to the store
    Given the user navigates to the login page
    When user enter valid "elliot.kuphal@hotmail.com" and "P@ssw0rd" then login
  Scenario: Validate user could be able to do normal checkout process and confirm order
    # Step 1: Navigate and Add Item to Cart
    Given the user accesses the "MP3 Players" page
    When the user adds "iPod Shuffle" to the cart
    Then a success message 'Success: You have added "iPod Shuffle" to your shopping cart!' is displayed
    # Step 2: Shopping Cart and Checkout
    And the user opens the shopping cart and proceeds to the checkout page
     # Step 3: Fill Billing and Shipping Details
    And the user fills in the billing details with a new address
    And user continue shipping then Adding "Comment"
     # Step 4: Review and Confirm Order
    And the user proceeds with the delivery method and accepts the 'Terms & Conditions'
    And user continue payment and confirm order
     # Step 5: Order Confirmation
    Then the message 'Your order has been placed!' is displayed
    And the shopping cart is now empty
      # Step 6: Logout
    And user Log out successfully
