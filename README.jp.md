# 研修　Step3

## データの追加

## Tutorialを行う前に
以下の参考サイトは、本プロジェクトでのクライアント(UI)とサーバー(Java)のデータのやり取りにおいて、  
非常に重要です。
Tutorialを行う前に、確認しておきましょう。
- RESTapiについては[こちら](https://tech.012grp.co.jp/entry/rest_api_basics)
- CRUD機能については[こちら](https://qiita.com/fukuma_biz/items/a9e8d18467fe3e04068e)
- fetch関数については[こちら](https://developer.mozilla.org/en-US/docs/Web/API/Fetch_API/Using_Fetch)
- jsonについては[こちら](https://cloudapi.kddi-web.com/magazine/json-javascript-object-notation)
- HTTPステータスについては[こちら](https://digital-marketing.jp/seo/http-status-code/)
- Springフレームワークのアノテーションについては[こちら](https://camp.trainocate.co.jp/magazine/spring-annotation/)

## Tutorial

`DemoApplication`を起動しましょう。

`order.html`ファイルを開きましょう。
新たなorderを追加するための入力フォームが表示されます。  
orderを追加して、何が起こるか見てみましょう。

また、以下の質問について考えながら、Step3を進めていきましょう。  
Step3が終わるころには、理解できているはずです。

- UI(JavaScript)
  - [formData](https://magazine.techacademy.jp/magazine/21089)とは何ですか？
  - fetch関数の第２引数である`method`, `headers`, `body`とは何ですか？
- server(Java)
  - `ExampleOrderRequest`クラスとは何でしょう？
  - `validate()`は何をするメソッドでしょう？
  - `Controller`, `Service`, `Repository`, `Datasource`で実装されているコードをチェックするとき、どうやって各クラスを行き来しますか？
    - ヒント : `Ctrl + b` や `Ctrl + Shift + b`のショートカットキーを試してみましょう。

## Exercise

`exercise.html`を開き、データベースにデータを追加する機能を実装しましょう。  
Step3からは、`JavaScript`,`HTML`も編集する必要があります。  
Javaに取り掛かる前に、UI側からコードを構築していくと良いでしょう。  
また、JavaはStep2と比べて、クラスも増え、より複雑になっています。  
まずは、Orderのコードを見て、それぞれのクラスの意味と繋がりを考えてみましょう。   
分からないところがあったら、どんどん質問してください！

### マイグレーション

今回の研修ではデータベースにデータを追加しても、サーバーを再起動すると,追加したデータは消えていると思いますが、
これは、サーバーを起動するたびにデータがリセットされるように設定されているためです。  
このことはマイグレーションと呼ばれています。 
詳しくはStep6で学びます。
