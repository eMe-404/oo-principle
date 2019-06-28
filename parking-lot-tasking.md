#Parking Lot Tasking

* **scenario1**
    * given: parking car and has empty space
    * when：check space
    * then：indicate that there is empty space in the parking lot

* **scenario2**
    * given: parking car but no empty space
    * when：check space
    * then：indicate that parking lot is full

* **scenario3**
    * given: entered car and has empty space
    * when：park
    * then：give a ticket

* **scenario4** ??
***TODO*** confirm the concurrency of the parking lot (how many entries of it)
    * given: entered car but space is full
    * when：park
    * then：indicate that the parking lot is full

* **scenario5**  ??  
***TODO:*** clarify the parking lot security, do we need to consider that (is there ever car stolen? or is it might happen in future?)
    * given: parked car
    * when: check the car
    * then: indicate that the car is in our parking lot
    
* **scenario6**
    * given: parked car and the valid ticket 
    * when: take car
    * then: let the car leave

* **scenario7**
    * given: parked car and the ticket with incorrect car id 
    * when: take car
    * then: reject to take the car


##NOTE
* clarification for the scenario 4 & 5 TODO