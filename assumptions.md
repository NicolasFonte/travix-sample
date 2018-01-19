## Assumptions and Future work

 - Code has been done considering the limit of 1.5~2 hours.
 - TravixController will be entry point for requests. SWagger has been added for checking APIs.
 - TravixService has the main logic. Thats why I only added tests to that.
 - lombok added for boilerplate code
 - I haven't changed domain objects but i would consider generify then implementing some interface with method toTravixRequest() or something.
 - If request objects are generified code in Service class would be simplified
 - springMVC tests should be added to controller
 - The functionality for calling external APIs if not implemented. I would need to emulate the external backend. So I Just returned hardcoded data.
 - For that reason final result will be hardcoded. But I believe the flow in how would work is clear.