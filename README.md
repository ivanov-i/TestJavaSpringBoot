# Java Spring Boot Assesment Task

## Requirements
- Java 17. I used OpenJDK@17 on Mac.
- For test script you are going to need curl and jq

## How to run

- Clone this repo somewhere. CD into the cloned dir.  
`git clone https://github.com/ivanov-i/TestJavaSpringBoot`
- This is a gradle project, so do  
`./gradle bootRun`
- now it runs HTTP server on port 8080
- you that it is indeed running by navigating to `http://localhost:8080/products`

## JSON Object specs
### The following fields are common for all objects:
  * `ID` -- unique identificator. It is read-only and you should never send it in any JSON object.
  * `type` -- one of `desktop`, `laptop`, `hard_drive`, or `monitor`
  * `serialNumber` -- string
  * `manufacturer` -- string
  * `price` -- decimal
  * `quantity` -- int

### In addition each type of objects has its own unique fileds:
  + desktop:  
     `desktopFormat` -- one of `desktop`, `all-in-one`, `nettop`
  + laptop:  
     `size` -- size in inches. double.
  + monitor:  
     `diagonal` -- diagonal in inches. double.
  + `hard_drive`. 
     `capacity` in GB. Integer. 
### examples
   {"type":"desktop","id":1,"serialNumber":"SN001","manufacturer":"IBM","price":1200.00,"quantity":10,"formFactor":"DESKTOP"}  
   {"type":"laptop","id":2,"serialNumber":"SN002","manufacturer":"SGI","price":1000.00,"quantity":15,"size":15.0}  
   {"type":"monitor","id":3,"serialNumber":"SN003","manufacturer":"BBC","price":800.00,"quantity":20,"diagonal":27.0}  
   {"type":"hard_drive","id":4,"serialNumber":"SN004","manufacturer":"Seagate","price":100.00,"quantity":50,"capacity":500}  

## Endpoints

### `GET /products`
  Returns a list of all products in the database.
  
### `GET /products/ID
  Returns a single product by ID
  
### POST /desktops
### POST /laptops
### POST /monitors
### POST /hdds

  Using these endpoints you can add an item. Don't add `id` field to your JSON object.
  
### POST /desktops/ID
### POST /laptops/ID
### POST /monitors/ID
### POST /hdds/ID

  Using these endpoints you can modify items by ID. Don't add `id` field to your JSON object.
  
### DELETE /products/ID
  delete any product
  
## Test script
  There is a test script in `scripts/test.sh`. You are going to need curl and jq if you actually want to run it.
