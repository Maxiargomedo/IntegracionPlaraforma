from rest_framework import serializers
from core.models import Zapatilla

class ZapatillaSerializer(serializers.ModelSerializer):
    class Meta:
        model = Zapatilla
        fields = ['numero', 'marca', 'modelo', 'imagen', 'precio', 'categoria']