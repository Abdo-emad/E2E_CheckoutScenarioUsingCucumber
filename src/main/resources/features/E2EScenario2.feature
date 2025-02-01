Feature: Normal Checkout Process

  Scenario: Validate user can complete the normal checkout process and confirm order

    # Step 1: Login
    Given the user navigates to the login page
    When the user logs in with valid credentials:
      | Email                  | Password  |
      | elliot.kuphal@hotmail.com | P@ssw0rd |
    And the user clicks on the login button

    # Step 2: Add Item to Cart
    And the user navigates to "MP3 Players > Show All MP3 Players"
    And the user adds "iPod Shuffle" to the cart
    Then the success message "Success: You have added iPod Shuffle to your shopping cart!" is displayed

    # Step 3: View Cart and Checkout
    And the user opens the shopping cart and clicks on "View Cart"
    And the user clicks on the "Checkout" button

    # Step 4: Fill Billing and Delivery Details
    And the user fills in the billing details with a new address
    And the user clicks on the "Shipping Continue" button

    # Step 5: Review and Confirm Order
    And the user adds a comment to the order
    And the user clicks on the "Delivery Method Continue" button
    And the user checks the "Terms & Conditions" checkbox
    And the user clicks on the "Payment Continue" button
    And the user clicks on the "Confirm Order" button

    # Step 6: Order Confirmation
    Then the message "Your order has been placed!" is displayed
    And the shopping cart is now empty

    # Step 7: Logout
    And the user logs out successfully