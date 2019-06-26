#Parking Lot Tasking

* **scenario1**
    * given: parking car and has empty space
    * when：parking
    * then：let the car park and give a ticket and empty space decrease one

* **scenario2**
    * given: parking car and has not empty space
    * when: parking
    * then: reject the car to enter

* **scenario3**
    * given: the ticket and the car id is valid
    * when: pick up the car 
    * then: let the car out and empty space increase one

* **scenario4**
    * given: the ticket and the car id is invalid
    * when: pick up the car 
    * then: don't let the car out