# 研修 Step2　

## データベースの参照

#### データベースの起動

 Dockerが起動していなければ、起動させておきましょう。

- `./beginner/demo/demo/local/start.sh`
  - データベースのリセットもできます。

### ツールのインストール

データベースの中身を見るには、以下のようなGUIアプリケーションが利用できます。

- [こちら](https://www.pgadmin.org/download/)から`PGAdmin4`をインストールします。
  - [インストール方法](https://qiita.com/pyon_kiti_jp/items/01d6150e46bd66be29f0)
- インストール後
  - serverを右クリック
  - -> `General`タブでNAME:warehouseを入力
  - -> `Connection`タブでHOSTname/address:`localhost`, Port:`5432`, Maintenance database: `warehouse`, Username: `warehouseuser`, Password:`warehousepassword`, -> savepassword: click `ON`
- `Intellij`で`DemoApplication`をRun
  - pgAdmin4で warehouse server -> databases -> `warehouse` -> `Schemas` -> `Tables` -> `example_menu` テーブルが表示されます
  - ダブルクリック -> `View/Edit Data` -> `All Rows` -> 用意されたデータが表示されます。
  これらをTutorialで使用します。

## Tutorial

`DemoApplication`を実行しましょう。

`order.html`ファイルを開き、ボタンをクリックすると、`example_order`と同じデータが表示されます。
`order.js`ファイルを見てみましょう。  
サーバーの呼び出しがあります。

`Intellij`を見ると、いくつかのファイルとフォルダが追加されていると思います。  
それぞれのフォルダの意味を説明しておきます。

- Controller
  - Controllerは、クライアントとの架け橋です。クライアントがリクエストを送信すると、まずControllerに送信され、処理が完了すると、クライアントに返信されます。
- Service
  - Serviceは、このアプリケーションがどのような処理を行うかを決定するものです。今回の例では、全ての注文を得ることができます。
- Repository
  - Repositoryは、複雑なコードを隠すことができるインターフェースです。インターフェースの活用はコードをよりシンプルに、見やすくすることができます。
- Datasource
  - Datasourceは、Repositoryから複雑なコードを実装するものです。今回の例では、デーアベースに接続し、SQL文を実行します。
- Model
  - Modelは、このアプリケーションにどのようなデータの型があるかを宣言します。

それぞれのクラスがどのように繋がっているのかを、理解してみましょう。

### アノテーション

controllerクラスでは、アノテーションと呼ばれる`＠`がたくさんあります。
これは`Spring Boot`と呼ばれるJavaフレームワークの中にある、特殊なJavaのコードです。
詳しくは下記の`learn more`で紹介していますのでそちらを参照して下さい。

- `@RestController`はこのクラスがControllerであることをJavaに伝えるものです。
- `@RequestMapping`はURLへのリクエスト時にパスをマッピングするものです。  
今回の場合では、`http://localhost:8080{mapping}` -> `http://localhost:8080/orders`
- `@GetMapping`は`GET`メソッドを使って、このエンドポイントにアクセスできることを伝えます。
  - `(produces = "application/json")`は、クライアントへのレスポンスのデータ型をjsonに指定し、それをOrderResponseにマッピングします。
- `@HttpStatus`　インターネットを閲覧していると、`Error404`を見ることがあります。これが HttpStatusであり、各コードの意味は全て定義されています。

## Exercise

`exercise_html`ファイルを開くと、`get menus`ボタンがあると思います。  
ボタンを押すと、`example_menu`のテーブルが表示されるようにしましょう。  
ヒント：コードが不十分なのは、`MenuDatasource`、`MenuController`、`MenusResponse`です。  
それぞれのクラスにはヒントとなるコメントが書かれていると思います。  
しかし、３つのクラスを見ているだけでは、コードは完成しないでしょう。  
Tutorialを見ながら、それぞれのクラスがどう繋がっているのかをしっかり理解しましょう。  
３つのクラスのコードを完成させて、テーブル表示機能を実装しましょう！

#### Learn more

- RESTapiについては[こちら](https://tech.012grp.co.jp/entry/rest_api_basics)
- fetch()関数については[こちら](https://developer.mozilla.org/en-US/docs/Web/API/Fetch_API/Using_Fetch)
- jsonについては[こちら](https://cloudapi.kddi-web.com/magazine/json-javascript-object-notation)
- http statusについては[こちら](https://digital-marketing.jp/seo/http-status-code/)
- springフレームワークのアノテーションについては[こちら](https://camp.trainocate.co.jp/magazine/spring-annotation/)
