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
git clone https://github.com/tu-usuario/conversormonedas.git

**2. Configura la API Key**
Abre el archivo ConversorAPI.java ubicado en src/com/aluracursos/conversormoneda/.
Reemplaza "TU_API_KEY" con tu clave de API válida:
  private static final String API_KEY = "TU_API_KEY";

**3. Abre el proyecto en IntelliJ IDEA**
Selecciona la carpeta del proyecto y ábrela como un proyecto existente.
IntelliJ detectará automáticamente la estructura del proyecto.


**Cómo ejecutar el proyecto**

Desde IntelliJ IDEA
Abre la clase ConversorApp.java.
Haz clic en el botón "Run" o "Play" en IntelliJ.
Sigue las instrucciones del menú en la consola.
Desde la línea de comandos
Compila el proyecto desde la carpeta raíz:
  javac -d out src/com/aluracursos/conversormoneda/*.java
Ejecuta la aplicación:
  java -cp out com.aluracursos.conversormoneda.ConversorApp

**Uso de la Aplicación**

Al ejecutar la aplicación, verás un menú como este:
  1) Dólar => Peso argentino
  2) Peso argentino => Dólar
  3) Dólar => Real brasileño
  4) Real brasileño => Dólar
  5) Dólar => Peso colombiano
  6) Peso colombiano => Dólar
  7) Mostrar historial
  8) Salir

![Captura de Pantalla 2024-12-28 a la(s) 15 55 42](https://github.com/user-attachments/assets/1efce619-2638-48d9-8373-7355c1ae609d)

Selecciona una opción ingresando el número correspondiente.
Ingresa el monto que deseas convertir.
La aplicación mostrará el resultado de la conversión en tiempo real.
Puedes consultar el historial de conversiones seleccionando la opción 7.
Sal del programa seleccionando la opción 8.

**Estructura del Proyecto
**
El proyecto está organizado de manera modular para mantener el código limpio y fácil de entender:
src/
  └─ com/
      └─ aluracursos/
          └─ conversormoneda/
              └─ aplicacion/
                    ├─ ConversorApp.java        // Clase principal
                    ├─ ConversorAPI.java        // Conexión con la API ExchangeRate
                    ├─ ErrorEnConversionDeDuracionException.java // Excepciones personalizadas
                    └─ ...

**Manejo de Errores
**
Entrada inválida: Si ingresas un valor no numérico para el monto, el programa mostrará un mensaje como:
Error: Ingrese un monto válido (solo números).
Problemas de conexión: Si no hay conexión a Internet, verás un mensaje como:
Error al realizar la conversión: [detalle del error].
Clave de API inválida: Si la clave de API es incorrecta, el programa mostrará:
Error: La clave de API es inválida o no tiene permisos (Código 403).

**Tecnologías Utilizadas
**
Java 17: Lenguaje principal.
IntelliJ IDEA: IDE de desarrollo.
API ExchangeRate: Fuente de las tasas de cambio.
Gson: Biblioteca para manejar JSON.
Contribuciones

¡Las contribuciones son bienvenidas! Si tienes ideas para mejorar la aplicación:

1. Haz un fork del repositorio.
2. Crea una nueva rama (git checkout -b feature/nueva-funcionalidad).
3. Realiza tus cambios y haz un commit (git commit -m 'Añadir nueva funcionalidad').
4. Envía un pull request.

