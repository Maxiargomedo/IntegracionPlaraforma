from typing import Awaitable
from django.contrib.auth import login, logout, authenticate
from django.contrib.auth.forms import UsernameField
from django.contrib.auth.models import User
from django.shortcuts import redirect, render
from django.views.decorators.csrf import csrf_exempt
from django.urls import reverse_lazy
from .models import Zapatilla, PerfilUsuario
from .forms import ZapatillaForm, IniciarSesionForm
from .forms import RegistrarUsuarioForm, PerfilUsuarioForm
from transbank.error.transbank_error import TransbankError
from transbank.webpay.webpay_plus.transaction import Transaction
import random

def index(request):
    return render(request, "core/index.html")

def home(request):
    return render(request, "core/home.html")

def carroCompras(request):
    return render(request, "core/carroCompras.html")

def contactanos(request):
    return render(request, "core/contactanos.html")

def historiaZa(request):
    return render(request, "core/historiaZa.html")

def home(request):
    return render(request, "core/home.html")

def politicas(request):
    return render(request, "core/politicas.html")

def producto8(request):
    return render(request, "core/producto8.html")

def producto9(request):
    return render(request, "core/producto9.html")

def producto10(request):
    return render(request, "core/producto10.html")

def respuesta(request):
    return render(request, "core/respuesta.html")

def seccionDeportes(request):
    return render(request, "core/seccionDeportes.html")

def sobreNosotros(request):
    return render(request, "core/sobreNosotros.html")

def terminos(request):
    return render(request, "core/terminos.html")

def iniciar_sesion(request):
    data = {"mesg": "", "form": IniciarSesionForm()}

    print(request)
    if request.method == "POST":
        form = IniciarSesionForm(request.POST)
        if form.is_valid:
            username = request.POST.get("username")
            password = request.POST.get("password")
            user = authenticate(username=username, password=password)
            if user is not None:
                if user.is_active:
                    login(request, user)
                    return redirect(tienda)
                else:
                    data["mesg"] = "¡La cuenta o la password no son correctos!"
            else:
                data["mesg"] = "¡La cuenta o la password no son correctos!"
    return render(request, "core/iniciar_sesion.html", data)

def cerrar_sesion(request):
    logout(request)
    return redirect(index)

def tienda(request):
    data = {"list": Zapatilla.objects.all().order_by('numero')}
    return render(request, "core/tienda.html", data)

#https://www.transbankdevelopers.cl/documentacion/como_empezar#como-empezar
#https://www.transbankdevelopers.cl/documentacion/como_empezar#codigos-de-comercio
#https://www.transbankdevelopers.cl/referencia/webpay

# Tipo de tarjeta   Detalle                        Resultado
#----------------   -----------------------------  ------------------------------
# VISA              4051885600446623
#                   CVV 123
#                   cualquier fecha de expiración  Genera transacciones aprobadas.
# AMEX              3700 0000 0002 032
#                   CVV 1234
#                   cualquier fecha de expiración  Genera transacciones aprobadas.
# MASTERCARD        5186 0595 5959 0568
#                   CVV 123
#                   cualquier fecha de expiración  Genera transacciones rechazadas.
# Redcompra         4051 8842 3993 7763            Genera transacciones aprobadas (para operaciones que permiten débito Redcompra y prepago)
# Redcompra         4511 3466 6003 7060            Genera transacciones aprobadas (para operaciones que permiten débito Redcompra y prepago)
# Redcompra         5186 0085 4123 3829            Genera transacciones rechazadas (para operaciones que permiten débito Redcompra y prepago)

@csrf_exempt
def iniciar_pago(request):
    print("Webpay Plus Transaction.create")
    buy_order = str(random.randrange(1000000, 99999999))
    session_id = request.user.username
    amount = random.randrange(10000, 1000000)
    return_url = 'http://127.0.0.1:8000/pago_exitoso/'

    response = Transaction.create(buy_order, session_id, amount, return_url)
    print(response.token)

    perfil = PerfilUsuario.objects.get(user=request.user)
    form = PerfilUsuarioForm()

    context = {
        "buy_order": buy_order,
        "session_id": session_id,
        "amount": amount,
        "return_url": return_url,
        "response": response,
        "token_ws": response.token,
        "url_tbk": response.url,
        "first_name": request.user.first_name,
        "last_name": request.user.last_name,
        "email": request.user.email,
        "rut": perfil.rut,
        "direccion": perfil.direccion,
    }

    return render(request, "core/iniciar_pago.html", context)

