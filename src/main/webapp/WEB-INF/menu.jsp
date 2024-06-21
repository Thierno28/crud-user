<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Navbar Améliorée</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet">
    <style>
        .navbar-custom {
            background: linear-gradient(45deg, #5a9, #3a7);
        }
        .navbar-brand-custom {
            font-family: 'Cursive', sans-serif;
            font-size: 1.5rem;
        }
        .nav-link {
            font-size: 1.1rem;
        }
        .btn-custom {
            transition: background-color 0.3s ease;
        }
        .btn-custom:hover {
            background-color: #333;
            color: #fff;
        }
    </style>
</head>
<body>
<nav class="shadow rounded mb-5 navbar navbar-expand-sm navbar-light navbar-custom justify-content-between">
    <div class="container">
        <a class="navbar-brand navbar-brand-custom" href="#">CrudUser</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value='/Liste' />"><i class="fas fa-list"></i> Lister</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value='/AddUser'/>"><i class="fas fa-user-plus"></i> Ajouter</a>
                </li>
            </ul>
            <ul class="navbar-nav">
                <c:choose>
                    <c:when test="${sessionScope.isConnected != null}">
                        <li class="nav-item">
                            <a class="btn btn-danger text-light nav-link btn-custom" href="<c:url value='/Logout' />"><i class="fas fa-sign-out-alt"></i> Se Déconnecter</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item">
                            <a class="btn btn-primary text-light nav-link btn-custom" href="<c:url value='/Auth' />"><i class="fas fa-sign-in-alt"></i> Se Connecter</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </div>
</nav>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
