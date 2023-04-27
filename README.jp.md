# 研修　Step1

## 開発ツールのインストール

### Gitの導入

- `GitHub`の[公式サイト](https://github.co.jp)からアカウントを作成し、リポジトリにアクセスします。
- `Git` を[公式サイト](https://git-scm.com/downloads)からインストールします。
  - Windowsの方は `Git Bash`もインストールします。
- このリポジトリを[Fork](https://docs.github.com/ja/get-started/quickstart/fork-a-repo)します。
- ローカル上の任意の場所にリポジトリのクローンを作成します。
  - `git bash`もしくは `terminal`を起動します。
  - `cd` コマンドでリポジトリをクローンしたいフォルダに移動します。
  - 下記のコマンドを入力して下さい。
  - `git clone [リポジトリのURL]`
- `Fork` を[こちら](https://git-fork.com/)からインストールします。
  - Forkの使い方は[こちら](https://qiita.com/AyakoKataoka/items/e1b0a2a2b2c85de4c1e3)

### Javaのインストール・環境変数の設定

- [こちら](https://www.oracle.com/java/technologies/downloads/#java11)のサイトから`JDK11` をインストールします。
  - **`JDK11`をどこにインストールしたのか、確認しておいてください。**
  - **必ず、`JDK11`をインストールしてください。他のverだと正常に動作しない可能性があります。**
  - **インストールの際は、Oracleのアカウントが必要になります。**

- 環境変数を設定します。
    - システムの環境変数に、JDK のパスを指定
    - 変数名：JAVA_HOME
    - 変数値：{JDK をインストールしたフォルダ}
    - システムの環境変数の Path を開く
    - [新規(N)]ボタンをクリックすると　{JDK をインストールしたフォルダ}\bin 　を入れる
    - 参考サイトは[こちら](https://qiita.com/niwasawa/items/460ccd0fa0041e7a2491)

### 開発環境のインストール

- [こちら](https://www.jetbrains.com/idea/download/#section=windows)から`Intellij` をインストールします。
- `Intellij`の設定
  - File -> New Project -> Project from existing source -> `beginner/demo/demo` -> import project from external model -> `Gradle`
  - files -> Project Structure -> SDK -> select sdk version 11 from the one you downloaded above
  - [faq](https://github.com/amajakai14/training-warehouse-management/tree/step1-client-and-server/faq)
- [こちら](https://code.visualstudio.com/)から`VSCode`をインストールします。
  - 下記の拡張機能をインストールしておいて下さい。（
  [参考サイト](https://qiita.com/KNR109/items/5f933df1292564e6dc70)）
      - HTML CSS Support
      - Javascript (ES6) code snippets
      - Live Server
- [こちら](https://docs.docker.com/desktop/install/windows-install/)から`Docker Desktop` をインストールします。
  - [参考サイト](https://www.kagoya.jp/howto/cloud/container/wsl2_docker/)

### データベースの起動

Tutorialに移る前にDockerを起動しておく必要があります。
- `git bash`もしくは `terminal`を起動します。
  - `cd` コマンドでこのプロジェクトをクローンしたフォルダに移動します。
  - こちらのコマンドを入力して下さい。
  `./beginner/demo/demo/local/start.sh`

## クライアントとサーバー

このプロジェクトでは、コードを２つのパートに分割しています。
- クライアント
   - クライアント側は、HTML ,CSS ,JavaScriptで書かれています。
- サーバー
   - サーバー側は、今回のプロジェクトでは、Javaで書かれています。

### クライアントとサーバーに分割する理由
- 通常、クライアント側では、クライアント（サービスを利用する人）がデータの閲覧、追加、更新、削除などのデータの操作を行います。我々は、ユーザーが画面を使って操作できるようにUIを提供します。
- 一方、サーバー側は、クライアント側から送られてきたストレージへのアクションを受け取ります。（このプロジェクトでは、ストレージにPostgresデータベースを利用します。）


## Tutorial
Javaコードは`IntelliJ`で、HTML,javascript,cssは`VScode`で編集しましょう。

ますは、サーバーを立ち上げましょう。  
intellijを開く -> open -> training-warehouse-management -> beginner -> demo -> demo

DemoApplication.javaを左クリック -> `Run DemoApplication.main()` or `実行`  
terminalで
`Tomcat started on port(s): 8080 (http)`
と表示されれば、成功です。  
ブラウザで`localhost:8080/hello` と入力すると、
メッセージが表示されるはずです。

vscodeを開く -> open -> training-warehouse-management  
`beginner` フォルダの`ui`フォルダを開き、`index.html`ファイルを開いてみましょう。  
３つのボタンがあると思います。
それぞれクリックして、何が表示されるか見てみましょう。

次に`index.js`ファイルを開き、コードを読んでみましょう。  
ヒント :
 - 左のボタンは、Javaからのメッセージです。
`/beginner/demo/demo/src/main/java/controller.HelloController.java` を見ると良いでしょう。 
 - 真ん中のボタンは、JavaScriptからのメッセージです。  
`index.js`の1行目~3行目を見ると良いでしょう。

### Tutorialで重要な関数
  - Async/Awaitについては[こちら](https://tcd-theme.com/2021/09/javascript-asyncawait.html)





## Exercise
`index.js`の`helloExercise()`を編集し、
`ExerciseController.java`からのメッセージを表示させてみましょう。