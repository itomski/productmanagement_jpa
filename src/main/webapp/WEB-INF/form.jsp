<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="de">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="webjars/bootstrap/5.2.3/css/bootstrap.min.css">
    <title>Document</title>
</head>
<body>

<main class="container">
    <div class="row">
        <div class="col">
            <h1>Neues Produkt</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-6">
            <form action="products" method="post">

                <div class="mb-3">
                    <label for="name" class="form-label">Name</label>
                    <input type="text" class="form-control" name="name" id="name">
                </div>

                <div class="mb-3">
                    <label for="description" class="form-label">Name</label>
                    <textarea name="description" id="description" rows="10" class="form-control"></textarea>
                </div>

                <div class="mb-3">
                    <label for="price" class="form-label">Preis</label>
                    <input type="text" class="form-control" name="price" id="price">
                </div>

                <button type="submit" class="btn btn-dark">Speichern</button>
                <a href="products" class="btn btn-danger">Abbrechen</a>
            </form>
        </div>
    </div>
</main>

<script src="webjars/bootstrap/5.2.3/js/bootstrap.bundle.min.js"></script>
</body>
</html>
