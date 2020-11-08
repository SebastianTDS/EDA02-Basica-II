# **EDA 02**

Se desea desarrollar un sistema de gestión de usuarios para una universidad. Dicho
sistema debe contar con un registro de todos sus usuarios y disponer distintas
funcionalidades detalladas más adelante.

---

En primer lugar los usuarios deben disponer de base, un nombre y una contraseña.
Dicha contraseña debe seguir los siguientes estándares para que se considere valida:

---
- Tiene una longitud de al menos 8 caracteres.
- Contiene al menos un carácter numérico.
- Contiene al menos una mayúscula.
- Contiene al menos una minúscula.
- Contiene al menos un carácter especial.
---

El usuario también debe de disponer de sus datos personales para poder ser
identificado. Se debe poder ingresar en la cuenta, salir y modificar algunos de los datos.
Los usuarios a su vez deben contar con las siguientes restricciones:

---
- Si intenta ingresar erróneamente 3 veces consecutivas, la cuenta será bloqueada
hasta que algún técnico anule el bloqueo.
- Si se desea modificar la contraseña, no puede utilizarse ninguna de las últimas 5
registradas.
- No puede haber más de 1 usuario con el mismo DNI.
---

Este sistema a su vez, debe disponer de 3 tipos de usuarios diferentes. Los alumnos, los
docentes y el personal técnico. Cada uno debe disponer de las siguientes características
propias de su usuario además de las básicas ya detalladas anteriormente:

---
- __Alumno:__ Debe poder enviar los “archivos” de las evaluaciones (Se utilizara en
formato string ) a los usuarios de tipo docente, debe disponer un listado de las
materias que está cursando, la nota y el estado de las mismas (Aprobado o
Desaprobado).

- __Docente:__ Debe poder enviar correcciones de las evaluaciones a sus alumnos.
También debe disponer de un listado de las evaluaciones que tiene pendiente a
corregir y de los alumnos que tiene en su curso.

- __Personal Técnico__ Pueden desbloquear las cuentas de usuarios que se
encuentran bloqueadas, Se encarga de cargar las materias a las que se inscriben
los alumnos y también de indicar a los docentes los alumnos que estarán
cursando su catedra.
---

Para finalizar, la clase de sistema debe contar con distintos métodos de reporte sobre
sus usuarios, por ejemplo, cuántos alumnos hay registrados, cuantos docentes, cuántos
son personal técnico, cuántos alumnos están cursando ‘X’ materia, etc.

_Se deben realizar los casos de prueba necesarios para poder verificar el correcto
funcionamiento de todo el programa._

