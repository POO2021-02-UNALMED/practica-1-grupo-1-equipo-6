from gestorAplicacion.personas.persona import Persona
# Esta clase se utiliza a la hora de hacer un pedido y cobrar al cliente.
# La clase mesero hereda de Persona, es utilizada para cobrar al cliente. (También para pedir pedidos al mismo)


class Mesero(Persona):
    # El numero de meseros que tiene el restaurante
    numeroMeseros = 0

    def __init__(self, nombre, documento):
        super().__init__(nombre, documento)
        Mesero.numeroMeseros += 1
    # El método cobrar es usado para agregar a la caja el pedido para poder ser utilizado en los métodos de la caja
    # los parametros de entrada son cliente y pedido
    # Le asigna al cliente el pedido y el pedido a la caja.

    def cobrar(self, cliente, pedido):
        from gestorAplicacion.utileria.caja import Caja
        cliente.setPedido(pedido)
        Caja.agregarPedidos(cliente.getPedido())
