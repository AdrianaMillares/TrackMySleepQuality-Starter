Pregunta 1-1
-------------
How do you indicate that a class represents an entity to store in a Room database?
Poniendo la anotación @Entity antes de la clase

Pregunta 1-2
-------------
The DAO (data access object) is an interface that Room uses to map Kotlin functions to database queries.

How do you indicate that an interface represents a DAO for a Room database?
Con la anotación @Dao

Pregunta 1-3
------------
Which of the following statements are true about the Room database? Choose all that apply.

You can define tables for a Room database as annotated data classes.
If you return LiveData from a query, Room will keep the LiveData updated for you if the LiveData change.
To identify a class as a Room database, make it a subclass of RoomDatabase and annotate it with @Database.

Pregunta 1-4
-------------
Which of the following annotations can you use in your @Dao interface? Choose all that apply.

@Update
@Insert
@Query

Pregunta 1-5
-------------
How can you verify that your database is working? Select all that apply.

Escribir pruebas.
Ejecutar la aplicación hasta que se desplieguen los datos.

Pregunta 2-1
-------------
Which of the following is not a benefit of using coroutines?:

Hacen que las aplicaciónes se ejecuten rapidamente

Pregunta 2-2
------------
Which of the following is not true for suspend functions.?

Whether blocked or suspended, execution is still waiting for the result of the coroutine before continuing.