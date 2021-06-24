# BelajarRetrofit


# API BASE_URL  
 - "https://jsonplaceholder.typicode.com/"
 
# GET POST
 Request:
- Method : GET 
- Endpoint : `/posts`
- Header :
    - Accept: application/json
- Response :
  ```json
    "code": "Number",
    "data": {
      "userId": "Int, Unique",
      "id": "Int, Unique",
      "title": "String",
      "body": "String"
  ```
  
# CREATE POST  
  Request:
  - Method : POST
  - Endpoint : `/posts`
  - Header : 
    - Content-Type: application/json
    - Accept: application/json
  - Body :
   ```json{
      "userId": "Int, Unique",
      "id": "Int, Unique",
      "title": "String",
      "body": "String"
      }
      ```
  - Response :
    ```json
        "code": "Number",
        "data":{
          "userId": "Int, Unique",
          "id": "Int, Unique",
          "title": "String",
          "body": "String"
      }
    ```


