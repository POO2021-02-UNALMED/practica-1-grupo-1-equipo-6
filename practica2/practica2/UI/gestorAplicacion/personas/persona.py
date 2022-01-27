#Clase abstracta, padre de las clases Mesero y Cliente, para implementar atributos compartidos en la clase hija
class Persona:
    #Para iniciar la clase
    def __init__(self,nombre,documento):
        self.nombre = nombre
        self.documento = documento
    #Método para entregar los datos de un modo especifico
    def entregarDatos(self):
        return "Nombre: " + self.nombre + "\n" + "Documento: " + str(self.documento)
    #Método para irse
    def irse(self):
        pass
    #Sets y gets:
    def getNombre(self):
        return self.nombre
    def setNombre(self,nombre):
        self.nombre = nombre
    def getDocumento(self):
        return self.documento
    def setDocumento(self,documento):
        self.documento = documento
    
