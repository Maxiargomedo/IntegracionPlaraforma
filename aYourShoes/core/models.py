from django.db import models
from django.contrib.auth.models import User

class Categoria(models.Model):
    idCategoriaZapatilla = models.IntegerField(primary_key=True, verbose_name="Id de categoría")
    nombreCategoriaZapatilla = models.CharField(max_length=80, blank=False, null=False, verbose_name="Nombre de la categoría")

    def __str__(self):
        return f"{self.idCategoriaZapatilla} - {self.nombreCategoriaZapatilla}"

class Zapatilla(models.Model):
    numero = models.CharField(max_length=6, primary_key=True, verbose_name="Numero")
    marca = models.CharField(max_length=80, blank=False, null=False, verbose_name="Marca zapatilla")
    modelo = models.CharField(max_length=80, null=True, blank=True, verbose_name="Modelo zapatilla")
    imagen = models.ImageField(upload_to="images/", default="sinfoto.jpg", null=False, blank=False, verbose_name="Imagen")
    precio = models.DecimalField(max_digits=35, decimal_places=2, null=False, blank=False, verbose_name="Precio")
    categoria = models.ForeignKey(Categoria, on_delete=models.DO_NOTHING)
    

    def __str__(self):
        return f"{self.numero} - {self.marca}, {self.modelo}"

class PerfilUsuario(models.Model):
    user = models.OneToOneField(User, on_delete=models.CASCADE)
    rut = models.CharField(max_length=80, blank=True, null=True, verbose_name="Rut")
    direccion = models.CharField(max_length=80, blank=True, null=True, verbose_name="Dirección")

    def __str__(self):
        return f"{self.user.username} - {self.user.first_name} {self.user.last_name} ({self.user.email})"