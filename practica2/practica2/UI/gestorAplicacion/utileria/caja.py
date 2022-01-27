# Clase caja
# La clase caja es útil a la hora de cuadrar caja, generar estadísticas de cierto día, y eliminar  los datos de un día para iniciar en el día 0.
# Guarda ingresos, gastos y los pedidos para la creación de estadísticas
class Caja:
    ingresos = 0
    gastos = 0
    pedidos = []

    @classmethod
    def reiniciarCaja(cls):
        cls.ingresos = 0
        cls.gastos = 0
        cls.pedidos = []
        from gestorAplicacion.utileria.restaurante import Restaurante
        for i in range(0, len(Restaurante.getPlatillos())):
            Restaurante.getPlatillos()[i].setFrecuencia(0)
    # Método crearEstadisticas
    # Crea las estadísticas de la caja del restaurante, retornando un mensaje con la cantidad
    # de cada platillo pedido

    @classmethod
    def crearEstadisticas(cls):
        from gestorAplicacion.utileria.restaurante import Restaurante
        mensaje = "Las estadisticas de nuestro restaurante son: \n"
        for i in range(0, len(Restaurante.getMenu())):
            mensaje += "Cantidad: " + str(Restaurante.getMenu()[i].getFrecuencia(
            )) + " Platillo: " + Restaurante.getMenu()[i].getNombre() + "\n"
        return mensaje
    # Método agregar pedidos: recibe un pedido y los lleva a la lista de pedidos de caja

    @classmethod
    def agregarPedidos(cls, pedidox):
        cls.pedidos.append(pedidox)
    # Metodo cuadrar caja:
    # Agregamos una función que reciba todos los precios de los pedidos
    # para poder obtener los ingresos

    @classmethod
    def cuadrarCaja(cls):
        suma = 0
        for i in range(0, len(cls.pedidos)):
            suma += cls.pedidos[i].getPrecio()
        cls.ingresos = suma
        return cls.ingresos
    # Get y sets:

    @classmethod
    def getIngresos(cls):
        return cls.ingresos

    @classmethod
    def setIngresos(cls, ingresos):
        cls.ingresos = ingresos

    @classmethod
    def getGastos(cls):
        return cls.gastos

    @classmethod
    def setGastos(cls, gastos):
        cls.gastos = gastos

    @classmethod
    def getPedidos(cls):
        return cls.pedidos

    @classmethod
    def setPedidos(cls, pedidos):
        cls.pedidos = pedidos
