
step6 データベースの移行(migration)
アプリケーションを再起動するたびに、データは常に元通りにリセットされるようになっています。

./beginner/demo/demo/src/main/resources/を見てみましょう
db/migrationとlocal/testdataのパッケージがあり、そこにmigrationファイルがあります。

また、src/main/java/com/excelence/demo/config/FlywayConfig.javaにプログラムされたconfigがあります。

migrationファイルが変更され、競合が発生した場合ローカルではデータベースをリセットし、新バージョンのmigrationを実行すれば問題ありません。

しかし、実際の仕事ではmigrationファイルを安易に変更してはいけません。

そのためには、新しいmigrationファイルを追加することが必要です。

#　Exercise

V000006_add_price_menu.sqlというmigrationファイルを追加し、以下のコードを記述します。

ALTER TABLE example_menu ADD COLUMN price decimal(10, 2)；

もう一度アプリケーションを実行し、PGADMINの実際のデータを参照してください。

value(価格)の列にはNULLが記入されています。

[HINT]

[テーブル構造を変更する]https://www.javadrive.jp/mysql/table/index18.html

EXTRA
Carrot``玉ねぎ``和牛はどこから来たのでしょうか？

local/testdataパッケージには初期データがあり、指定したテーブルのデータを常に削除し、データを追加するようになっています。

これらのexample_menuのデータにvalueを追加して、動作するかどうか確認してみましょう。



改めておめでとうございます！

以上が、アプリケーションを作るのに必要なものの基本になります。

これからは、それらの知識を組み合わせて、自分の道を歩み始めましょう！