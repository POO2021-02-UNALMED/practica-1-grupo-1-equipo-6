# Clase restaurante
# Autor: Michael Moreno Valoyes
# Guarda información del restaurante, contiene información del mismo, importante en la funcionalidad
# del estado del restaurante

# Del enum
import enum


class Jornada(enum.Enum):
    Tarde = "Tarde"
    Noche = "Noche"


class Restaurante:
    LUGAR = "Carrera 39 numero 56-22"
    # Hora: Tarde y Noche
    hora = Jornada.Tarde.value
    menu = []
    mesasReservadas = []
    mesasDisponibles = []
    meserosHorarioTarde = []
    meserosHorarioNoche = []
    platillos = []
    fecha = "26/01/2022"
    # Metodos set y get

    @classmethod
    def getMenu(cls):
        return cls.menu

    @classmethod
    def setMenu(cls, menu):
        cls.menu = menu

    @classmethod
    def getPlatillos(cls):
        return cls.platillos

    @classmethod
    def setPlatillos(cls, platillos):
        cls.platillos = platillos

    @classmethod
    def getMeserosHorarioTarde(cls):
        return cls.meserosHorarioTarde

    @classmethod
    def setMeserosHorarioTarde(cls, meseros):
        cls.meserosHorarioTarde = meseros

    @classmethod
    def getMeserosHorarioNoche(cls):
        return cls.meserosHorarioNoche

    @classmethod
    def setMeserosHorarioNoche(cls, noche):
        cls.meserosHorarioNoche = noche

    @classmethod
    def getMesasReservadas(cls):
        return cls.mesasReservadas

    @classmethod
    def setMesasReservadas(cls, mesas):
        cls.mesasReservadas = mesas

    @classmethod
    def getMesasDisponibles(cls):
        return cls.mesasDisponibles

    @classmethod
    def setMesasDisponibles(cls, mesas):
        cls.mesasDisponibles = mesas

    @classmethod
    def getHora(cls):
        return cls.hora

    @classmethod
    def setHora(cls, hora):
        cls.hora = hora

    @classmethod
    def getLugar(cls):
        return cls.LUGAR

    @classmethod
    def getFecha(cls):
        return cls.fecha

    @classmethod
    def setFecha(cls, fecha):
        cls.fecha = fecha
    # estadoRestaurante: Busca los clientes por las mesas reservadas, los meseros por la hora y las mesas disponibles por las mesas disponibles del restaurante

    @classmethod
    def estadoRestaurante(cls):
        mensajeClientes = "Los clientes actuales son: "
        mensajeMeseros = "Los meseros actuales son: "
        mensajeMesasDisponibles = "Las mesas disponibles son: "
        for elemento in cls.mesasReservadas:
            nombreCliente = elemento.getCliente().getNombre()
            mensajeClientes = mensajeClientes + "\n" + nombreCliente
        if cls.hora == "Tarde":
            for elemento in cls.meserosHorarioTarde:
                mensajeMeseros = mensajeMeseros + "\n" + elemento.getNombre()
        elif cls.hora == "Noche":
            for elemento in cls.meserosHorarioNoche:
                mensajeMeseros = mensajeMeseros + "\n" + elemento.getNombre()
        for elemento in Restaurante.mesasDisponibles:
            mensajeMesasDisponibles = mensajeMesasDisponibles + \
                "\n" + str(elemento.getNumero())
        return mensajeClientes + "\n" + mensajeMeseros + "\n" + mensajeMesasDisponibles
