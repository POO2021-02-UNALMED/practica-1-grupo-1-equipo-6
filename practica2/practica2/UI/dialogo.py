from tkinter import *

class FieldFrame(Frame):
    def __init__(self, master, nombre, descripcion, tituloCriterios, criterios, tituloValores, valores=None, habilitado=None):
        super().__init__(master)
        self._nombre = nombre
        self._descripcion = descripcion
        self._tituloCriterios = tituloCriterios
        self._criterios = criterios
        self._tituloValores = tituloValores
        self._valores = valores
        self._habilitado = habilitado
        from ventanaUsuario import bastardos,hijos
        bastardos.clear()
        hijos.clear()

        titulo = Label(master=self.master, text=self._nombre, height=3, width=100, justify=CENTER, font=("Comic Sans MS","12"), fg="blue")
        titulo.grid(column=1, row=1, padx=150, pady=10, columnspan=2, rowspan=2)
        bastardos.append(titulo)

        descripcion = Label(master=self.master, text=self._descripcion, height=4, width=100, justify=CENTER, font=("Comic Sans Ms","10"))
        descripcion.grid(column=1, row=3, padx=150, pady=10, columnspan=2, rowspan=2)
        bastardos.append(descripcion)

        #Columna con el nombre de los criterios a recibir
        columna1 = Label(master=self.master, text=self._tituloCriterios, height=2, width=60, justify=CENTER, font=("Comic Sans Ms","11"), fg="blue")
        columna1.grid(column=1, row=5, padx=10, pady=10, rowspan=2)
        bastardos.append(columna1)
        r = 7

        for i in range(len(self._criterios)):
            crt = Label(master=self.master, text=self._criterios[i], height=1, width=60, justify=CENTER, font=("Comic Sans Ms","10"))
            crt.grid(column=1, row=r, padx=10, pady=10)
            bastardos.append(crt)
            r += 1

        #Columna con los entry en la que el usuario ingresa valores
        columna2 = Label(master=self.master, text=self._tituloValores, height=2, width=60, justify=CENTER, font=("Comic Sans Ms","11"), fg="blue")
        columna2.grid(column=2, row=5, padx=10, pady=10, rowspan=2)
        bastardos.append(columna2)
        r = 7

        for i in range(len(self._criterios)):
            entry = Entry(master=self.master, width=60, font=("Comic Sans Ms","10"))
            entry.grid(column=2, row=r, padx=10, pady=10)
            bastardos.append(entry)
            if (self._valores != None and self._habilitado != None):
                for j in range(len(self._valores)):
                    if self._criterios[i] == self._valores[j][0]:
                        inicial = StringVar(master=entry, value=self._valores[j][1])
                        entry.configure(textvariable=inicial)
                if self._criterios[i] in self._habilitado:
                    entry.configure(state=DISABLED)
            r += 1

        #Botones
        accept = Button(master=self.master, text="Aceptar", height=1, width=30, justify=CENTER, activeforeground="Gray", relief=RAISED, bg="Gray", bd=2, font=("Comic Sans Ms","8"))
        accept.grid(column=1, row=r+1)
        bastardos.append(accept)

        erase = Button(master=self.master, text="Borrar", height=1, width=30, justify=CENTER, activeforeground="Gray", relief=RAISED, bg="Gray", bd=2, font=("Comic Sans Ms","8"))
        erase.grid(column=2, row=r+1)
        bastardos.append(erase)