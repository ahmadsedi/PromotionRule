# Promotion Engine
   PromotionRule is a simple promotion engine for a checkout process in a shop. Our Cart contains a list of single character SKU ids (A, B, C.	) over which the promotion engine will need to run.
   The aim of this practice is to improve functional programming skill in Java! 
## Features
   The promotion engine will need to calculate the total order value after applying the 2 promotion types: <br>
   - buy 'n' items of a SKU for a fixed price (3 A's for 130)
   - buy SKU 1 & SKU 2 for a fixed price ( C + D = 30 ) <br>
## Requirements   
   The promotion engine has been designed modular to allow for more promotion types to be added at a later date (e.g. a future promotion could be x% of a SKU unit price). <br>
   This coding exercise assumes that the promotions will be mutually exclusive; in other words if one is applied the other promotions will not apply
## Test Cases
   Test Setup <br>
   Unit price for SKU IDs  <br>
   A ->	50 <br>
   B ->	30 <br>
   C ->	20 <br>
   D ->	15 <br>
    <br>
   Active Promotions <br>
   3 of A's for 130 <br>
   2 of B's for 45 <br>
   C & D for 30 <br>
### Scenario  A    
   1 * A  ->   50 <br>
   1 * B  ->   30 <br>
   1 * C  ->   20 <br>
    <br>
   Total  ->   100 <br>
   
### Scenario  B
   5 * A  -> 130 + 2*50 <br>
   5 * B  -> 45 + 45 + 30 <br>
   1 * C  -> 28 <br>
    <br>
   Total  ->  370 <br>
   
### Scenario  C
   3 * A  ->  130 <br>
   5 * B  ->  45 + 45 + 1 * 30 <br>
   1 * C  ->  - <br>
   1 * D  ->  30 <br>
