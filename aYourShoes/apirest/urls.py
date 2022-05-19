from django.urls import path
from django.contrib import admin
from .views import zapatilla_create, zapatilla_read, zapatilla_read_all
from .views import zapatilla_update, zapatilla_delete, login

urlpatterns = [
    path('zapatilla_create/', zapatilla_create.as_view(), name="zapatilla_create"),
    path('zapatilla_update/', zapatilla_update.as_view(), name="zapatilla_update"),
    path('zapatilla_read/<id>/', zapatilla_read, name="zapatilla_read"),
    path('zapatilla_read_all/', zapatilla_read_all, name='zapatilla_read_all'),
    path('zapatilla_delete/<id>/', zapatilla_delete, name="zapatilla_delete"),
    path('login', login, name='login'),
]