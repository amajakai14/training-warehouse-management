# Sixth lesson

## Migration

you might have questions every time the application restart. the data always reset to the original.  
that's what a migration play a role.  
let's look into `./beginner/demo/demo/src/main/resources/`

- there are `db/migration` and `local/testdata` packages and that's where the migration are
  - also programatical config in `src/main/java/com/excelence/demo/config/FlywayConfig.java`
- if the migration file has changed and there's a conflict. locally it is fine to just reset your database and run the new version of migration
  Usually, in a production you should not change the Migration Files else it might break the table or make the data loss forever  
  so what you need is to add a new migration files

### Exercise

- Add next migration file let's name it `V000006_add_price_menu.sql` with the code below

```sql
ALTER TABLE example_menu ADD COLUMN price decimal(10, 2);
```

now run an application again see the real data in `PGADMIN` the price column should be added null

- but where those `Carrot` `玉ねぎ` `和牛` came from ?
  - the `local/testdata` package has a initial data that will always delete data from specified tables and add the data init
    - let's also add price into all those example_menu data and see if it works

---

### Congratulations Again!

you are now learn all what needed to build an application  
from now on combine those knowledge and start you own journey! looking forward to your potential!
