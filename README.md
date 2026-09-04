# Laboratorio N.° 1: Conexión a base de datos con JDB y H2
**Asignatura:** Programación III (PROG3.I) - Ciclo 02-2026
**Universidad:** Universidad Tecnológica de El Salvador

## Integrantes del Grupo
1. **Cesia Esmeralda Funes Ruiz** - Usuario de GitHub: **cessifr-bit**
2. **Hazel Daniela Jiménez Martínez** - Usuario de GitHub: **HazelJM**
3. **Gerardo Emilio Recinos Miranda** - Usuario de GitHub: **g_rm0805**

## Entidad Elegida: **Proveedor**

**Pertinencia empresarial:**
La gestión de proveedores es un pilar fundamental en cualquier sistema corporativo 
de inventario o cadena de suministro. Nos permite registrar y mantener actualizados 
los datos de las empresas que surten mercancía, facilitando la comunicación y auditoría.

**Atributos del modelo:**
* `id` (INT - Llave primaria)
* `nombreEmpresa` (VARCHAR)
* `telefono` (VARCHAR)

## Uso de IA
*Para el desarrollo de este entregable, se utilizó un asistente de inteligencia artificial (LLM) con las siguientes finalidades:
* **Estructuración del proyecto:** Apoyo para aplicar correctamente el patrón DAO, asegurando la separación de responsabilidades
  entre el paquete `modelo` (sin dependencias de `java.sql`) y el paquete `datos` (centralizando las sentencias SQL).
* **Resolución de problemas del entorno (IDE):** Asistencia para comprender e ignorar los falsos positivos de "Language Injection" (error visual `Unable to resolve table`)
  dentro de IntelliJ IDEA 2026.2.1.
* **Configuración de control de versiones:** Guía paso a paso para configurar el archivo `.gitignore` y excluir correctamente los archivos compilados (`target/`)
  y la base de datos embebida (`*.mv.db`) del repositorio.*

---
*Proyecto desarrollado aplicando JDBC, PreparedStatement y ResultSet en un entorno estructurado por capas.*
