import tkinter as tk
from tkinter import *
from dialogo import FieldFrame
from PIL import ImageTk, Image
import os

os.chdir(r"C:\Users\Usuario\Documents\La nacho stuff\Poo\trabajo2\practica2\UI")
bastardos = []
hijos = []
def ventanaUsuario(master):
    ventanaUsuario = tk.Toplevel(master)  # La ventana del usuario
    ventanaUsuario.title("Ventana de usuario") #Zona 0
    ventanaUsuario.geometry("1280x800")

    #zona 1
    menubar = tk.Menu(ventanaUsuario, bd=2)
    ventanaUsuario.config(menu=menubar)

    pane0 = PanedWindow(ventanaUsuario, orient=VERTICAL, bd=0, relief="raised", width=1280, height=800)
    pane0.pack(fill=BOTH, side=TOP)

    iniTitulo = Label(master=pane0, text="Nia Learned to Cook!", height=5, width=20, justify=CENTER, font=("Comis sans MS","18"), fg="Blue")
    iniTitulo.grid(column=1, row=1, padx=500, columnspan=2)
    bastardos.append(iniTitulo)

    iniImagen = ImageTk.PhotoImage(Image.open("Imagenes\\happyCookingNia.jpg").resize((500,500)), Image.ANTIALIAS)
    imgLabel = Label(master=pane0, image=iniImagen)
    imgLabel.grid(column=1,row=2)
    bastardos.append(imgLabel)

    textoPlaceholder = "Hola, soy goku\nNah mentira, es peor, soy Michael,\nno te olvidas de cambiar esto\nte pido que uses la fecha y la jornada de la parte lógica,\nBesos uwu"
    iniTexto = Label(master=pane0, height=25, width=45, text=textoPlaceholder, font=("Comic Sans MS","12"))
    iniTexto.grid(column=2,row=2)
    bastardos.append(iniTexto)

    #funciones para la zona 1
    def volver():
        master.deiconify()
        ventanaUsuario.destroy()

    def infoAutores():
        mensaje = "Desarrollado por:\nSantiago Salazar Ramirez\nMichael Moreno Valoyes\nJane Juliana Gutierrez"
        tk.messagebox.showinfo(title="Acerca de", message=mensaje, parent=ventanaUsuario)

    def infoApp():
        mensaje = """Aplicacion de gestión de restaurante, desde esta\nse crean las facturas, se revisa o cambia el estado\nactual del restaurante y se revisa la caja del día"""
        tk.messagebox.showinfo(title="Aplicacion", message=mensaje, parent=ventanaUsuario)

    def factura():
        for bastardo in bastardos:
            bastardo.grid_forget()
        for hijo in hijos:
            pane0.forget(hijo)
        nombre = "Creacion de pedidos y facturación"
        descripcion = "Con este formulario, se crea una factura, calculando el precio y guardando el pedido en caja"
        tituloCriterios = "Criterios"
        criterios = ["Mesa", "ID Cliente", "Mesero", "Fecha", "Platillos"]
        tituloV = "Valores"
        FieldFrame(pane0, nombre, descripcion, tituloCriterios, criterios, tituloV, [])

    def mesero():
        for bastardo in bastardos:
            bastardo.grid_forget()
        for hijo in hijos:
            pane0.forget(hijo)
        nombre = "Edición de meseros"
        descripcion = "Con este formulario se puede buscar, añadir o eliminar un mesero"
        tituloCriterios = "Criterios"
        criterios = ["Identificacion", "Nombre", "Jornada", "Acción"]
        tituloV = "Valores"
        FieldFrame(pane0, nombre, descripcion, tituloCriterios, criterios, tituloV)

    def mesa():
        for bastardo in bastardos:
            bastardo.grid_forget()
        for hijo in hijos:
            pane0.forget(hijo)
        nombre = "Edicion de mesas"
        descripcion = "Con este formulario se pueden añadir o quitar mesas"
        tituloCriterios = "Criterios"
        criterios = ["Numero identificador", "Numero de sillas", "Acción"]
        tituloV = "Valores"
        FieldFrame(pane0, nombre, descripcion, tituloCriterios, criterios, tituloV)

    def menu():
        for bastardo in bastardos:
            bastardo.grid_forget()
        for hijo in hijos:
            pane0.forget(hijo)
        nombre="Edición del menú"
        descripcion="Con este formulario se pueden añadir o quitar platillos del menú de ambas jornadas"
        tituloCriterios = "Criterios"
        criterios = ["Accion","Jornada","Platillos"]
        tituloV = "Valores"
        FieldFrame(pane0, nombre, descripcion, tituloCriterios, criterios, tituloV)

    def platillos():
        for bastardo in bastardos:
            bastardo.grid_forget()
        for hijo in hijos:
            pane0.forget(hijo)
        nombre="Edición de platillo"
        descripcion="Con este formulario se pueden añadir o quitar un platillo de los registrados en el sistema"
        tituloCriterios = "Criterios"
        criterios = ["Accion","Código","Nombre","Ingredientes","Tipo","Tiempo de preparación"]
        tituloV = "Valores"
        valores = [("Código","Se debe programar")]
        habilitado = ["Código"]
        FieldFrame(pane0, nombre, descripcion, tituloCriterios, criterios, tituloV, valores, habilitado)

    def jornada():
        for bastardo in bastardos:
            bastardo.grid_forget()
        for hijo in hijos:
            pane0.forget(hijo)
        nombre="Revision/Cambio de Jornada"
        descripcion="Formulario simple para cambiar la Jornada del restaurante"
        tituloCriterios = "Criterios"
        criterios = ["Jornada actual", "Cambiar Jornada a (Tarde, Noche): "]
        tituloV = "Valores"
        valores = [("Jornada actual","Se debe programar")]
        habilitado = ["Jornada actual"]
        FieldFrame(pane0, nombre, descripcion, tituloCriterios, criterios, tituloV, valores, habilitado)

    def estado():
        for bastardo in bastardos:
            bastardo.grid_forget()
        for hijo in hijos:
            pane0.forget(hijo)
        string="Aquí solo se muestra texto dependiendo de cada comando,\n si es posible haré que desde un principio cumpla la condición de\ncambiar su tamaño según el tamaño de la pantalla\nSPOILER:no supe, luego vemos\nMENTIRA SI SUPÉ BUAJAJAJAJAJA"
        label = Label(master=pane0, text=string, justify=CENTER, width=1280, height=800, font=("Comic Sans MS", "30"))
        pane0.add(label)
        hijos.append(label)
        def cambioT(event=None):
            x = label.winfo_width()
            y = label.winfo_height()
            if x < y:
                label.config(font=("Comic Sans MS", (x*30)//1280))
            else:
                label.config(font=("Comic Sans MS", (y*30)//800))
        pane0.bind("<Configure>", cambioT)

    def caja():
        for bastardo in bastardos:
            bastardo.grid_forget()
        for hijo in hijos:
            pane0.forget(hijo)
        string="Aquí solo se muestra texto dependiendo de cada comando,\n si es posible haré que desde un principio cumpla la condición de\ncambiar su tamaño según el tamaño de la pantalla\nSPOILER:no supe, luego vemos\nMENTIRA SI SUPÉ BUAJAJAJAJAJA"
        label = Label(master=pane0, text=string, justify=CENTER, width=1280, height=800, font=("Comic Sans MS", "30"))
        pane0.add(label)
        hijos.append(label)
        def cambioT(event=None):
            x = label.winfo_width()
            y = label.winfo_height()
            if x < y:
                label.config(font=("Comic Sans MS", (x*30)//1280))
            else:
                label.config(font=("Comic Sans MS", (y*30)//800))
        pane0.bind("<Configure>", cambioT)

    def estadistica():
        for bastardo in bastardos:
            bastardo.grid_forget()
        for hijo in hijos:
            pane0.forget(hijo)
        string="Aquí solo se muestra texto dependiendo de cada comando,\n si es posible haré que desde un principio cumpla la condición de\ncambiar su tamaño según el tamaño de la pantalla\nSPOILER:no supe, luego vemos\nMENTIRA SI SUPÉ BUAJAJAJAJAJA"
        label = Label(master=pane0, text=string, justify=CENTER, width=1280, height=800, font=("Comic Sans MS", "30"))
        pane0.add(label)
        hijos.append(label)
        def cambioT(event=None):
            x = label.winfo_width()
            y = label.winfo_height()
            if x < y:
                label.config(font=("Comic Sans MS", (x*30)//1280))
            else:
                label.config(font=("Comic Sans MS", (y*30)//800))
        pane0.bind("<Configure>", cambioT)


    #Archivo
    menu_archivo = tk.Menu(menubar, tearoff=False)
    menu_archivo.add_command(label="Aplicacion", command=infoApp)
    menu_archivo.add_separator
    menu_archivo.add_command(label="Salir", command=volver)

    #procesos y consultas
    menu_procesos = tk.Menu(menubar, tearoff=False)
    menu_procesos.add_command(label="Facturar", command=factura)
    menu_procesos.add_separator
    menu_procesos.add_command(label="Estado", command=estado)
    menu_procesos.add_separator
    menu_procesos.add_command(label="Caja", command=caja)
    menu_procesos.add_separator
    menu_procesos.add_command(label="Estadísticas", command=estadistica)
    menu_procesos.add_separator
    menu_procesos.add_command(label="Jornada", command=jornada)
    menu_procesos.add_separator
    menu_procesos.add_command(label="Editar mesero", command=mesero)
    menu_procesos.add_separator
    menu_procesos.add_command(label="Editar mesa", command=mesa)
    menu_procesos.add_separator
    menu_procesos.add_command(label="Editar menú", command=menu)
    menu_procesos.add_separator
    menu_procesos.add_command(label="Editar platillos", command=platillos)

    #Ayuda
    menu_ayuda = tk.Menu(menubar, tearoff=False)
    menu_ayuda.add_command(label="Acerca de", command=infoAutores)
    menu_ayuda.add_separator

    menubar.add_cascade(label="Archivo", menu=menu_archivo)
    menubar.add_cascade(label="Procesos y consultas", menu=menu_procesos)
    menubar.add_cascade(label="Ayuda", menu=menu_ayuda)

    master.iconify() # Minimiza la ventana

    ventanaUsuario.mainloop()