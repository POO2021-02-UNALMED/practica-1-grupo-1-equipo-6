import tkinter as tk
from turtle import pos
from PIL import ImageTk, Image
from ventanaUsuarioC import Ventana
import os

os.chdir(r"C:\Users\Usuario\Documents\La nacho stuff\Poo\trabajo2\practica2\UI")
window = tk.Tk()
# Dimensiones de mi computador
window.geometry("1280x800")
# No dejo cambiar el tamaño de la ventana (para que no afecte en la visualización del programa)
window.resizable(width=False, height=False)
# Frame izquierdo 1 (P1)
frameIzquierdo = tk.Frame(master=window, width=550,
                          height=650, bg="red", borderwidth=5)
frameIzquierdo.place(x=50, y=50)
# Frame derecho 1 (P2)
frameDerecho = tk.Frame(master=window, width=580, height=650, bg="red")
frameDerecho.place(x=650, y=50)
# P3
p3 = tk.Frame(master=frameIzquierdo, width=530, height=130)
p3.place(x=10, y=10)
# El texto de bienvenida
textoBienvenida = tk.Text(master=p3)
textoBienvenida.place(x=0, y=0)
Texto = "Bienvenido a nuestra aplicación, esperamos que tenga una\nexperiencia agradable. A continuación se presentará un programa\npara el manejo de los clientes del restaurante, se espera que la\nexperiencia sea sencilla para el usuario que esté usando la \naplicación."
textoBienvenida.insert(tk.END, Texto)
textoBienvenida.config(state=tk.DISABLED)
# P4
p4 = tk.Frame(master=frameIzquierdo, width=530, height=480, bg="blue")
p4.place(x=10, y=150)
Imagenes = ["Imagenes\\Uno.jpg", "Imagenes\\Dos.jpeg", "Imagenes\\Tres.jpg", "Imagenes\\Cuatro.jpg"]
img = ImageTk.PhotoImage((Image.open("Imagenes\\Uno.jpg")).resize((400, 400), Image.ANTIALIAS))
panel = tk.Label(master=p4, image=img)
# Para que el garbage collector no lo borre
panel.image = img
# Donde se va a ubicar
panel.place(x=0, y=0)
# Empieza desde el primero (Uno.jpg)
posicion = 0

# La función para poder cambiar la imagen


def cambiarImagen(img):
    global posicion
    global Imagenes
    # En caso de que esté en la última posición vuelve a la primera, en caso contrario vaya avanzando a la siguiente
    if posicion == 3:
        posicion = 0
    else:
        posicion += 1
    # La nueva img la meto
    img = ImageTk.PhotoImage(
        (Image.open(Imagenes[posicion])).resize((400, 400), Image.ANTIALIAS))
    panel.configure(image=img)
    # Lo mismo del garbage collector
    panel.image = img


# El evento del click
panel.bind("<Button 1>", cambiarImagen)
# El botón para cambiar a la otra ventana
# La función para cambiar a otra ventana


def crearVentanaUsuario():
    Ventana(window, [], [])

botonAplicacion = tk.Button(
    master=p4, text="Aplicación", width=10, height=5, bg="gray", command=crearVentanaUsuario)
botonAplicacion.place(x=425, y=385)
# P6
p6 = tk.Frame(master=frameDerecho, width=565, height=470, bg="blue")
p6.place(x=5, y=175)
# P5
p5 = tk.Frame(master=frameDerecho, width=560, height=160, bg="blue")
p5.place(x=10, y=10)

# Separación para la hoja de vida e imagenes
# Primera parte: El texto de las hojas de vida
# P5:
# Los textos de los integrantes del grupo
Textos = ["Michael Moreno Valoyes.\nCC: 1001023523.\nIntereses: Desarrollo de software e inteligencia artificial.\nObjetivo: Adquirir conocimientos y habilidades de aprendizaje en desarrollo de \nsoftware y desarrollo web",
          "Santiago Salazar Ramirez.\nCC: 1006120897.\nIntereses: Chatbots e IOT.\nObjetivo: Adquirir experiencia en la creación de aplicaciones móviles", "Jane Gutierrez.\nCC: 1000548050.\nIntereses: Diseño web.\nObjetivo: Implementar la experiencia adquirida en esta aplicación a \notras situaciones en el ámbito laboral."]
