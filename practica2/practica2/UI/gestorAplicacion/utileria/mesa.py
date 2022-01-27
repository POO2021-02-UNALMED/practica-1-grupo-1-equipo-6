# Clase Mesa
# Importante en la funcionalidad de administrar y verificar el estado del restaurante
class Mesa:
    # La crea y considera si la mesa está disponible o no
    def __init__(self, disponibilidad, numero, sillas):
        from gestorAplicacion.utileria.restaurante import Restaurante
        self.disponibilidad = disponibilidad
        self.numero = numero
        self.sillas = sillas
        self.cliente = None
        if self.disponibilidad:
            Restaurante.getMesasDisponibles().append(self)
        else:
            Restaurante.getMesasReservadas.append(self)
    # Sets y gets

    def isDisponibilidad(self):
        return self.disponibilidad

    def setDisponibilidad(self, disponibilidad):
        self.disponibilidad = disponibilidad

    def getNumero(self):
        return self.numero

    def setNumero(self, numero):
        self.numero = numero

    def getSillas(self):
        return self.sillas

    def setSillas(self, sillas):
        self.sillas = sillas

    def getCliente(self):
        return self.cliente

    def setCliente(self, cliente):
        self.cliente = cliente
