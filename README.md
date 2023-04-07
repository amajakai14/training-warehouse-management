# Second lesson

## Get Data that is stored in Database

#### Start up database

before this step Docker should be ready to use

- `./beginner/demo/demo/local/start.sh`
  - if there is something wrong with database just run this command it will reset database data

### Tutorial

run our `DemoApplication` once again

open `order.html` file and click the button see that there's some orders has been rendered
let's look into `order.js`
there's a called to our server

now there's some files and folders have been added  
let's explain what each folder's meaning is

- Controller
  - Controller is a Gateway to connect to client. When Client send a Request it will be sent to Controller first and after finished all process It will response back to client
- Service
  - Service will determine the process what will this application does in this example it will get all orders
- Repository
  - Repository is an interface that can hide a complex logic behind. Keep our code simplier to look
- Datasource
  - Datasource is the one that implement from the repository a complex logic in this case connect to our Database and do the query stuff
- Model
  - a Declared Type for What kind of Things this application have in this case we have Order

Let's try to understand how each Class is connected to each other

### Annotation

In controller, you might see a lot of `@` we called those the annotation. which is not a Pure Java code. But it is in Java Framework called Spring Boot
I will leave some detail in learn more section to let you do your study

- `@RestController` is to tell java that this Java class is a Controller
- `@RequestMapping` is to map path when you try to request to the url in this case it should be `http://localhost:8080{mapping}` -> `http://localhost:8080/orders`
- `@GetMapping` is tell that you can access this end point by using `GET` method which is the simplest one
  - `(produces = "application/json")` is tell Java what kind of data type will be response to client by json and map our model (OrdersResponse) into that data type
- `@HttpStatus` you might sometimes browse on the internet and find `Error 404` and yes that is the HttpStatus which each code are predefined what the meaning is

### Exercise

in exercise.html there is a button to show menu which is broken. Try to make it work!
Hint: I have comment some steps to take in Java already let's find them!

#### Learn more

- learn more about RESTapi [here](https://tech.012grp.co.jp/entry/rest_api_basics)
- learn more about fetch() function [here](https://developer.mozilla.org/en-US/docs/Web/API/Fetch_API/Using_Fetch)
- learn more about json [here](https://cloudapi.kddi-web.com/magazine/json-javascript-object-notation)
- learn more about http status [here](https://digital-marketing.jp/seo/http-status-code/)
