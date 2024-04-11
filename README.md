# Java_Project

run `setup.sql` once postgres is installed.

go to the demo folder and run `./gradlew bootRun`

Check the endpoints (only these have been implemented so far) 

`http://localhost:8080/profile/1`

`http://localhost:8080/flights`

Things to implement are

- Authentication (I have created the endpoint template in the PersonController.java file, so simply complete the logic)
- Admin (Create a new AdminController for this and implement the logic, dont need to hardcode flight trip details, possibly search for an API that gives this and feed it into postgres)
- Booking flights 
- Discount feature

Once all these are done we can extend it to handle CRUD or you can possibly do it while implementing the logic itself which would be better
