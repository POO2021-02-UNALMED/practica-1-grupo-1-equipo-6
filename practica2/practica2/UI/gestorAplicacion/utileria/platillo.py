# Clase platillo
# Autor: Michael Moreno Valoyes
# Para tener la información especifica de los platillos presentes en el menú y poder agregarlo a las ordenes.
# Parte importante de la funcionalidad de facturación.

class Platillo:
    # Para crear el platillo
    def __init__(self, tiempo, nombre, tipo, ingredientes, precio, identificador, frecuencia):
        self.tiempo = tiempo
        self.nombre = nombre
        self.tipo = tipo
        self.ingredientes = ingredientes
        self.precio = precio
        self.identificador = identificador
        self.frecuencia = frecuencia
    # Métodos set y get:

    def getTiempo(self):
        return self.tiempo

    def setTiempo(self, tiempo):
        self.tiempo = tiempo

    def getNombre(self):
        return self.nombre

    def setNombre(self, nombre):
        self.nombre = nombre

    def getTipo(self):
        return self.tipo

    def setTipo(self, tipo):
        self.tipo = tipo

    def getIngredientes(self):
        return self.ingredientes

    def setIngredientes(self, ingredientes):
        self.ingredientes = ingredientes

    def getPrecio(self):
        return self.precio

    def setPrecio(self, precio):
        self.precio = precio

    def getIdentificador(self):
        return self.identificador

    def setIdentificador(self, identificador):
        self.identificador = identificador

    def getFrecuencia(self):
        return self.frecuencia

    def setFrecuencia(self, frecuencia):
        self.frecuencia = frecuencia
