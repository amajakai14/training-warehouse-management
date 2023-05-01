# 第4回レッスン

## データベースにデータを追加する
取り組む前に・・・
- Eventlistenerについて詳しくは[こちら](https://www.w3schools.com/js/)
  
- [こちらも参考に](js_htmldom_eventlistener.asp)

- Spring Bootについて詳しくは[こちら](https://midorigame-jo.com/spring-requestmapping/)

- アノテーションについて詳しくは[こちら](https://www.sejuku.net/blog/22694)

- [こちらも参考に](https://www.tairaengineer-note.com/springboot-http-status-code)

### チュートリアル

もう一度 `DemoApplication` を実行する。

order.html` ファイルを開く

#### step3から`order.htmlに追加されたもの

- オートロードでオーダーテーブルを表示する
- 各行の編集ボタン
- 編集ボタンをクリックすると、ポップアップ画面で各注文が確認できる。
- サーバーに編集要求を送る編集機能

#### 今回の目標
- `order.html``order.js`を参照し、`exercise.html``exercise。js`をデータベース更新画面を作成
- Javaを編集して、更新に必要なコードの構築
- html上の機能しない`appdate manu`機能を動作させ、データベース更新に必要な技能を取得する

この工程では、主に
- リクエストの受信(Controller)
- 処理の委譲(Service)
- データベース接続(Repository)
- 
の処理を構築する必要があります。

- 既に登録されているデータをどうやって取り出すか？
- その内容を更新するのはどうするのか?
を考えながら取り組んでください。


[HINT]
- Spring Bootでよく使われるアノテーション(https://qiita.com/kenny_J_7/items/79a36d14dd6c892ae430)
