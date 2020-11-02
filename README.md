# spring_boot_project
RESTFULL application with a basic CRUD to manage a product

Steps to build the project locally:
Requirements: 
- Install JDK in your PC, install the last version, this is the url to install JDK in your PC https://www.oracle.com/java/technologies/javase/jdk14-archive-downloads.html
- Install an IDE of your choice (Eclipse or IntelliJ), this is the url to install IntelliJ https://www.jetbrains.com/fr-fr/idea/download/#section=windows and choose community version, it's for developper

Steps to build the project locally: 
- Clone the project on github, this is the url of the project : https://github.com/radomamitiana/spring_boot_project.git
- Open the project in your IDE
- Run the following maven cylce, maven clean and maven install
- Right clic on the file "ApiApplication.java" and click Run "ApiApplication"
- Open your postman
- Clic "New" and click "Request" and follow follow the insctruction (request name and collection)




List of endpoint in the application:
Url: "localhost:8080/api/product/"
Method: GET	
Description: Get all product
Response: Array of product
[
{
    "id": 1,
    "name": "Produit1",
    "createdDate": "2020-11-02",
    "price": 2000.0,
	"isDeleted": false
},
{
    "id": 2,
    "name": "Produit2",
    "createdDate": "2020-11-02",
    "price": 6000.0,
	"isDeleted": false
}
]

Url: "localhost:8080/api/product/create"
Method: POST
Description: Create a product
Parameter: Produt (in the Body, choose "raw" and type "JSON", and past this example)
{
    "name": "Produit1",
    "price": 1500
}
Result: JSON 
{
    "id": 1,
    "name": "Produit1",
    "createdDate": "2020-11-02",
    "price": 1500.0,
	"isDeleted": false
}

Url: "localhost:8080/api/product/edit"
Description: Edit product
Parameter: Product (in the Body, choose "raw" and type "JSON", and past this example)
{
    "id": 1,
	"name": "Produit1 edit",
	 "createdDate": "2020-11-02",
    "price": 2000.0,
	"isDeleted": false
}

Result: JSON
{
    "id": 1,
    "name": "Produit1 edit",
    "createdDate": "2020-11-02",
    "price": 2000.0,
	"isDeleted": false
}

Url: "localhost:8080/api/product/delete/{product_id}"
Parameter: Product_id , example of url to delete a product with the id=1, localhost:8080/api/product/delete/1
On postman, past this url and choose "Delete" method and choose "none" in the Body.
Result : true



