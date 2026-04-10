package DS;

/*
* #1
srcDir  → destDir
Read all the files parallelly from srcDir and write to destDir sequentially (sort by name).
ex:
f1, f2, f3.
T0: start reading
f1: 0 → 2 mins
f2: 0 → 15 mins
f3: 0 → 5 mins
--
T2:  f1 write..
T5: …
T15: f2 write.. + f3 write..
*
*
*
*
* #2
e-Commerce:

Products, Categories, Orders, OrderItems..

→ DB design
→ High Level architecture.
→ Order workflow

DB Schema;
Table
    products(id(PK), name, description, price, subcategory_id(FK), created_at, modified_at)
    categories(id(PK), name, tags, created_at, modified_at)
    subcategories(id, category_id, name, created_at, modified_at)
    category_subcategory_mapping(id, category_id, subcategory_id, created_at)
    orders(id, user_id, amount_payable, status, created_at, modified_at)
    orderitems(id, order_id, product_id, quantity, price, created_at)

    we can use springboot application
    MVC architecture
    Controller
        ProductController
           GET /api/v1/products
           GET /api/v1/products/{id}
           POST /api/v1/products
           PUT /api/v1/products/{id}
    Service

    Repository(DB-layer)

    Product service
    OrderService

    user --> wesbite UI --> product serarch -->



*
*
*
* */



public class FileReadWrite {


}
