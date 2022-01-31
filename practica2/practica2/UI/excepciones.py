# Archivo de excepciones (Última funcionalidad)
# Autor: Jane Gutierrez
# Para implementar las excepciones
# La función para imprimir al final las ecepciones
def mensajeTotal(*args):
    mensaje = ""
    for n in args:
        mensaje = str(mensaje) + "\n" + str(n)
    return mensaje

# Error aplicación, la que se dijo al principio


class ErrorAplicacion(Exception):
    mensajeError = "Manejo de errores de la aplicación."

    def __init__(self, mensaje):
        super().__init__(mensaje)
        self.mensaje = mensaje

    def imprimirError():
        return mensajeTotal(ErrorAplicacion.mensajeError)

# Lado izquierdo
# En caso de que haya existido un error en la edición de un objeto (Eliminar, crear o agregar)


class Edicion(ErrorAplicacion):
    mensajeEdicion = "Error en la edición."

    def __init__(self, mensaje):
        super().__init__(mensaje)

    def imprimir(self):
        return mensajeTotal(ErrorAplicacion.mensajeError, Edicion.mensajeEdicion)

# Se dió un error en agregar


class Agrego(Edicion):
    mensajeAgregado = "No se puede agregar."

    def __init__(self, mensaje):
        super().__init__(mensaje)

    def imprimir(self):
        return mensajeTotal(ErrorAplicacion.mensajeError,
                            Edicion.mensajeEdicion, Agrego.mensajeAgregado)
# Se dió un error en eliminación


class Eliminacion(Edicion):
    mensajeEliminacion = "Eliminación incorrecta."

    def __init__(self, mensaje):
        super().__init__(mensaje)

    def imprimir(self):
        return mensajeTotal(ErrorAplicacion.mensajeError,
                            Edicion.mensajeEdicion, Eliminacion.mensajeEliminacion)
# Se dió un error en creación


class Creacion(Edicion):
    mensajeCreacion = "Creación incorrecta."

    def __init__(self, mensaje):
        super().__init__(mensaje)

    def imprimir(self):
        return mensajeTotal(ErrorAplicacion.mensajeError,
                            Edicion.mensajeEdicion, Creacion.mensajeCreacion)


# Parte derecha
# Error en visualización: No hay dinero en caja
class Visualizacion(ErrorAplicacion):
    mensajeVisualizacion = "Error en la visualización."

    def __init__(self, mensaje):
        super().__init__(mensaje)

    def imprimir(self):
        return mensajeTotal(ErrorAplicacion.mensajeError,
                            Visualizacion.mensajeVisualizacion)
# Error en la caja (Es 0)


class CajaCero(Visualizacion):
    mensajeCaja = "Error en la caja, su valor es 0."

    def __init__(self, mensaje):
        super().__init__(mensaje)

    def imprimir(self):
        return mensajeTotal(ErrorAplicacion.mensajeError,
                            Visualizacion.mensajeVisualizacion, CajaCero.mensajeCaja)
# Error en la facturación


class Facturacion(Visualizacion):
    mensajeFacturacion = "Error en la facturación."

    def __init__(self, mensaje):
        super().__init__(mensaje)

    def imprimir(self):
        return mensajeTotal(ErrorAplicacion.mensajeError,
                            Visualizacion.mensajeVisualizacion, Facturacion.mensajeFacturacion)
# Error en la jornada


class JornadaInexistente(Visualizacion):
    mensajeJornada = "Error con la jornada, jornada inexistente"

    def __init__(self, mensaje):
        super().__init__(mensaje)

    def imprimir(self):
        return mensajeTotal(ErrorAplicacion.mensajeError,
                            Visualizacion.mensajeVisualizacion, JornadaInexistente.mensajeJornada)


'''try:
    raise(Agrego("JIJIJA"))
except Agrego as error:
    error.imprimir()'''
