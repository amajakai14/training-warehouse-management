# First lesson

## Setup

First we need some setup before we can dive to any of our lesson
**Try to read what is going on when installing these tools**  
there might be some steps that you have to follow along depend on what OS you are using

#### Install tools

- Install `Git` from [HERE](https://git-scm.com/downloads)
- Install `Fork` from [HERE](https://git-fork.com/)
  - [How to use fork](https://qiita.com/AyakoKataoka/items/e1b0a2a2b2c85de4c1e3)
- Install `JDK11` from [HERE](https://www.oracle.com/java/technologies/downloads/#java11) **remember what folder you installed**
- Install `Intellij` from [HERE](https://www.jetbrains.com/idea/download/#section=windows)
- Install `VSCode` from [HERE](https://code.visualstudio.com/)
  - (optional) some extension install [おすすめ](https://qiita.com/KNR109/items/5f933df1292564e6dc70)
    - what i would recommend is
      - HTML CSS Support
      - Javascript (ES6) code snippets
      - Live Server
- Install `Docker Desktop` from [HERE](https://docs.docker.com/desktop/install/windows-install/)
  - There might a lot of steps here you may need some help or visit this [site](https://www.kagoya.jp/howto/cloud/container/wsl2_docker/)

#### Setup environment

- setup system enviroment for java
- japanese version
  - 環境変数を設定する
    - システムの環境変数に、JDK のパスを指定する
    - 変数名：JAVA_HOME
    - 変数値：{JDK をインストールしたフォルダ}
    - システムの環境変数の Path を開く
    - [新規(N)]ボタンをクリックすると　{JDK をインストールしたフォルダ}\bin 　を入れる
- english version

  - edit system environment variable `JAVA_HOME` make it point to the folder of java11 you've installed
  - edit system environment variable `PATH` make it point to the `bin` folder in the folder of java11 you've installed
    - click create to add a new column for path

- open intellij
  - open -> go to the folder where you clone this repository
  - files -> Project Structure -> SDK -> select sdk version 11 from the one you downloaded above

#### Start up database

before this step Docker should be ready to use

- run this command on terminal `./beginner/demo/demo/local/start.sh`

## Server Side and Client Side

In this project we divide code into two parts

- Client Side which contain html javascript and css file (in this project we will not use any css file if you want to learn more about css go [here](https://www.w3schools.com/w3css/defaulT.asp))
- Server Side which in our case writing in Java

### Why do we need to have Client Side and Server Side?

Normally Client Side is where someone comes and try to manipulate data such as read, write, update or delete data.  
On client side we provide UI to let user act with screen

On the server side we just receive an action to make a record to save data permanently on our Storage which can be any type (In this project we will use Postgres Database as our storage)

### Tutorial

for a better experience I recommend edit Java code in `IntelliJ` and edit `html javascript css` in VScode

first let's start our server
open intellij -> open -> training-warehouse-management

left click on DemoApplication.java -> `Run DemoApplication.main()` or `実行`
in the terminal you might see something like `Tomcat started on port(s): 8080 (http)`
that's means it work!

open vscode -> open -> training-warehouse-management
now let's go to `beginner` folder `ui` folder then open `index.html`
there's two button on the site let's click it and see what's it return to us

let's look into `index.js`
and learn something from there HINT:
message from JAVA should you should look into `/beginner/demo/demo/src/main/java/controller.HelloController.java`  
see the `@RequestMapping` that point to `"/hello"` and now see the function in javascript where do we call

### Exercise

in `index.js` try to make `helloExercise()` to hook up the another from message from `ExerciseController.java`

#### Learn more

- learn more about async await [here](https://tcd-theme.com/2021/09/javascript-asyncawait.html)
