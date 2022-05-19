from django.urls import path
from django.views.generic.base import TemplateView
from django.contrib.auth import views as auth_views
from .views import home, administrar_productos, tienda, ficha
from .views import iniciar_sesion, registrar_usuario, cerrar_sesion
from .views import perfil_usuario, iniciar_pago, pago_exitoso
from .views_poblar_bd import poblar_bd
from .views import carroCompras, contactanos, historiaZa, index, politicas, producto8, producto9, producto10, respuesta, seccionDeportes, sobreNosotros, terminos

urlpatterns = [
    path('', index, name="index"),
    path('poblar_bd', poblar_bd, name="poblar_bd"),
    path('administrar_productos/<action>/<id>', administrar_productos, name="administrar_productos"),
    path('tienda', tienda, name="tienda"),
    path('ficha/<id>', ficha, name="ficha"),
    path('iniciar_sesion/', iniciar_sesion, name="iniciar_sesion"),
    path('cerrar_sesion/', cerrar_sesion, name='cerrar_sesion'),
    path('registrar_usuario/', registrar_usuario, name="registrar_usuario"),
    path('password_cambiada/', TemplateView.as_view(template_name='core/password_cambiada.html'), name='password_cambiada'),
    path('cambiar_password/', auth_views.PasswordChangeView.as_view(template_name='core/cambiar_password.html', success_url='/password_cambiada'), name='cambiar_password'),
    path('perfil_usuario/', perfil_usuario, name="perfil_usuario"),
    path('iniciar_pago/', iniciar_pago, name="iniciar_pago"),
    path('pago_exitoso/', pago_exitoso, name="pago_exitoso"),
    path('carroCompras', carroCompras, name="carroCompras"),
    path('contactanos', contactanos, name="contactanos"),
    path('historiaZa', historiaZa, name="historiaZa"),
    path('home', home, name="home"),
    path('politicas', politicas, name="politicas"),
    path('producto8', producto8, name="producto8"),
    path('producto9', producto9, name="producto9"),
    path('producto10', producto10, name="producto10"),
    path('respuesta', respuesta, name="respuesta"),
    path('seccionDeportes', seccionDeportes, name="seccionDeportes"),
    path('sobreNosotros', sobreNosotros, name="sobreNosotros"),
    path('terminos', terminos, name="terminos"),
]