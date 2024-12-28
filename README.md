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

## **2. Configura la API Key**
Abre el archivo ConversorAPI.java ubicado en src/com/aluracursos/conversormoneda/.
Reemplaza "TU_API_KEY" con tu clave de API válida:

private static final String API_KEY = "TU_API_KEY";
