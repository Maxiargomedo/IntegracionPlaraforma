import re
from django.shortcuts import render, redirect, get_object_or_404
from django.views.decorators import csrf
from rest_framework import status
from rest_framework.decorators import api_view, authentication_classes, permission_classes
from rest_framework.response import Response
from rest_framework.parsers import JSONParser
from django.views.decorators.csrf import csrf_exempt
from core.models import Zapatilla
from .serializers import ZapatillaSerializer
from rest_framework.parsers import MultiPartParser, FormParser
from rest_framework.views import APIView
from django.contrib.auth.models import User
from django.contrib.auth.hashers import check_password
from rest_framework.authtoken.models import Token
from rest_framework.authentication import TokenAuthentication
from rest_framework.permissions import IsAuthenticated

class zapatilla_create(APIView):
    def post(self, request, format=None):
        serializer = ZapatillaSerializer(data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

class zapatilla_update(APIView):
    def put(self, request, format=None):
        serializer = ZapatillaSerializer(data=request.data)
        if serializer.is_valid():
            serializer.update()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

@csrf_exempt
@api_view(['GET'])
@permission_classes((IsAuthenticated,))
def zapatilla_read(request, id):
    if request.method == 'GET':
        objeto = get_object_or_404(Zapatilla, numero=id)
        serializer = ZapatillaSerializer(objeto)
        return Response(serializer.data)

@csrf_exempt
@api_view(['GET'])
@permission_classes((IsAuthenticated,))
def zapatilla_read_all(request):
    if request.method == 'GET':
        list = Zapatilla.objects.all()
        serializer = ZapatillaSerializer(list, many=True)
        return Response(serializer.data)

@csrf_exempt
@api_view(['DELETE'])
@permission_classes((IsAuthenticated,))
def zapatilla_delete(request, id):
    if request.method == 'DELETE':
        try:
            Zapatilla.objects.get(numero=id).delete()
            return Response(status=status.HTTP_204_NO_CONTENT)
        except Zapatilla.DoesNotExist:
            return Response(status=status.HTTP_404_NOT_FOUND)

@api_view(['POST'])
def login(request):
    data = JSONParser().parse(request)
    username = data['username']
    password = data['password']
    try:
        user = User.objects.get(username=username)
    except User.DoesNotExist:
        return Response("Usuario inválido")
    password_valida = check_password(password, user.password)
    if not password_valida:
        return Response("Contraseña incorrecta")
    token, created = Token.objects.get_or_create(user=user)
    print(f"Este es el token creado: '{token.key}'")
    return Response(token.key)
