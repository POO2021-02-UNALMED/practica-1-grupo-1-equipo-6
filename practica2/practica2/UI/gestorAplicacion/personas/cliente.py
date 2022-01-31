# Los objetos de esta clase son los clientes del restaurante, ellos son quienes reservan, hacen pedidos y pagan.
# Clase cliente
# Autor: Santiago Salazar Ramirez
# Los objetos de esta clase son los clientes del restaurante, ellos son quienes reservan, hacen pedidos, y pagan

from gestorAplicacion.personas.persona import Persona


class Cliente(Persona):
    def __init__(self, nombre, documento):
        super().__init__(nombre, documento)
        # La mesa del cliente
        self.mesa = None
        # El pedido del cliente
        self.pedido = None
        # Los platillos que posee el cliente
        self.platillos = []
    # Agregamos los platillos del cliente

    def pedirOrden(self, platillosPedir):
        self.platillos.extend(platillosPedir)
    # Método reservar:
    # El método reservar recibe el identificador (int) de la mesa a reservar
    # luego verifica las mesas del restaurante y le asigna la mesa al cliente correspondiente

    def reservar(self, mesa):
        from gestorAplicacion.utileria.restaurante import Restaurante
        for elemento in Restaurante.getMesasDisponibles():
            if elemento.getNumero() == mesa:
                self.mesa = elemento
                self.mesa.setCliente(self)
                Restaurante.getMesasDisponibles().remove(self.mesa)
                Restaurante.getMesasReservadas().append(self.mesa)
                self.mesa.setDisponibilidad(False)
    # Método pagar:
    # El método pagar regresa el valor a pagar, sumando el precio de la lista de platillos del cliente

    def pagar(self):
        valorPagar = 0
        for i in range(0, len(self.platillos)):
            valorPagar += self.platillos[i].getPrecio()
        return valorPagar
    # Método irse:
    # El método irse regresa a la mesa a ser disponible, actualiza el número de mesas reservadas y disponibles.
    # En el objeto mesa elimina el cliente y quita al cliente de la mesa

    def irse(self):
        from gestorAplicacion.utileria.restaurante import Restaurante
        self.mesa.setDisponibilidad(True)
        Restaurante.getMesasReservadas().remove(self.mesa)
        Restaurante.getMesasDisponibles().append(self.mesa)
        self.mesa.setCliente(None)
        self.mesa = None
    # Métodos get y set

    def getMesa(self):
        return self.mesa

    def setMesa(self, mesa):
        self.mesa = mesa

    def getPlatillos(self):
        return self.platillos

    def setPlatillos(self, platillos):
        self.platillos = platillos

    def getPedido(self):
        return self.pedido

    def setPedido(self, pedido):
        self.pedido = pedido
