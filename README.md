When the main function in `RestServiceApplication.java` found [here](https://github.com/ankhoa1212/rest-api-web-service/blob/main/rest-service/src/main/java/com/example/restservice/RestServiceApplication.java) is run, the application runs on http://localhost:8080

The app can receive GET and POST requests on http://localhost:8080/employees/

A GET request returns the employees
Employees can be added via a POST request, which can receive and return JSON in the following format:
```
{
    "id" : "4",
    "firstName" : "Mary",
    "lastName" : "Poppins",
    "email" : "mpoppins@gmail.com",
    "title" : "Ms."
}
```

The app can also receive GET requests on http://localhost:8080/greeting
or http://localhost:8080/greeting?name=yourname
and returns a unique message id and a greeting message:
```
{
    "id": 1,
    "content": "Hello, World"
}
```

Unit tests can be found [here](https://github.com/ankhoa1212/rest-api-web-service/tree/main/rest-service/src/test/java/com/example/restservice)