texto = Textos[0]
textoVida = tk.Label(master=p5, text=texto, justify=tk.LEFT)
textoVida.text = texto
textoVida.place(x=0, y=0)
# La función para cambiar el texto e imagenes
posicionTexto = 0
# P6 (Las imagenes cambiantes):
# Imagen 1
img1 = ImageTk.PhotoImage(
    (Image.open("Imagenes\\1.png")).resize((282, 235), Image.ANTIALIAS))
panel1 = tk.Label(master=p6, image=img1)
panel1.grid(row=0, column=0)
# Imagen 2
img2 = ImageTk.PhotoImage(
    (Image.open("Imagenes\\2.jpeg")).resize((282, 235), Image.ANTIALIAS))
panel2 = tk.Label(master=p6, image=img2)
panel2.grid(row=0, column=1)
# Imagen 3
img3 = ImageTk.PhotoImage(
    (Image.open("Imagenes\\3.jpg")).resize((282, 235), Image.ANTIALIAS))
panel3 = tk.Label(master=p6, image=img3)
panel3.grid(row=1, column=0)
# Imagen 4
img4 = ImageTk.PhotoImage(
    (Image.open("Imagenes\\4.jpg")).resize((282, 235), Image.ANTIALIAS))
panel4 = tk.Label(master=p6, image=img4)
panel4.grid(row=1, column=1)
ImagenesTotales = [["Imagenes\\1.png", "Imagenes\\2.jpeg", "Imagenes\\3.jpg", "Imagenes\\4.jpg"], [
    "Imagenes\\5.jpg", "Imagenes\\6.jpg", "Imagenes\\7i.jpg", "Imagenes\\8.jpg"], ["Imagenes\\9.jpg", "Imagenes\\10.png", "Imagenes\\11.jpg", "Imagenes\\12.jpg"]]
# Para que el garbage corrector no borre nada
panel1.image = img1
panel2.image = img2
panel3.image = img3
panel4.image = img4


def cambiarTexto(texto):
    global posicionTexto
    global Textos
    global ImagenesTotales
    if posicionTexto == 2:
        posicionTexto = 0
    else:
        posicionTexto += 1
    # Imagenes
    # Definición de la imagen
    img1 = ImageTk.PhotoImage(
        (Image.open(ImagenesTotales[posicionTexto][0])).resize((282, 235), Image.ANTIALIAS))
    img2 = ImageTk.PhotoImage(
        (Image.open(ImagenesTotales[posicionTexto][1])).resize((282, 235), Image.ANTIALIAS))
    img3 = ImageTk.PhotoImage(
        (Image.open(ImagenesTotales[posicionTexto][2])).resize((282, 235), Image.ANTIALIAS))
    img4 = ImageTk.PhotoImage(
        (Image.open(ImagenesTotales[posicionTexto][3])).resize((282, 235), Image.ANTIALIAS))
    # Se configura
    panel1.configure(image=img1)
    panel2.configure(image=img2)
    panel3.configure(image=img3)
    panel4.configure(image=img4)
    # Garbage collector
    panel1.image = img1
    panel2.image = img2
    panel3.image = img3
    panel4.image = img4
    # Texto cambiable en las hojas de vida
    texto = Textos[posicionTexto]
    textoVida.configure(text=texto)
    textoVida.text = texto


# Dato curioso: Button 1 se refiere al click izquierdo
textoVida.bind("<Button 1>", cambiarTexto)
# Creación del menú
# Primero la función para crear el texto de la descripción:
verdad = 0  # Esto para ocultar/mostrar dependiendo del caso.
textoDescripcion = "La aplicación se basa en la propia administración de un\nrestaurante, la cual se ve inmersa en la gestión de los clientes,\nmeseros y su facturación. El administrador podrá calcular el\ndinero recolectado en el día, junto a otras facultades especiales."
labelDescripcion = tk.Label(master=p4, text=textoDescripcion, justify=tk.LEFT)


def mostrarDescripcion():
    global verdad
    # Cambiamos el valor a su opuesto
    if verdad == 1:
        verdad = 0
    else:
        verdad = 1
    if verdad == 1:
        labelDescripcion.place(x=0, y=410)
    else:
        labelDescripcion.place_forget()


menubar = tk.Menu(window)
window.config(menu=menubar)
file_menu = tk.Menu(menubar, tearoff=False)
file_menu.add_command(
    label="Descripcion",
    command=mostrarDescripcion)
file_menu.add_separator()
file_menu.add_command(
    label='Salir',
    command=window.destroy
)
menubar.add_cascade(
    label="Inicio",
    menu=file_menu
)
window.mainloop()