@csrf_exempt
def pago_exitoso(request):

    if request.method == "POST":
        token = request.POST.get("token_ws")
        print("commit for token_ws: {}".format(token))
        response = Transaction.commit(token=token)
        print("response: {}".format(response))

        user = User.objects.get(username=response.session_id)
        perfil = PerfilUsuario.objects.get(user=user)
        form = PerfilUsuarioForm()

        context = {
            "buy_order": response.buy_order,
            "session_id": response.session_id,
            "amount": response.amount,
            "response": response,
            "token_ws": token,
            "first_name": user.first_name,
            "last_name": user.last_name,
            "email": user.email,
            "rut": perfil.rut,
            "direccion": perfil.direccion,
        }

        return render(request, "core/pago_exitoso.html", context)
    
    return redirect(home)

@csrf_exempt
def ficha(request, id):
    data = {"mesg": "", "zapatilla": None}

    if request.method == "POST":
        if request.user.is_authenticated and not request.user.is_staff:
            return redirect(iniciar_pago)
        else:
            data["mesg"] = "¡Para poder comprar debe iniciar sesión como cliente!"

    data["zapatilla"] = Zapatilla.objects.get(numero=id)
    return render(request, "core/ficha.html", data)
 
@csrf_exempt
def administrar_productos(request, action, id):
    if not (request.user.is_authenticated and request.user.is_staff):
        return redirect(home)

    data = {"mesg": "", "form": ZapatillaForm, "action": action, "id": id}

    if action == 'ins':
        if request.method == "POST":
            form = ZapatillaForm(request.POST, request.FILES)
            if form.is_valid:
                try:
                    form.save()
                    data["mesg"] = "¡La zapatilla fue creado correctamente!"
                except:
                    data["mesg"] = "¡No se puede crear dos zapatillas con la misma numero!"

    elif action == 'upd':
        objeto = Zapatilla.objects.get(numero=id)
        if request.method == "POST":
            form = ZapatillaForm(data=request.POST, files=request.FILES, instance=objeto)
            if form.is_valid:
                form.save()
                data["mesg"] = "¡La zapatilla fue actualizado correctamente!"
        data["form"] = ZapatillaForm(instance=objeto)

    elif action == 'del':
        try:
            Zapatilla.objects.get(numero=id).delete()
            data["mesg"] = "¡La zapatilla fue eliminada correctamente!"
            return redirect(administrar_productos, action='ins', id = '-1')
        except:
            data["mesg"] = "¡La zapatilla ya estaba eliminada!"

    data["list"] = Zapatilla.objects.all().order_by('numero')
    return render(request, "core/administrar_productos.html", data)

def registrar_usuario(request):
    if request.method == 'POST':
        print("hola")
        form = RegistrarUsuarioForm(request.POST)
        print(1)
        if form.is_valid():
            print(2)
            user = form.save()
            print(3)
            rut = request.POST.get("rut")
            print(4)
            direccion = request.POST.get("direccion")
            print(5)
            PerfilUsuario.objects.update_or_create(user=user, rut=rut, direccion=direccion)
            print(6)
            return redirect(iniciar_sesion)
    form = RegistrarUsuarioForm()
    return render(request, "core/registrar_usuario.html", context={'form': form})

def perfil_usuario(request):
    data = {"mesg": "", "form": PerfilUsuarioForm}
    

    if request.method == 'POST':
        form = PerfilUsuarioForm(request.POST)
        if form.is_valid():
            user = request.user
            user.first_name = request.POST.get("first_name")
            user.last_name = request.POST.get("last_name")
            user.email = request.POST.get("email")
            user.save()
            perfil = PerfilUsuario.objects.get(user=user)
            perfil.rut = request.POST.get("rut")
            perfil.direccion = request.POST.get("direccion")
            perfil.save()
            data["mesg"] = "¡Sus datos fueron actualizados correctamente!"

    perfil = PerfilUsuario.objects.get(user=request.user)
    form = PerfilUsuarioForm()
    form.fields['first_name'].initial = request.user.first_name
    form.fields['last_name'].initial = request.user.last_name
    form.fields['email'].initial = request.user.email
    form.fields['rut'].initial = perfil.rut
    form.fields['direccion'].initial = perfil.direccion
    data["form"] = form
    return render(request, "core/perfil_usuario.html", data)