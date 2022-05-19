# Generated by Django 3.2.5 on 2021-07-07 05:14

from django.conf import settings
from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    initial = True

    dependencies = [
        migrations.swappable_dependency(settings.AUTH_USER_MODEL),
    ]

    operations = [
        migrations.CreateModel(
            name='Categoria',
            fields=[
                ('idCategoriaZapatilla', models.IntegerField(primary_key=True, serialize=False, verbose_name='Id de categoría')),
                ('nombreCategoriaZapatilla', models.CharField(max_length=80, verbose_name='Nombre de la categoría')),
            ],
        ),
        migrations.CreateModel(
            name='Zapatilla',
            fields=[
                ('numero', models.CharField(max_length=6, primary_key=True, serialize=False, verbose_name='Numero')),
                ('marca', models.CharField(max_length=80, verbose_name='Marca zapatilla')),
                ('modelo', models.CharField(blank=True, max_length=80, null=True, verbose_name='Modelo zapatilla')),
                ('imagen', models.ImageField(default='sinfoto.jpg', upload_to='images/', verbose_name='Imagen')),
                ('precio', models.DecimalField(decimal_places=2, max_digits=35, verbose_name='Precio')),
                ('categoria', models.ForeignKey(on_delete=django.db.models.deletion.DO_NOTHING, to='core.categoria')),
            ],
        ),
        migrations.CreateModel(
            name='PerfilUsuario',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('rut', models.CharField(blank=True, max_length=80, null=True, verbose_name='Rut')),
                ('direccion', models.CharField(blank=True, max_length=80, null=True, verbose_name='Dirección')),
                ('user', models.OneToOneField(on_delete=django.db.models.deletion.CASCADE, to=settings.AUTH_USER_MODEL)),
            ],
        ),
    ]
