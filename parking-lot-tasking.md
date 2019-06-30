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
    
---

* **scenario1**
    * given: multi parking lot with available space
    * when: parking boy park car
    * then: park the car to the first parking lot 

* **scenario2**
    * given: multi parking lot without available space
    * when: parking boy park car
    * then: don't park car and indicate parking lot are full 

* **scenario3**
    * given: 5 parking lot and just last three have available space
    * when: parking boy park car
    * then: park the car to the 3rd parking lot 

* **scenario4**
    * given: 5 parking lot and just first three have available space
    * when: parking boy park car
    * then: park the car to the 1st parking lot*

* **scenario5**
    * given: the ticket with corresponding car
    * when: pick up the car 
    * then: get the car

* **scenario6**
    * given: the ticket without corresponding car
    * when: pick up the car 
    * then: don't get the car and indicate the ticket is invalid
    
---

* **scenario1**
    * given: multi parking lot with different available space
    * when: parking boy park car
    * then: park the car to the parking lot which has most available space 

* **scenario2**
    * given: 多个停车场，剩余车位最多的停车场有多个
    * when: 停车
    * then: 停入第一个剩余车位最多的停车场 
   