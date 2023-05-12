# step5 データベースの削除
## チュートリアル

もう一度 `DemoApplication` を実行する。

`order.html` ファイルを開く。

### 今回の課題

`order.html`に削除ボタンが追加されています。そのボタンを動作させてみましょう。

step3.4で行った動作を思い出し、活用しながら進めてください。

[HINT]

[asyncについて](https://qiita.com/soarflat/items/1a9613e023200bbebcb3)

[メソッドと削除処理](https://midorigame-jo.com/spring-requestmapping/)

[↑関連資料](https://qiita.com/soarflat/items/1a9613e023200bbebcb3)
 
最後のステップに行く前に、基礎的なことをもう一度思い出しましょう

- [APIとは](https://aws.amazon.com/what-is/api/)
- [Gitとは](https://www.sejuku.net/blog/5756)
- [HTMLとCSS](https://fastcoding.jp/blog/all/jquery/html-css-javascript/)
- [こちらも参考に] (https://www.pc-master.jp/words/html-css.html)
- [Javascript](https://www.javadrive.jp/javascript/)

### EXTRA

- この[説明](https://yu-report.com/entry/postman/)に従ってPostmanをインストールします。
  - [POSTMANの使用例](https://rainbow-engine.com/postman-howto-intro/)
  - POSTMANとは？
　　
　  =APIのテストを行うためのツール。

　  手早くHTTPリクエストを送信してエンドポイントが正しく機能しているか確認することができます。
  - 今度は`POSTMAN`を使ってJavaサーバーにアクセスしてみましょう。
    `fetch` 関数のように、`URL endpoint` と `HTTP METHOD` を追加し、必要に応じて `JSON` BODY を追加する。
    
    JAVAアプリケーションからすべてのCRUDサービスにアクセスする。
      
    例えば、`http://localhost:8080/orders/1`は、id = 1の注文レコードを取得する。
