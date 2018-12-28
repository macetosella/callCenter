# Ejercicio de Java

El objetivo de este ejercicio es conocer cómo los candidatos a entrar a UCA usan
herramientas básicas de Java y diseñan soluciones orientadas a objetos.
Forma de entrega
La solución tiene que estar pusheada en un repo git. La url del mismo tiene que ser
enviada por email. Como alternativa a git, la solución puede ser adjuntada (.tar, .zip, etc).
 <br>Propuesta utilizar: https://bitbucket.org/

# Consigna

Existe un call center donde hay 3 tipos de empleados: operator, supervisor y director. El
proceso de la atención de una llamada telefónica en primera instancia debe ser atendida
por un operator, si no hay ninguno libre debe ser atendida por un supervisor, y de no
haber tampoco supervisores libres debe ser atendida por un director.

# Requerimientos

Diseñar el modelado de clases y diagramas UML necesarios para documentar y comunicar el
diseño. Debe existir una clase Dispatcher encargada de manejar las llamadas, y debe contener el
método dispatchCall para que las asigne a los empleados disponibles. La clase Dispatcher debe
tener la capacidad de poder procesar 10 llamadas al mismo tiempo (de modo concurrente). Cada
llamada puede durar un tiempo aleatorio entre 5 y 10 segundos. Debe tener un test unitario
donde lleguen 10 llamadas.

# Extras/Plus (Plantear solución escrita o en forma de diagrama)
1- Dar alguna solución sobre qué pasa con una llamada cuando no hay ningún empleado libre.<br>
2- Dar alguna solución sobre qué pasa con una llamada cuando entran más de 10 llamadas
concurrentes.
Agregar los tests unitarios que se crean convenientes. Agregar documentación de código.
Tener en Cuenta
<ul> 
<li>El proyecto debe ser creado con Maven.</li>
<li>Anexar un documento con la explicación del cómo y porqué resolvió los puntos extras</li>
<li>No se especifica ninguna versión de Java, no se necesita interfaces visuales.</li>
</ul>

## Tecnologías usadas
      
   - [JUnit](http://junit.org/junit5/)
   - [Java 1.8](https://www.oracle.com/index.html)
   - [Maven](https://maven.apache.org/)   
   - [Intellij IDEA](https://www.jetbrains.com/idea/) (IDE)
   - [Git](https://git-scm.com/)
   - [Gitkraken](https://www.gitkraken.com/) interfaz para git  
   
![GitHub Logo](https://i.ytimg.com/vi/zFBclVWaK_U/hqdefault.jpg)

## Respuestas

- 1\)  `Cuando esto sucede si no se llegó al máximo de llamadas 
       concurrentes procesadas, la llamada entra en una lista de espera`
         
         
- 2\) `Si se llega al máximo de llamadas concurrentes, se emite un mensaje 
 diciendo que la llamada no puede ser procesada en este momento que intente mas tarde`
 
 NOTA: La documentacion se encuentra en /resources/readme.html
