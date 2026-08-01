# Grupo 10 - Tienda

JDK 17 - Por compatibilidad.

### REGLAS DEL PROYECTO:

1. Se usa array como almacenamiento principal.
2. Se convierte a ArrayList para cumplir JCF.
3. ID es único.
4. No se permiten precios negativos.
5. Stock no puede ser negativo.


### Separación por capas obligatoria

- **`model`** → Solo datos. Clases como `Producto`: atributos, getters/setters, `toString()`. Nada de lógica ni de `Scanner`.
- **`service`** → La lógica y las reglas del negocio (validar, buscar, contar, etc.). No debe imprimir nada ni leer del `Scanner`.
- **`ui`** → Todo lo que interactúa con el usuario: el `Main`, el menú, el `Scanner`. Aquí se llama al `service`, pero no se decide nada aquí, solo se pregunta y se muestra.