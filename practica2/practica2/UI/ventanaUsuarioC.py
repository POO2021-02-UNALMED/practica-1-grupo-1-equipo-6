import tkinter as tk
from dialogo import FieldFrame
import os
from tkinter import *

os.chdir(r"C:\Users\Usuario\Documents\La nacho stuff\Poo\trabajo2\practica2\UI")
class Ventana(Toplevel):
    def __init__(self, master, bastardos, hijos):
        super().__init__(master)
        self._bastardos = bastardos
        self._hijos = hijos

        #self.ventanaUsuario = tk.Toplevel(self.master)  # La ventana del usuario
        self.title("Ventana de usuario") #Zona 0
        self.geometry("1280x800")

        #zona 1
        self.menubar = tk.Menu(self, bd=2)
        self.config(menu=self.menubar)

        self.pane0 = PanedWindow(self, orient=VERTICAL, bd=0, relief="raised", width=1280, height=800)
        self.pane0.pack(fill=BOTH, side=TOP)

        self.iniTitulo = Label(master=self.pane0, text="Nia Learned to Cook!", height=5, width=20, justify=CENTER, font=("Comis sans MS","18"), fg="Blue")
        self.iniTitulo.grid(column=1, row=1, padx=500, columnspan=2)
        self._bastardos.append(self.iniTitulo)

        from PIL import ImageTk, Image
        iniImagen = ImageTk.PhotoImage((Image.open("Imagenes\\happyCookingNia.jpg")).resize((500,500)), Image.ANTIALIAS)
        self.imgLabel = Label(master=self.pane0, image=iniImagen)
        self.imgLabel.grid(column=1,row=2)
        self._bastardos.append(self.imgLabel)

        textoPlaceholder = "Hola, soy goku\nNah mentira, es peor, soy Michael,\nno te olvidas de cambiar esto\nte pido que uses la fecha y la jornada de la parte lógica,\nBesos uwu"
        self.iniTexto = Label(master=self.pane0, height=25, width=45, text=textoPlaceholder, font=("Comic Sans MS","12"))
        self.iniTexto.grid(column=2,row=2)
        self._bastardos.append(self.iniTexto)

        #Archivo
        self.menu_archivo = tk.Menu(self.menubar, tearoff=False)
        self.menu_archivo.add_command(label="Aplicacion", command=self.infoApp)
        self.menu_archivo.add_separator
        self.menu_archivo.add_command(label="Salir", command=self.volver)

        #procesos y consultas
        self.menu_procesos = tk.Menu(self.menubar, tearoff=False)
        self.menu_procesos.add_command(label="Facturar", command=self.factura)
        self.menu_procesos.add_separator
        self.menu_procesos.add_command(label="Estado", command=self.estado)
        self.menu_procesos.add_separator
        self.menu_procesos.add_command(label="Caja", command=self.caja)
        self.menu_procesos.add_separator
        self.menu_procesos.add_command(label="Estadísticas", command=self.estadistica)
        self.menu_procesos.add_separator
        self.menu_procesos.add_command(label="Jornada", command=self.jornada)
        self.menu_procesos.add_separator
        self.menu_procesos.add_command(label="Editar mesero", command=self.mesero)
        self.menu_procesos.add_separator
        self.menu_procesos.add_command(label="Editar mesa", command=self.mesa)
        self.menu_procesos.add_separator
        self.menu_procesos.add_command(label="Editar menú", command=self.menu)
        self.menu_procesos.add_separator
        self.menu_procesos.add_command(label="Editar platillos", command=self.platillos)

        #Ayuda
        self.menu_ayuda = tk.Menu(self.menubar, tearoff=False)
        self.menu_ayuda.add_command(label="Acerca de", command=self.infoAutores)
        self.menu_ayuda.add_separator

        self.menubar.add_cascade(label="Archivo", menu=self.menu_archivo)
        self.menubar.add_cascade(label="Procesos y consultas", menu=self.menu_procesos)
        self.menubar.add_cascade(label="Ayuda", menu=self.menu_ayuda)

        self.master.iconify() # Minimiza la ventana

        self.mainloop()

    #Función para limpiar el pane
    def cleanPane(self):
        for bastardo in self._bastardos:
            bastardo.grid_forget()
        for hijo in self._hijos:
            self.pane0.forget(hijo)

    #funciones para la zona 1
    def volver(self):
        self.master.deiconify()
        self.destroy()

    def infoAutores(self):
        mensaje = "Desarrollado por:\nSantiago Salazar Ramirez\nMichael Moreno Valoyes\nJane Juliana Gutierrez"
        tk.messagebox.showinfo(title="Acerca de", message=mensaje, parent=self)

    def infoApp(self):
        mensaje = """Aplicacion de gestión de restaurante, desde esta\nse crean las facturas, se revisa o cambia el estado\nactual del restaurante y se revisa la caja del día"""
        tk.messagebox.showinfo(title="Aplicacion", message=mensaje, parent=self)

    def factura(self):
        self.cleanPane()
        nombre = "Creacion de pedidos y facturación"
        descripcion = "Con este formulario, se crea una factura, calculando el precio y guardando el pedido en caja"
        tituloCriterios = "Criterios"
        criterios = ["Mesa", "ID Cliente", "Mesero", "Fecha", "Platillos"]
        tituloV = "Valores"
        FieldFrame(self.pane0, nombre, descripcion, tituloCriterios, criterios, tituloV)

    def mesero(self):
        self.cleanPane()
        nombre = "Edición de meseros"
        descripcion = "Con este formulario se puede buscar, añadir o eliminar un mesero"
        tituloCriterios = "Criterios"
        criterios = ["Identificacion", "Nombre", "Jornada", "Acción"]
        tituloV = "Valores"
        FieldFrame(self.pane0, nombre, descripcion, tituloCriterios, criterios, tituloV)

    def mesa(self):
        self.cleanPane()
        nombre = "Edicion de mesas"
        descripcion = "Con este formulario se pueden añadir o quitar mesas"
        tituloCriterios = "Criterios"
        criterios = ["Numero identificador", "Numero de sillas", "Acción"]
        tituloV = "Valores"
        FieldFrame(self.pane0, nombre, descripcion, tituloCriterios, criterios, tituloV)

    def menu(self):
        self.cleanPane()
        nombre="Edición del menú"
        descripcion="Con este formulario se pueden añadir o quitar platillos del menú de ambas jornadas"
        tituloCriterios = "Criterios"
        criterios = ["Accion","Jornada","Platillos"]
        tituloV = "Valores"
        FieldFrame(self.pane0, nombre, descripcion, tituloCriterios, criterios, tituloV)

    def platillos(self):
        self.cleanPane()
        nombre="Edición de platillo"
        descripcion="Con este formulario se pueden añadir o quitar un platillo de los registrados en el sistema"
        tituloCriterios = "Criterios"
        criterios = ["Accion","Código","Nombre","Ingredientes","Tipo","Tiempo de preparación"]
        tituloV = "Valores"
        valores = [("Código","Se debe programar")]
        habilitado = ["Código"]
        FieldFrame(self.pane0, nombre, descripcion, tituloCriterios, criterios, tituloV, valores, habilitado)

    def jornada(self):
        self.cleanPane()
        nombre="Revision/Cambio de Jornada"
        descripcion="Formulario simple para cambiar la Jornada del restaurante"
        tituloCriterios = "Criterios"
        criterios = ["Jornada actual", "Cambiar Jornada a (Tarde, Noche): "]
        tituloV = "Valores"
        valores = [("Jornada actual","Se debe programar")]
        habilitado = ["Jornada actual"]
        FieldFrame(self.pane0, nombre, descripcion, tituloCriterios, criterios, tituloV, valores, habilitado)

    def estado(self):
        self.cleanPane()
        string="Aquí solo se muestra texto dependiendo de cada comando,\n si es posible haré que desde un principio cumpla la condición de\ncambiar su tamaño según el tamaño de la pantalla\nSPOILER:no supe, luego vemos\nMENTIRA SI SUPÉ BUAJAJAJAJAJA"
        label = Label(master=self.pane0, text=string, justify=CENTER, width=1280, height=800, font=("Comic Sans MS", "30"))
        self.pane0.add(label)
        self._hijos.append(label)
        def cambioT(event=None):
            x = label.winfo_width()
            y = label.winfo_height()
            if x < y:
                label.config(font=("Comic Sans MS", (x*30)//1280))
            else:
                label.config(font=("Comic Sans MS", (y*30)//800))
        self.pane0.bind("<Configure>", cambioT)

    def caja(self):
        self.cleanPane()
        string="Aquí solo se muestra texto dependiendo de cada comando,\n si es posible haré que desde un principio cumpla la condición de\ncambiar su tamaño según el tamaño de la pantalla\nSPOILER:no supe, luego vemos\nMENTIRA SI SUPÉ BUAJAJAJAJAJA"
        label = Label(master=self.pane0, text=string, justify=CENTER, width=1280, height=800, font=("Comic Sans MS", "30"))
        self.pane0.add(label)
        self._hijos.append(label)
        def cambioT(event=None):
            x = label.winfo_width()
            y = label.winfo_height()
            if x < y:
                label.config(font=("Comic Sans MS", (x*30)//1280))
            else:
                label.config(font=("Comic Sans MS", (y*30)//800))
        self.pane0.bind("<Configure>", cambioT)

    def estadistica(self):
        self.cleanPane()
        string="Aquí solo se muestra texto dependiendo de cada comando,\n si es posible haré que desde un principio cumpla la condición de\ncambiar su tamaño según el tamaño de la pantalla\nSPOILER:no supe, luego vemos\nMENTIRA SI SUPÉ BUAJAJAJAJAJA"
        label = Label(master=self.pane0, text=string, justify=CENTER, width=1280, height=800, font=("Comic Sans MS", "30"))
        self.pane0.add(label)
        self._hijos.append(label)
        def cambioT(event=None):
            x = label.winfo_width()
            y = label.winfo_height()
            if x < y:
                label.config(font=("Comic Sans MS", (x*30)//1280))
            else:
                label.config(font=("Comic Sans MS", (y*30)//800))
        self.pane0.bind("<Configure>", cambioT)

    