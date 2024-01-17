Greetings, this is an example project for the Stocklin job opportunity.

This project uses java SpringBoot the development framework.

After creating this project, i was not able to upload it an AWS server due to the fees required to be able to upload it, therefor i was only able to run this locally,
by using docker as a local container and connect to a postgre database, and use every functionality through the Postman application.

## Running the application

To be able to use and start this project firstly we would need to connect to the docker container using the compose-docker.yaml file by running
```shell script
docker-compose up
```

Afterwards to start the project we would need to run the StocklinProjectDemoApplication.
```shell script
./mvnw spring-boot:run
```

This is a project about Books and Authors, the available endpoint calls are available in the postman collection on the root of the project, named: Stocklin Project.postman-collection.json 

FOR BOOKS
-----------------------------------------------------------------
-GET
-used to get all available books
for books we use an "isbn" as an id which is: 
the International Standard Book Number is a numeric commercial book identifier that is intended to be unique
-used for getting a specific book based on its isbn
-----------------------------------------------------------------
-PUT
-used for creating a book, a book has an isbn, title and an author.
-----------------------------------------------------------------
-DELETE
-used for deleting a specific book based on its isbn
-----------------------------------------------------------------
-PATCH
used for partial update of a book, 
for example if we wish to change only the title of the book.
-----------------------------------------------------------------

FOR AUTHORS
-----------------------------------------------------------------
-POST
-used for creating an author, an author has a name, age and id.
-----------------------------------------------------------------
-GET
-used to get all available authors
-used for getting a specific author based on thier id
-----------------------------------------------------------------
-PUT
-used for updating the data of an existing author
-----------------------------------------------------------------
-DELETE
-used for deleting a specific author based on their id
-----------------------------------------------------------------
-PATCH
used for partial update of a author, 
for example if we wish to change only the name of the author.
-----------------------------------------------------------------

This is currently the full functionality of the project.
