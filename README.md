# Inicio sesión MVC 🚀

 Aplicación en JavaFX que permita el inicio de sesión, aplicando el patrón de diseño MVC.
 
 Al pulsar el botón "Acceder" se validarán las credenciales. Si son válidas, se mostrará un mensaje indicando "Acceso permitido" y se terminará el programa.
 
 En caso de no ser válidas, se mostrará el mensaje "Acceso denegado" y se eliminará el contenido del cuadro de texto de la contraseña.
 
 Al pulsar el botón "Cancelar" terminará la aplicación.
 
 Los usuarios válidos se encontrarán en el fichero "users.csv" en formato CSV (Comma Separated Values), donde el primer campo será el nombre del usuario y el segundo la contraseña cifrada en MD5.
 
### Cifrado
 
 Las contraseñas irán cifradas mediante el algoritmo MD5. Éstas no se pueden descifrar, sino que lo que haremos será cifrar en MD5 la contraseña introducida y comprobar que coincide con la del fichero.
 
 Usaremos la librería Commons Codec de Apache