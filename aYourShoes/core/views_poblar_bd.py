from django.shortcuts import redirect
from django.contrib.auth.models import User
from .models import Zapatilla, Categoria, PerfilUsuario
from .views import administrar_productos

def poblar_bd(request):
    try:
        print("Verificar si existe usuario cliente.")
        if User.objects.filter(username="usuario_cliente").exists():
            print("Intentando eliminar usuario cliente.")
            User.objects.get(username="usuario_cliente").delete()
            print("Usuario cliente eliminado.")
        print("Iniciando creación de usuario cliente.")
        user = User.objects.create_user(username="usuario_cliente", password='Duoc@123')
        user.first_name = "Chris"
        user.last_name = "Evans (Cliente)"
        user.email = "cevans@marvel.com"
        user.is_superuser = False
        user.is_staff = False
        PerfilUsuario.objects.create(user=user, rut="11.111.111-K", direccion="Burbank (Estados Unidos)")
        user.save()
        print("Usuario cliente fue creado correctamente.")
    except Exception as err:
        print(f"Error al crear usuario cliente: {err}")
    try:
        print("Verificar si existe usuario staff.")
        if User.objects.filter(username="usuario_staff").exists():
            print("Intentando eliminar usuario staff.")
            User.objects.get(username="usuario_staff").delete()
            print("Usuario staff eliminado.")
        print("Iniciando creación de usuario staff.")
        user = User.objects.create_user(username="usuario_staff", password='Duoc@123')
        user.first_name = "Pepper"
        user.last_name = "Potts (Staff)"
        user.email = "ppotts@tiendastark.com"
        user.is_superuser = True
        user.is_staff = True
        PerfilUsuario.objects.create(user=user, rut="22.222.222-K", direccion="Burbank (Estados Unidos)")
        user.save()
        print("Usuario staff fue creado correctamente.")
    except Exception as err:
        print(f"Error al crear usuario staff: {err}")
    try:
        Zapatilla.objects.all().delete()
        print("Tabla Zapatilla fue truncada.")
        Categoria.objects.all().delete()
        print("Tabla Categoria fue truncada.")
        print("Iniciar poblamiento de tabla Categoria.")
        Categoria.objects.create(idCategoria=1, nombreCategoria="zapato")
        Categoria.objects.create(idCategoria=2, nombreCategoria="zapatilla")
        Categoria.objects.create(idCategoria=3, nombreCategoria="chalas")
        print("Tabla Categoria fue poblada.")
    except Exception as err:
        print(f"Error al poblar tabla Categoria: {err}")
    try:
        print("Iniciar poblamiento de tabla Zapatilla.")
        Zapatilla.objects.create(numero="30", marca='Nike', modelo="Adapt BB", imagen="images/compra1.2.mini.png", precio=700000000, categoria=Categoria.objects.get(idCategoria=2))
        Zapatilla.objects.create(numero="32", marca='adidas', modelo="Adapt BB", imagen="images/compra6.2.png", precio=600000000, categoria=Categoria.objects.get(idCategoria=2))
        Zapatilla.objects.create(numero="36", marca='champion', modelo="Adapt BB", imagen="images/compra2.2.png", precio=600000000, categoria=Categoria.objects.get(idCategoria=2))
        Zapatilla.objects.create(numero="37", marca='Nike', modelo="Adapt BB", imagen="images/compra3.3.png", precio=800000000, categoria=Categoria.objects.get(idCategoria=2))
        Zapatilla.objects.create(numero="38", marca='Nike', modelo="Adapt BB", imagen="images/compra4.2.png", precio=700000000, categoria=Categoria.objects.get(idCategoria=2))
        Zapatilla.objects.create(numero="40", marca='Nike', modelo="Adapt BB", imagen="images/compra5.2.png", precio=600000000, categoria=Categoria.objects.get(idCategoria=2))
        print("Tabla Zapatilla fue poblada.")
    except Exception as err:
        print(f"Error al poblar zapatilla: {err}")
    return redirect(administrar_productos, action='ins', id = '-1')