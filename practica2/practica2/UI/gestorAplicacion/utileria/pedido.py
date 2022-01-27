# Clase Pedido
# La clase pedido presenta el método facturar que hace la factura del pedido, se utiliza al pagar

from gestorAplicacion.utileria.facturacion import Facturacion


class Pedido(Facturacion):
    def __init__(self, cliente, mesero, precio):
        self.platillos = []
        self.cliente = cliente
        self.mesero = mesero
        self.precio = precio
    # Set y gets

    def getPlatillos(self):
        return self.platillos

    def setPlatillos(self, platillos):
        self.platillos = platillos

    def getPrecio(self):
        return self.precio

    def setPrecio(self, precio):
        self.precio = precio

    def getMesero(self):
        return self.mesero

    def setMesero(self, mesero):
        self.mesero = mesero
    # Método borrar pedido:
    # El pedido dejará de usarse para el cliente y se agrega el pedido  a las estadísticas

    def borrarPedido(self):
        from gestorAplicacion.utileria.caja import Caja
        Caja.agregarPedidos(self)
    # Método que genera la string de la factura

    def facturar(self):
        from gestorAplicacion.utileria.restaurante import Restaurante
        from gestorAplicacion.utileria.caja import Caja
        # variables utiles para el proceso de crear la factura, la variable factura se inicializa con elencabezado de todas las facturas
        repetidos = []
        factura = "Restaurante Nia learned to cook!\n" + str(Restaurante.getFecha()) + " " + Restaurante.getHora(
        ) + "\n" + "Cliente: " + self.cliente.getNombre() + "      " + "Mesero: " + self.mesero.getNombre() + "\n" + "\n" + "\n" + "Platillos\n"
        # se checa la cantidad de veces que esta un platillo y se agrega el platillo, su frecuencia y el precio de todas las unidades juntas
        for i in range(0, len(self.platillos)):
            ocurrencias = self.platillos.count(self.platillos[i])
            if ocurrencias > 1 and self.platillos[i].getNombre() not in repetidos:
                factura += self.platillos[i].getNombre() + " * " + str(
                    ocurrencias) + "    $" + str(self.platillos[i].getPrecio()*ocurrencias) + "\n"
                repetidos.append(self.platillos[i].getNombre())
                self.precio += self.platillos[i].getPrecio() * ocurrencias
            elif ocurrencias == 1:
                factura += self.platillos[i].getNombre() + " * " + str(
                    ocurrencias) + "    $" + str(self.platillos[i].getPrecio()*ocurrencias) + "\n"
                self.precio += self.platillos[i].getPrecio() * ocurrencias
        # por ultimo se agrega el total, final de todas las facturas y se devuelve la string factura ya completa
        factura += "\n" + "Total: $" + str(self.precio) + "\n" + " \n" + \
            "Gracias por visitarnos! \n" + Restaurante.getLugar() + " \n" + "315 525 6969"
        Caja.agregarPedidos(self)
        return factura
