
###Parking Lot Tasking
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
    
---
### graduate parking boy

#### park
* **scenario1**
    * given: multi parking lot with available space
    * when: graduate parking boy park car
    * then: park the car to the first parking lot 

* **scenario2**
    * given: multi parking lot without available space
    * when: graduate parking boy park car
    * then: don't park car and indicate parking lot are full 

* **scenario3**
    * given: 5 parking lot and just last three have available space
    * when: graduate parking boy park car
    * then: park the car to the 3rd parking lot 

* **scenario4**
    * given: 5 parking lot and just first three have available space
    * when: graduate parking boy park car
    * then: park the car to the 1st parking lot*

#### take car
* **scenario5**
    * given: the ticket with corresponding car
    * when: graduate parking boy pick up the car 
    * then: get the car

* **scenario6**
    * given: the ticket without corresponding car
    * when: graduate pick up the car 
    * then: don't get the car and indicate the ticket is invalid
    
---
### smart parking boy

#### park
* **scenario1**
    * given: multi parking lot with different available space
    * when: smart parking boy park car
    * then: park the car to the parking lot which has most available space 

* **scenario2**
    * given: multi parking lot have most available space 
    * when: smart parking boy park car
    * then: park the car to the first parking lot which has most available space

#### take car
same as previous task

   
---
### parking lot manager

#### park
* **scenario1**
    * given: multi parking lot with available space and a parking boy who can manage all the parking lot  
    * when: parking lot manager park car
    * then: parking lot manager call the parking boy to park the car and return a ticket 

* **scenario2**
    * given: multi parking lot with available space and a parking boy who can manage all the parking lot  
    * when: parking lot manager park car by self
    * then: parking lot manager park the car and return a ticket

* **scenario3**
    * given: multi parking lot with available space which divided for multi parking boy   
    * when: parking lot manager park car
    * then: parking lot manager choose one parking boy to park the car and return a ticket

* **scenario4**
    * given: multi parking lot but just one one of them has available space and a parking boy who can't manage this parking lot 
    * when: parking lot manager park car
    * then: parking lot manager park the car and return a ticket

#### take car
same as previous task
