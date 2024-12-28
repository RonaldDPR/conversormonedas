# Conversor de Monedas

Esta es una aplicación de consola desarrollada en Java para realizar conversiones de monedas en tiempo real utilizando la API de [ExchangeRate](https://app.exchangerate-api.com/). La aplicación permite seleccionar diferentes opciones de conversión entre monedas y ofrece un historial de conversiones realizadas en una sesión.

---

## **Características**
- **Conversión en tiempo real:** Obtén tasas de cambio actualizadas a través de la API ExchangeRate.
- **Interfaz interactiva en consola:** Menú dinámico para seleccionar opciones de conversión.
- **Historial:** Visualiza las conversiones realizadas durante la sesión.
- **Manejo de errores:** Gestión de excepciones para entradas inválidas y problemas de conexión.

---

## **Requisitos**
Para ejecutar este proyecto necesitas:

- **Java 17** o superior instalado.
- **IntelliJ IDEA** (opcional, recomendado para desarrollo).
- Conexión a Internet para acceder a la API.
- Una clave de API válida de [ExchangeRate](https://app.exchangerate-api.com/).

---

## **Configuración del Proyecto**

### **1. Clona este repositorio**

```bash
git clone https://github.com/tu-usuario/conversor-monedas.git
```

### **2. Configura la API Key**
Abre el archivo ConversorAPI.java ubicado en src/com/aluracursos/conversormoneda/aplicacion/ y reemplaza "TU_API_KEY"con tu clave de API válida:
```java
 private static final String API_KEY = "TU_API_KEY";
```

### **3. Abre el proyecto en IntelliJ IDEA**
1.	Selecciona la carpeta del proyecto y ábrela como un proyecto existente.
2.	IntelliJ detectará automáticamente la estructura del proyecto.
 
### **Cómo ejecutar el proyecto**
**Desde IntelliJ IDEA**
1.	Abre la clase ConversorApp.java.
2.	Haz clic en el botón "Run" o "Play" en IntelliJ.
3.	Sigue las instrucciones del menú en la consola.

**Desde la línea de comandos**
1.	Compila el proyecto desde la carpeta raíz:
```bash
javac -d out src/com/aluracursos/conversormoneda/aplicacion/*.java
```
2.	Ejecuta la aplicación:
```bash
java -cp out com.aluracursos.conversormoneda.aplicacion.ConversorApp
```
### **Uso de la Aplicación**
1.	Al ejecutar la aplicación, verás un menú como este:
```mathematica
1) Dólar => Peso argentino
2) Peso argentino => Dólar
3) Dólar => Real brasileño
4) Real brasileño => Dólar
5) Dólar => Peso colombiano
6) Peso colombiano => Dólar
7) Mostrar historial
8) Salir
```

2.	Selecciona una opción ingresando el número correspondiente.
3.	Ingresa el monto que deseas convertir.
4.	La aplicación mostrará el resultado de la conversión en tiempo real.
5.	Puedes consultar el historial de conversiones seleccionando la opción 7.
6.	Sal del programa seleccionando la opción 8.
 
### **Estructura del Proyecto**

El proyecto está organizado de manera modular para mantener el código limpio y fácil de entender:
```scss
src/
  └─ com/
      └─ aluracursos/
          └─ conversormoneda/  
              └─ aplicacion/
                  ├─ ConversorApp.java        // Clase principal
                  ├─ ConversorAPI.java        // Conexión con la API ExchangeRate
                  ├─ ErrorEnConversionDeDuracionException.java // Excepciones personalizadas
                  └─ ...

```    

### **Manejo de Errores**

Entrada inválida
Si ingresas un valor no numérico para el monto, el programa mostrará un mensaje como:
```plaintext
Error: Ingrese un monto válido (solo números).
```
### **Problemas de conexión**

Si no hay conexión a Internet, verás un mensaje como:
```plaintext
Error al realizar la conversión: [detalle del error].
```
### **Clave de API inválida**

Si la clave de API es incorrecta, el programa mostrará:
```plaintext
Error: La clave de API es inválida o no tiene permisos (Código 403).
```

### **Tecnologías Utilizadas**

•	Java 17: Lenguaje principal.

•	IntelliJ IDEA: IDE de desarrollo.

•	API ExchangeRate: Fuente de las tasas de cambio.

•	Gson: Biblioteca para manejar JSON.
 
### **Contribuciones**

¡Las contribuciones son bienvenidas! Si tienes ideas para mejorar la aplicación:
1.	Haz un fork del repositorio.
2.	Crea una nueva rama:
```bash
git checkout -b feature/nueva-funcionalidad
```
3.	Realiza tus cambios y haz un commit:
```bash
git commit -m 'Añadir nueva funcionalidad'
```
4.	Envía un pull request.

