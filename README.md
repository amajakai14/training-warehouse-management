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

### Exercise

in exercise.html there is a button to show menu which is broken. Try to make it work!
Hint: I have comment some steps to do in Java already let's find them!

#### Learn more

- learn more about async await [here](https://tcd-theme.com/2021/09/javascript-asyncawait.html)
