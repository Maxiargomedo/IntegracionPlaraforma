from django.contrib import admin
from .models import Categoria, Zapatilla, PerfilUsuario

# Register your models here.

admin.site.register(Categoria)
admin.site.register(Zapatilla)
admin.site.register(PerfilUsuario)