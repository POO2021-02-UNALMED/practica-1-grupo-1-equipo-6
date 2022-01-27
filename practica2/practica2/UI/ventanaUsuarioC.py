from distutils import command
import random
import tkinter as tk
from typing import Container
from dialogo import FieldFrame
import os
from tkinter import *

from gestorAplicacion.utileria.restaurante import Restaurante
os.getcwd()


class Ventana(Toplevel):
    def __init__(self, master, bastardos, hijos):
        super().__init__(master)
        self._bastardos = bastardos
        self._hijos = hijos

        # self.ventanaUsuario = tk.Toplevel(self.master)  # La ventana del usuario
        self.title("Ventana de usuario")  # Zona 0
        self.geometry("1280x800")

        # zona 1
        self.menubar = tk.Menu(self, bd=2)
        self.config(menu=self.menubar)

        self.pane0 = PanedWindow(
            self, orient=VERTICAL, bd=0, relief="raised", width=1280, height=800)
        self.pane0.pack(fill=BOTH, side=TOP)

        self.iniTitulo = Label(master=self.pane0, text="Nia Learned to Cook!", height=5,
                               width=20, justify=CENTER, font=("Comis sans MS", "18"), fg="Blue")
        self.iniTitulo.grid(column=1, row=1, padx=500, columnspan=2)
        self._bastardos.append(self.iniTitulo)

        from PIL import ImageTk, Image
        iniImagen = ImageTk.PhotoImage(
            (Image.open("Imagenes\\happyCookingNia.jpg")).resize((500, 500)), Image.ANTIALIAS)
        self.imgLabel = Label(master=self.pane0, image=iniImagen)
        self.imgLabel.grid(column=1, row=2)
        self._bastardos.append(self.imgLabel)

        textoPlaceholder = "Esperamos que tenga un buen día usuario.\nPara usar las funcionalidades del programa podrá acceder a procesos y consultas, donde están:\nEditar platillos:\nCrea, elimina o ve los platillos, dependiendo de la acción que escriba el usuario(Crear,Eliminar,Ver). Se genera un código automáticamente para el usuario.\nEditar menú:\nCon los platillos generados puede crear un menú, para insertar más de un platillo al menú se escriben los platillos separados por una ", ".\nEditar mesa:\nSimilar a editar platillos, pero con mesas.\nEditar mesero:\nSimilar a editar platillos, pero con meseros.\nJornada:\nSe inserta Tarde o Noche para editar la hora del restaurante.\nEstadísticas del restaurante:\nEstadísticas de los platillos.\nCaja:\nDinero obtenido en el día.\nEstado:\nMuestra los clientes, meseros y mesas disponibles actuales.\nFacturar:\nSe factura con los elementos presentados. Se resalta que para asignar los platillos se debe de separar como:\nID_Platillo:Numero_Platillo,...,ID_Platillo_n:Numero_Platillo_n"
        self.iniTexto = Label(master=self.pane0, height=25, width=45,
                              text=textoPlaceholder, font=("Times New Roman", "12"))
        self.iniTexto.grid(column=2, row=2)
        self._bastardos.append(self.iniTexto)

        # Archivo
        self.menu_archivo = tk.Menu(self.menubar, tearoff=False)
        self.menu_archivo.add_command(label="Aplicacion", command=self.infoApp)
        self.menu_archivo.add_separator
        self.menu_archivo.add_command(label="Salir", command=self.volver)

        # procesos y consultas
        self.menu_procesos = tk.Menu(self.menubar, tearoff=False)
        self.menu_procesos.add_command(label="Facturar", command=self.factura)
        self.menu_procesos.add_separator
        self.menu_procesos.add_command(label="Estado", command=self.estado)
        self.menu_procesos.add_separator
        self.menu_procesos.add_command(label="Caja", command=self.caja)
        self.menu_procesos.add_separator
        self.menu_procesos.add_command(
            label="Estadísticas", command=self.estadistica)
        self.menu_procesos.add_separator
        self.menu_procesos.add_command(label="Jornada", command=self.jornada)
        self.menu_procesos.add_separator
        self.menu_procesos.add_command(
            label="Editar mesero", command=self.mesero)
        self.menu_procesos.add_separator
        self.menu_procesos.add_command(label="Editar mesa", command=self.mesa)
        self.menu_procesos.add_separator
        self.menu_procesos.add_command(label="Editar menú", command=self.menu)
        self.menu_procesos.add_separator
        self.menu_procesos.add_command(
            label="Editar platillos", command=self.platillos)

        # Ayuda
        self.menu_ayuda = tk.Menu(self.menubar, tearoff=False)
        self.menu_ayuda.add_command(
            label="Acerca de", command=self.infoAutores)
        self.menu_ayuda.add_separator

        self.menubar.add_cascade(label="Archivo", menu=self.menu_archivo)
        self.menubar.add_cascade(
            label="Procesos y consultas", menu=self.menu_procesos)
        self.menubar.add_cascade(label="Ayuda", menu=self.menu_ayuda)

        self.master.iconify()  # Minimiza la ventana

        self.mainloop()

    # Función para limpiar el pane
    def cleanPane(self):
        for bastardo in self._bastardos:
            bastardo.grid_forget()
        for hijo in self._hijos:
            self.pane0.forget(hijo)

    # funciones para la zona 1
    def volver(self):
        self.master.deiconify()
        self.destroy()

    def infoAutores(self):
        mensaje = "Desarrollado por:\nSantiago Salazar Ramirez\nMichael Moreno Valoyes\nJane Juliana Gutierrez"
        tk.messagebox.showinfo(title="Acerca de", message=mensaje, parent=self)

    def infoApp(self):
        mensaje = """Aplicacion de gestión de restaurante, desde esta\nse crean las facturas, se revisa o cambia el estado\nactual del restaurante y se revisa la caja del día"""
        tk.messagebox.showinfo(
            title="Aplicacion", message=mensaje, parent=self)
    # Interfaz para la factura

    def factura(self):
        from gestorAplicacion.personas.cliente import Cliente
        from gestorAplicacion.utileria.pedido import Pedido
        self.cleanPane()
        nombre = "Creacion de pedidos y facturación"
        descripcion = "Con este formulario, se crea una factura, calculando el precio y guardando el pedido en caja"
        tituloCriterios = "Criterios"
        criterios = ["Mesa", "ID Cliente", "Nombre Cliente",
                     "ID Mesero", "Fecha", "Platillos"]
        tituloV = "Valores"
        objetoFactura = FieldFrame(self.pane0, nombre, descripcion,
                                   tituloCriterios, criterios, tituloV, [], [])
        # La función para crear la factura (parte lógica)

        def crearFactura():
            # Los platillos de la factura
            Platillos = []
            # Mesa de la factura
            mesa = int(objetoFactura._entries[0].get())
            # Documento del cliente
            documentoCliente = int(objetoFactura._entries[1].get())
            # Nombre del cliente
            nombreCliente = objetoFactura._entries[2].get()
            # Documento del mesero
            documentoMesero = int(objetoFactura._entries[3].get())
            # Fecha
            fecha = objetoFactura._entries[4].get()
            # Va a ser con la id del platillo, no con el nombre
            # Forma de introducir: idplatillo:cantidad,idplatillo2,cantidad2
            platillos = objetoFactura._entries[5].get()
            # Se crea el cliente
            clienteNuevo = Cliente(nombreCliente, documentoCliente)
            # Se reserva la mesa
            clienteNuevo.reservar(mesa)
            platillosFacturaCantidad = platillos.split(",")
            # Por cada id:cantidad
            for dividido in platillosFacturaCantidad:
                # dividido1 = Id del platillo
                # dividido2 = cantidad del platillo
                divididoNuevo = dividido.split(":")
                dividido1 = int(divididoNuevo[0])
                dividido2 = int(divididoNuevo[1])
                # Hora de buscar por el menú del restaurante, para saber si lo introducido está
                for elementos in Restaurante.getMenu():
                    if elementos.getIdentificador() == dividido1:
                        platillo = elementos
                # Se aumenta la frecuencia del platillo
                platillo.setFrecuencia(
                    platillo.getFrecuencia() + dividido2)
                # Se agregan a Platillos (Los platillos del pedido)
                for i in range(0, dividido2):
                    Platillos.append(platillo)
            # Si la hora es tarde
            if Restaurante.getHora() == "Tarde":
                for elementos in Restaurante.getMeserosHorarioTarde():
                    if elementos.getDocumento() == documentoMesero:
                        pedido = Pedido(clienteNuevo, elementos, 0)
            # Si la hora es nocha
            elif Restaurante.getHora() == "Noche":
                for elementos in Restaurante.getMeserosHorarioNoche():
                    if elementos.getDocumento() == documentoMesero:
                        pedido = Pedido(clienteNuevo, elementos, 0)

            # Poner los platillos al pedido, como también linkear el pedido con el cliente
            pedido.setPlatillos(Platillos)
            clienteNuevo.setPedido(pedido)

            # Ya se creó el pedido, ahora toca es crear la factura
            # Buscar la mesa en mesas reservadas
            for elementos in Restaurante.getMesasReservadas():
                if mesa == elementos.getNumero():
                    # El objeto mesa, no el número
                    mesaTotal = elementos
                    mensajeEntregar = mesaTotal.getCliente().getPedido().facturar()
                    mesaTotal.getCliente().irse()
            self.cleanPane()
            label = Label(master=self.pane0, text=mensajeEntregar, justify=CENTER,
                          width=1280, height=800, font=("Times New Roman", "30"))
            self.pane0.add(label)
            self._hijos.append(label)

            def cambioT(event=None):
                x = label.winfo_width()
                y = label.winfo_height()
                if x < y:
                    label.config(font=("Times New Roman", (x*30)//1280))
                else:
                    label.config(font=("Times New Roman", (y*30)//800))
            self.pane0.bind("<Configure>", cambioT)
        # Limpiar los entries

        def limpiarTexto():
            for entradas in objetoFactura._entries:
                entradas.delete(0, END)
        # Botón para aceptar
        objetoFactura._botones[0].configure(command=crearFactura)
        # Botón para limpiar los entries
        objetoFactura._botones[1].configure(command=limpiarTexto)

    # El menú para mesero
    # Interfaz para el mesero
    def mesero(self):
        self.cleanPane()
        nombre = "Edición de meseros"
        descripcion = "Con este formulario se puede buscar, añadir o eliminar un mesero"
        tituloCriterios = "Criterios"
        criterios = ["Identificacion", "Nombre",
                     "Jornada", "Acción(Crear,Eliminar,Ver)"]
        tituloV = "Valores"
        objetoMesero = FieldFrame(self.pane0, nombre, descripcion,
                                  tituloCriterios, criterios, tituloV, [], [])
        # Para editar los meseros

        def editarMesero():
            from gestorAplicacion.personas.mesero import Mesero
            # Todo documento es un número

            nombre = objetoMesero._entries[1].get()
            jornada = objetoMesero._entries[2].get()
            accion = objetoMesero._entries[3].get()
            # Si quiere crear un mesero
            if accion == "Crear":
                identificacion = int(objetoMesero._entries[0].get())
                funcional = 1
                # Verifica si está en los meseros horarionoche o horariotarde
                for elemento in Restaurante.getMeserosHorarioNoche():
                    if elemento.getDocumento() == identificacion:
                        funcional = 0
                for elemento in Restaurante.getMeserosHorarioTarde():
                    if elemento.getDocumento() == identificacion:
                        funcional = 0
                # En caso de que no esté antes pues se agrega según la jornada
                if funcional == 1:
                    mesero = Mesero(nombre, identificacion)
                    if jornada == "Tarde":
                        Restaurante.getMeserosHorarioTarde().append(mesero)
                    elif jornada == "Noche":
                        Restaurante.getMeserosHorarioNoche().append(mesero)
            # Eliminar mesero
            elif accion == "Eliminar":
                identificacion = int(objetoMesero._entries[0].get())
                posicion = -1
                for i in range(0, len(Restaurante.getMeserosHorarioTarde())):
                    if identificacion == Restaurante.getMeserosHorarioTarde()[i].getDocumento():
                        posicion = i
                if posicion > -1:
                    Restaurante.getMeserosHorarioTarde().pop(posicion)
                else:
                    for i in range(0, len(Restaurante.getMeserosHorarioNoche())):
                        if identificacion == Restaurante.getMeserosHorarioNoche()[i].getDocumento():
                            posicion = i
                    if posicion > -1:
                        Restaurante.getMeserosHorarioNoche().pop(posicion)
            # Ver meseros
            elif accion == "Ver":
                Mensaje = "Meseros presentes por la tarde:"
                for elementos in Restaurante.getMeserosHorarioTarde():
                    Mensaje = Mensaje + "\n" + elementos.getNombre()
                Mensaje = Mensaje + "\n" + "Mesero presentes por la noche:"
                for elementos in Restaurante.getMeserosHorarioNoche():
                    Mensaje = Mensaje + "\n" + elementos.getNombre()
                self.cleanPane()
                label = Label(master=self.pane0, text=Mensaje, justify=CENTER,
                              width=1280, height=800, font=("Times New Roman", "30"))
                self.pane0.add(label)
                self._hijos.append(label)

                def cambioT(event=None):
                    x = label.winfo_width()
                    y = label.winfo_height()
                    if x < y:
                        label.config(font=("Times New Roman", (x*30)//1280))
                    else:
                        label.config(font=("Times New Roman", (y*30)//800))
                self.pane0.bind("<Configure>", cambioT)

        # Para limpiar los textos de las entries

        def limpiarTexto():
            for entradas in objetoMesero._entries:
                entradas.delete(0, END)
        objetoMesero._botones[0].configure(command=editarMesero)
        objetoMesero._botones[1].configure(command=limpiarTexto)
    # Interfaz para la mesa

    def mesa(self):
        from gestorAplicacion.utileria.mesa import Mesa
        self.cleanPane()
        nombre = "Edicion de mesas"
        descripcion = "Con este formulario se pueden añadir o quitar mesas"
        tituloCriterios = "Criterios"
        criterios = ["Numero identificador",
                     "Numero de sillas", "Acción(Crear,Ver,Eliminar)"]
        tituloV = "Valores"
        objetoMesa = FieldFrame(self.pane0, nombre, descripcion,
                                tituloCriterios, criterios, tituloV, [], [])
        # Editar las mesas

        def editarMesa():

            accion = objetoMesa._entries[2].get()
            # Crear las mesas
            if accion == "Crear":
                numeroMesa = int(objetoMesa._entries[0].get())
                numeroSillas = int(objetoMesa._entries[1].get())
                funcional = 1
                for elemento in Restaurante.getMesasDisponibles():
                    if elemento.getNumero() == numeroMesa:
                        funcional = 0
                for elemento in Restaurante.getMesasReservadas():
                    if elemento.getNumero() == numeroMesa:
                        funcional = 0
                if funcional == 1:
                    mesa = Mesa(True, numeroMesa, numeroSillas)
            # Eliminar las mesas
            if accion == "Eliminar":
                numeroMesa = int(objetoMesa._entries[0].get())
                posicion = -1
                for i in range(0, len(Restaurante.getMesasDisponibles())):
                    if numeroMesa == Restaurante.getMesasDisponibles()[i].getNumero():
                        posicion = i
                if posicion > -1:
                    Restaurante.getMesasDisponibles().pop(posicion)
            # Ver las mesas
            if accion == "Ver":
                mesasDisponibles = "Las mesas disponibles ahora mismo son:"
                for elemento in Restaurante.getMesasDisponibles():
                    mesasDisponibles = mesasDisponibles + \
                        "\n" + str(elemento.getNumero()) + "\n"
                self.cleanPane()
                label = Label(master=self.pane0, text=mesasDisponibles, justify=CENTER,
                              width=1280, height=800, font=("Times New Roman", "30"))
                self.pane0.add(label)
                self._hijos.append(label)

                def cambioT(event=None):
                    x = label.winfo_width()
                    y = label.winfo_height()
                    if x < y:
                        label.config(font=("Times New Roman", (x*30)//1280))
                    else:
                        label.config(font=("Times New Roman", (y*30)//800))
                self.pane0.bind("<Configure>", cambioT)

        def limpiarTexto():
            for entradas in objetoMesa._entries:
                entradas.delete(0, END)
        objetoMesa._botones[0].configure(command=editarMesa)
        objetoMesa._botones[1].configure(command=limpiarTexto)
    # Interfaz para el menú

    def menu(self):
        self.cleanPane()
        nombre = "Edición del menú"
        descripcion = "Con este formulario se pueden añadir o quitar platillos del menú de ambas jornadas"
        tituloCriterios = "Criterios"
        criterios = ["Accion(Crear,Ver)", "Jornada", "Platillos"]
        tituloV = "Valores"
        objetoMenu = FieldFrame(self.pane0, nombre, descripcion,
                                tituloCriterios, criterios, tituloV, [], [])
        # Función para editar el menú

        def editarMenu():
            accion = objetoMenu._entries[0].get()
            jornada = objetoMenu._entries[1].get()
            Platillos = objetoMenu._entries[2].get()
            # Crear Menú
            if accion == "Crear":
                platillosMenu = Platillos.split(",")
                for platillitos in platillosMenu:
                    for i in range(0, len(Restaurante.getPlatillos())):
                        # Se añade al menú con el nombre
                        if int(platillitos) == Restaurante.getPlatillos()[i].getIdentificador():
                            if Restaurante.getPlatillos()[i] not in Restaurante.getMenu():
                                Restaurante.getMenu().append(
                                    Restaurante.getPlatillos()[i])
            # Ver Menú
            if accion == "Ver":
                mensaje = "Los platillos del menu son:"
                for platillito in Restaurante.getMenu():
                    mensaje = mensaje + "\n" + platillito.getNombre()
                self.cleanPane()
                label = Label(master=self.pane0, text=mensaje, justify=CENTER,
                              width=1280, height=800, font=("Times New Roman", "30"))
                self.pane0.add(label)
                self._hijos.append(label)

                def cambioT(event=None):
                    x = label.winfo_width()
                    y = label.winfo_height()
                    if x < y:
                        label.config(font=("Times New Roman", (x*30)//1280))
                    else:
                        label.config(font=("Times New Roman", (y*30)//800))
                self.pane0.bind("<Configure>", cambioT)

        def limpiarTexto():
            for entradas in objetoMenu._entries:
                entradas.delete(0, END)
        objetoMenu._botones[0].configure(command=editarMenu)
        objetoMenu._botones[1].configure(command=limpiarTexto)
    # Interfaz de los platillos

    def platillos(self):
        from gestorAplicacion.utileria.platillo import Platillo
        self.cleanPane()
        nombre = "Edición de platillo"
        descripcion = "Con este formulario se pueden añadir o quitar un platillo de los registrados en el sistema"
        tituloCriterios = "Criterios"
        criterios = ["Accion(Crear,Eliminar,Ver)", "Código", "Nombre",
                     "Ingredientes", "Tipo", "Tiempo de preparación", "Precio"]
        tituloV = "Valores"
        valores = [("Código", "")]
        habilitado = ["Código"]
        objetoPlatillos = FieldFrame(self.pane0, nombre, descripcion, tituloCriterios,
                                     criterios, tituloV, [], [], valores, habilitado)
        # Editar platillos

        def editarPlatillos():

            accion = objetoPlatillos._entries[0].get()
            codigo = objetoPlatillos._entries[1]
            nombre = objetoPlatillos._entries[2].get()
            # Crear los platillos
            if accion == "Crear":
                ingredientes = objetoPlatillos._entries[3].get()
                tipo = objetoPlatillos._entries[4].get()
                tiempoPreparacion = int(objetoPlatillos._entries[5].get())
                precio = int(objetoPlatillos._entries[6].get())
                funcional = 1
                # Genera el código aleatorio
                codigoReal = random.randint(100, 200)
                # Buscar si este código estaba antes
                for elementos in Restaurante.getPlatillos():
                    if elementos.getIdentificador() == codigoReal:
                        funcional = 0
                # Buscar si este nombre estaba antes
                for elementos in Restaurante.getPlatillos():
                    if elementos.getNombre() == nombre:
                        funcional = 0
                # En caso de que no haya estado entonces se crea el platillo y se mete el código al entry que no se puede modificar (el del código auto generado)
                if funcional == 1:
                    platillos = Platillo(
                        tiempoPreparacion, nombre, tipo, ingredientes, precio, codigoReal, 0)
                    Restaurante.getPlatillos().append(platillos)
                    codigo.configure(state=NORMAL)
                    codigo.delete(0, END)
                    codigo.insert(0, str(codigoReal))
                    codigo.configure(state=DISABLED)

            # Eliminar el platillo
            elif accion == "Eliminar":
                posicionPlatillo = -1
                # Lo busca en platillos y menú para borrarlo
                for i in range(0, len(Restaurante.getPlatillos())):
                    if Restaurante.getPlatillos()[i].getNombre() == nombre:
                        posicionPlatillo = i
                if posicionPlatillo > -1:
                    Restaurante.getPlatillos().pop(posicionPlatillo)
                posicionMenu = -1
                for i in range(0, len(Restaurante.getMenu())):
                    if Restaurante.getMenu()[i].getNombre() == nombre:
                        posicionMenu = i
                if posicionMenu > -1:
                    Restaurante.getMenu().pop(posicionMenu)
            # Ver platillos
            elif accion == "Ver":
                mensaje = "Los platillos son:"
                # Por todos los elementos de los platillos del restaurante
                for elementos in Restaurante.getPlatillos():
                    mensaje = mensaje + "\n" + elementos.getNombre() + " : " + \
                        str(elementos.getIdentificador())
                self.cleanPane()
                label = Label(master=self.pane0, text=mensaje, justify=CENTER,
                              width=1280, height=800, font=("Times New Roman", "30"))
                self.pane0.add(label)
                self._hijos.append(label)

                def cambioT(event=None):
                    x = label.winfo_width()
                    y = label.winfo_height()
                    if x < y:
                        label.config(font=("Times New Roman", (x*30)//1280))
                    else:
                        label.config(font=("Times New Roman", (y*30)//800))
                self.pane0.bind("<Configure>", cambioT)

        def limpiarTexto():
            for entradas in objetoPlatillos._entries:
                entradas.delete(0, END)
        objetoPlatillos._botones[0].configure(command=editarPlatillos)
        objetoPlatillos._botones[1].configure(command=limpiarTexto)
    # La interfaz para la jornada

    def jornada(self):
        self.cleanPane()
        nombre = "Revision/Cambio de Jornada"
        descripcion = "Formulario simple para cambiar la Jornada del restaurante"
        tituloCriterios = "Criterios"
        criterios = ["Jornada actual", "Cambiar Jornada a (Tarde, Noche): "]
        tituloV = "Valores"
        valores = [("Jornada actual", "")]
        habilitado = ["Jornada actual"]
        objetoJornada = FieldFrame(self.pane0, nombre, descripcion, tituloCriterios,
                                   criterios, tituloV, [], [], valores, habilitado)
        # Cambiar la jornada

        def editarJornada():
            jornadaActual = objetoJornada._entries[0]
            cambiarJornada = objetoJornada._entries[1].get()
            # Si es tarde pa tarde, si es noche pa noche
            if cambiarJornada == "Tarde":
                Restaurante.setHora("Tarde")
            elif cambiarJornada == "Noche":
                Restaurante.setHora("Noche")
            # Imprime el Estado en el entry que no se puede modificar
            jornadaActual.configure(state=NORMAL)
            jornadaActual.delete(0, END)
            jornadaActual.insert(0, Restaurante.getHora())
            jornadaActual.configure(state=DISABLED)

        def limpiarTexto():
            for entradas in objetoJornada._entries:
                entradas.delete(0, END)
        objetoJornada._botones[0].configure(command=editarJornada)
        objetoJornada._botones[1].configure(command=limpiarTexto)
    # El estado del restaurante (eso ya se encontraba en las anteriores clases)

    def estado(self):
        self.cleanPane()
        string = Restaurante.estadoRestaurante()
        label = Label(master=self.pane0, text=string, justify=CENTER,
                      width=1280, height=800, font=("Times New Roman", "30"))
        self.pane0.add(label)
        self._hijos.append(label)

        def cambioT(event=None):
            x = label.winfo_width()
            y = label.winfo_height()
            if x < y:
                label.config(font=("Times New Roman", (x*30)//1280))
            else:
                label.config(font=("Times New Roman", (y*30)//800))
        self.pane0.bind("<Configure>", cambioT)
    # Interfaz de la caja

    def caja(self):
        from gestorAplicacion.utileria.caja import Caja
        # Función de la caja
        Caja.cuadrarCaja()
        self.cleanPane()
        string = "Las ganancias de hoy fueron: $" + \
            str(Caja.getIngresos()) + "\n"
        label = Label(master=self.pane0, text=string, justify=CENTER,
                      width=1280, height=800, font=("Times New Roman", "30"))
        self.pane0.add(label)
        self._hijos.append(label)

        def cambioT(event=None):
            x = label.winfo_width()
            y = label.winfo_height()
            if x < y:
                label.config(font=("Times New Roman", (x*30)//1280))
            else:
                label.config(font=("Times New Roman", (y*30)//800))
        self.pane0.bind("<Configure>", cambioT)
    # Las estadísticas del restaurante

    def estadistica(self):
        from gestorAplicacion.utileria.caja import Caja
        self.cleanPane()
        string = Caja.crearEstadisticas()
        label = Label(master=self.pane0, text=string, justify=CENTER,
                      width=1280, height=800, font=("Times New Roman", "30"))
        self.pane0.add(label)
        self._hijos.append(label)

        def cambioT(event=None):
            x = label.winfo_width()
            y = label.winfo_height()
            if x < y:
                label.config(font=("Times New Roman", (x*30)//1280))
            else:
                label.config(font=("Times New Roman", (y*30)//800))
        self.pane0.bind("<Configure>", cambioT)
