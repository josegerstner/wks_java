/*
 * Paradigma!

Un grupo de amigos egresados de un conocido colegio secundario han 
decidido juntarse para crear su propia página web: Paradigma!, un 
portal en que usuarios suben información de interés general mediante posts.
 
La página cuenta con un sistema de valoración de los posts que permite 
categorizar a los usuarios. Los posts pueden ser comentados y puntuados:
Al comentar un post se agrega un pequeño comentario textual y al puntuarlo
se le incrementa una determinada cantidad de puntos al post.
  
El valor de un post equivale a la cantidad de comentarios que tenga más la 
puntuación. Hay algunos post, llamados premium, para los cuales se considera
el doble de la puntuacion recibida. La valoración de un usuario es la suma 
de todos los valores de sus posts.
 
Un usuario que recién ingresa es de categoría “Novato” y solo puede crear 
posts comunes. Cuando alcanza una valoracion de 100 puede ser promovido a
categoría “Intermedio”, en la que sigue creando post comunes.
Cuando un usuario “Intermedio” tiene una valoración de 1000 puntos al menos
un post con más un valor de más de 500, puede ser promovido a la última y 
definitiva categoría, llamada “Experto”, lo que le permite empezar a crear 
posts premium. Al cambiar de categoría los usuarios mantienen los posts 
anteriores.

La funcionalidad requerida es:
1. Poder crear un usuario y que esté listo para empezar a postear.
2. Hacer que un usuario postee un contenido dado.
3. Comentar un post
4. Puntuar un post
5. Saber el valor de un post.
6. Saber la valoracion de un usuario
7. Saber si un usuario es nuevo, es decir, si tiene algún post sin comentarios.
8. Promover a un usuario a su categoría siguiente, si es posible.
9. Obtener el post de un usuario que más éxito tuvo (el de mayor valor).
10. Saber la cantidad de posts interesantes de un usuario. Un post es 
	interesante si tiene al menos un comentarios largos (más de 100 caracteres).
	Los posts premium son más exigentes para ser interesantes: deben tener 
	además más de 50 puntos.
	
Se debe realizar:
	El diagrama de clases
	La codificación de los métodos necesarios
	Las siguientes justificaciones teóricas:
	¿Dónde aparece el concepto de polimorfismo, cómo es usado y a qué objetos 
		le resulta útil?
	¿Fue de utilidad la herencia y la redefinición? ¿Para qué?
 * */
package paradigma;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		Plataforma paradigma = new Plataforma();
		paradigma.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
