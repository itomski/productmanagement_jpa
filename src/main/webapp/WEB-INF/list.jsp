<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                <h1>Produkte</h1>
            </div>
        </div>

        <div class="row">
            <div class="col">
                <p><a href="products?a=form" class="btn btn-dark">Neues Produkt</a></p>
            </div>
        </div>

        <div class="row">
            <div class="col-sm-6">
                <form method="get" action="products" id="searchForm">
                    <div class="row">
                        <div class="col-auto">
                            <input type="text" name="s" id="searchText" placeholder="Suchtext" class="form-control">
                        </div>
                        <div class="col-auto">
                            <button type="submit" class="btn btn-dark">Suchen</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>

        <div class="row">
            <div class="col">

                <!-- table.table>(thead>tr>th*5)+(tbody>tr>td*5) -->
                <table class="table">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Beschreibung</th>
                            <th>Preis</th>
                            <th>&nbsp;</th><!-- &nbsp; = geschütztes Leerzeichen -->
                        </tr>
                    </thead>
                    <tbody id="tabContent">
                        <%-- for(Product p : products)  --%>
                        <c:forEach items="${products}" var="p">
                            <tr>
                                <td>${p.id}</td>
                                <td>${p.name}</td>
                                <td>${p.description}</td>
                                <td><f:formatNumber value="${p.price}" type="currency" currencySymbol="€" /></td>
                                <td></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </main>

    <script src="webjars/bootstrap/5.2.3/js/bootstrap.bundle.min.js"></script>

    <script>
        // getElementById sucht das Objekt
        // addEventListener hängt eine Funktion an eine gewünschte Interaktion mit Element
        document.getElementById("searchForm").addEventListener('submit', (event) => {
            event.preventDefault(); // Verhindert, dass sofort die Ressource im action angesteuert wird

            const data = new URLSearchParams();
            data.append('s', document.getElementById('searchText').value); // Was wurde iin das Suchfeld eingetragen
            fetch('api?' + data) // Suchtext an die API schicken
            .then((resp) => resp.json()) // JSON aus der API-Antwort parsen
            .then((json) => { // JSON zu Tabelen-Zeilen verarbeiten
                var tableContent = ''
                for(var i = 0; i < json.length; i++) {
                    tableContent += '<tr>';
                    tableContent += '<td>' + json[i].id + '</td>';
                    tableContent += '<td>' + json[i].name + '</td>';
                    tableContent += '<td>' + json[i].description + '</td>';
                    tableContent += '<td>' + json[i].price + '</td>';
                    tableContent += '</tr>';
                }
                // Erzeugte Zeilen der Tabele hinzufügen
                let tbody = document.getElementById("tabContent");
                //tbody.classList.add("table-danger");
                tbody.innerHTML = tableContent;
                //tbody.classList.remove("table-danger")
            });
        });
    </script>
</body>
</html>