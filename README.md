# Property policies
Functionality that calculates policy premium.

In this iteration client stated that only risk types FIRE and WATER will be calculated, however 
it may be possible that in near future more risk types will be added.

**Premium calculation formula:**
PREMIUM = PREMIUM_FIRE + PREMIUM_WATER
* PREMIUM_FIRE = SUM_INSURED_FIRE * COEFFICIENT_FIRE
  * SUM_INSURED_FIRE - total sum insured of all policy's sub-objects with type "Fire"
  * COEFFICIENT_FIRE - by default 0.013 but if SUM_INSURED_FIRE is over 100 then 0.023
* PREMIUM_WATER = SUM_INSURED_WATER * COEFFICIENT_WATER
  * SUM_INSURED_WATER - total sum insured of all policy's sub-objects with type "Water"
  * COEFFICIENT_WATER - by default 0.1 but if equal or greater than 10 then 0.05
  
## Technologies
* Java 8
* Maven
* JUnit

## Run & Test
This application does not use any open-source framework due to functionality implementation 
does not require any framework at all and can be implemented using plain Java.

To check whether application returns the right result you should go into the `test` directory and run unit tests.