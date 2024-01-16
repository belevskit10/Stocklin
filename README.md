Greetings, this is an example project for the Stocklin job opportunity.

After creating this project, i was not able to upload it an AWS server due to the fees required to be able to upload it, therefor i was only able to run this locally,
by using docker as a local container and connect to a postgre database, and use every functionality through the Postman application.

To be able to use and start this project firstly we would need to connect to the docker container using the compose-docker.yaml file by running "docker-compose up" in the terminal.

Afterwards to start the project we would need to run the StocklinProjectDemoApplication.

This is a project about Books and Authors, the available endpoint calls are as followed:

FOR BOOKS

-GET
-used to get all available books
http://localhost:8080/books

for books we use an "isbn" as an id which is: 
the International Standard Book Number is a numeric commercial book identifier that is intended to be unique
-used for getting a specific book based on its isbn
http://localhost:8080/books/{isbn}
-----------------------------------------------------------------
-PUT
-used for creating a book, a book has an isbn, title and an author.
http://localhost:8080/books/987-1-2345-6789-2
json body:
{
    "isbn" : "987-1-2345-6789-2",
    "title": "The Shadow in the Attic",
    "author": {
        "name": "Fred the Author",
        "age": 14
    }
}
-----------------------------------------------------------------
-DELETE
-used for deleting a specific book based on its isbn
http://localhost:8080/books/{isbn}
-----------------------------------------------------------------
-PATCH
used for partial update of a book, 
for example if we wish to change only the title of the book.
http://localhost:8080/books/{isbn}
json body: 
{
"title": "The Shadow in the Attic"
}
-----------------------------------------------------------------

FOR AUTHORS
-POST
-used for creating an author, an author has a name, age and id.
http://localhost:8080/authors
json body:
{
   "name": "Fred the Author",
   "age": 14
}
-----------------------------------------------------------------
-GET
-used to get all available authors
http://localhost:8080/authors

-used for getting a specific author based on thier id
http://localhost:8080/authors/{id}
-----------------------------------------------------------------
-PUT
-used for updating the data of an existing author
http://localhost:8080/authors/{id}
json body:
{
   "name": "Fred the Author",
   "age": 14
}
-----------------------------------------------------------------
-DELETE
-used for deleting a specific author based on their id
http://localhost:8080/authors/{id}
-----------------------------------------------------------------
-PATCH
used for partial update of a author, 
for example if we wish to change only the name of the author.
http://localhost:8080/authors/{id}
json body: 
{
    "name": "Sarah the Author",
}
-----------------------------------------------------------------

This is currently the full functionality of the project.
