When the main function in `RestServiceApplication.java` is run, the application runs on http://localhost:8080

The app can receive GET and POST requests on http://localhost:8080/employees/
a GET request returns the employees
a POST request with can receive and return JSON in the following format:
```
{
    "id" : "4",
    "firstName" : "Mary",
    "lastName" : "Poppins",
    "email" : "mpoppins@gmail.com",
    "title" : "Mrs."
}
```
to add an employee with that information to the list of employees.

The app can also receive GET requests on http://localhost:8080/greeting
or http://localhost:8080/greeting?name=yourname
and returns a unique message id and a greeting message:
```
{
    "id": 1,
    "content": "Hello, World"
}
```