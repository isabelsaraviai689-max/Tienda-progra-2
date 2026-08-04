# Grupo 10 - Tienda

JDK 17.

## Decisiones (congeladas)

1. **ID** → `String` formato obligatorio `P` + 3 digitos (`P001`, `P002`...).
2. **Categoria** → `enum Categoria` (catalogo oficial).
3. **Store** → array = seed (20 registros BA); `List` = store de trabajo (JCF).
4. **Buscar** → solo por ID (nombre queda pendiente).
5. **No encontrado** → `null` en service; UI muestra mensaje y sigue.
6. **Validaciones** → negocio en `service`; re-pedir input invalido en `ui`.
7. **Lista vacia** → UI informa; no pantalla en blanco.

## Reglas de validacion (SM / BA)

1. ID no vacio, unico. Formato obligatorio: `P` + 3 digitos (`P001`...).
2. Nombre no vacio, entre 3 y 50 caracteres.
3. Categoria del catalogo oficial (`enum Categoria`).
4. Precio > 0, maximo 2 decimales.
5. Stock entero >= 0.
6. Sin ID duplicado.
7. Modificar solo si el producto existe.
8. Busqueda sin match → informar "no encontrado".
9. `contar()` = solo productos registrados.
10. Input invalido en UI → error y pedir de nuevo.
11. Si no hay productos, "Mostrar todos" informa lista vacia (UI).

## Capas

| Capa | Que va | Que no va |
|------|--------|-----------|
| `model` | `Producto`, `Categoria` (datos) | Scanner, prints, reglas |
| `service` | CRUD + validaciones | Scanner, prints |
| `ui` | `Main`, menu, Scanner, mensajes | Reglas de negocio |

## Quien implementa que

| Quien | Que |
|-------|-----|
| Anderson | `agregar`, `mostrar` |
| Luis Alonso | `buscar` |
| Camila | `modificar` |
| Esmeralda | `contar` + helpers de validacion |
| Isabel | Menu en `ui.Main` (incl. lista vacia / no encontrado) |

Ya en la base: seed de 20 productos y `convertirALista()`.
Los metodos CRUD siguen pendientes (stubs).

## Estructura

```
com.sv.grupo10.tienda
├── model/     Producto, Categoria
├── service/   TiendaService, TiendaServiceImplementacion
└── ui/        Main
```
