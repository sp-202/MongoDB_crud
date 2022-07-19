# MongoDB CRUD Application

There is two controller which basically handles user register and new product register

## API Reference

#### Create a new user

`POST /order/create_user`

| Parameter | Request-body       | Description            |
|:----------|:-------------------|:-----------------------|
| `none`    | `application/json` | To register a new user |

#### Palace order

`PUT /order/place_order/{uuid}/{product_name}`

| Parameter                   | Request-body       | Description                                                |
|:----------------------------|:-------------------|:-----------------------------------------------------------|
| `uuid` <br/> `product_name` | `application/json` | **Required**. uuid of user and product name to place order |

#### Get user by username

`GET /order/getuser/{name}`

| Parameter | Path-variable | Description                    |
|:----------|:--------------|:-------------------------------|
| `name`    | `username`    | **Required**. username of user |

#### Get user by username

`GET /order/getuser_by_address/{address}`

#### Get user by username

| Parameter | Path-variable | Description                                          |
|:----------|:--------------|:-----------------------------------------------------|
| `address` | `address`     | **Required**. address <br/> `Only admin can do this` |

#### Get user by username

`DELETE /order/delete_user/{username}`

| Parameter  | Path-variable | Description                    |
|:-----------|:--------------|:-------------------------------|
| `username` | `username`    | **Required**. username of user |

#### To register a new product

`POST /products/create_product`

| Parameter | Request-body       | Description                                                        |
|:----------|:-------------------|:-------------------------------------------------------------------|
| `none`    | `application/json` | To register a new product <br/> `Only product manager can do this` |
