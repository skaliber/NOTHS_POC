Feature: As a Customer
I want to be able to add items to my basket
So that I can purchase them


  @addoneitem
  Scenario Outline:  Add One item into basket
    Given When I navigate to the <product> page
    And And I click on Add to basket button
    Then Item should be added to my basket
     Examples:
  | product | 
  |  "/themotivatedtype/product/choose-happy-and-laugh-often-typography-print"   |
   
   @add2items 
    Scenario Outline: Try to add product into basket without selecting requiered field
    Given When I navigate to the <product> page
    When I change the qty to be 2
    And And I click on Add to basket button
    Then Item should be added to my basket 2
    Examples:
  | product | 
  |  "/themotivatedtype/product/choose-happy-and-laugh-often-typography-print"   |
 
    

    
