package Ejercicios.ejercicio4;

import org.jdbi.v3.core.Jdbi;

public class SetUpDatabase {

    static String REINICIAR_ESQUEMA = "DROP SCHEMA PUBLIC CASCADE";
    static String CREAR_TABLA_PERSONA = "CREATE TABLE persona (id_persona INT NOT NULL ";
    static String PRIMARY_KEY_PERSONA = "primary key generated always as identity (start with 1,increment by 1), ";
    static String CAMPOS_PERSONA = "nombre VARCHAR(255), apellido VARCHAR(255))";
    static String INSERTAR_PERSONA = "INSERT INTO persona (nombre, apellido) VALUES (?, ?)";

    private Jdbi jdbi;

    public SetUpDatabase(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public void setUp() {
        jdbi.useTransaction(handle -> {

            handle.execute(REINICIAR_ESQUEMA);

            handle.execute(CREAR_TABLA_PERSONA + PRIMARY_KEY_PERSONA + CAMPOS_PERSONA);

            handle.createUpdate(INSERTAR_PERSONA)
                    .bind(0, "José").bind(1, "Laurenti").execute();

            handle.createUpdate(INSERTAR_PERSONA)
                    .bind(0, "Esteban").bind(1, "Otermon").execute();

            handle.createUpdate(INSERTAR_PERSONA)
                    .bind(0, "Vladimir").bind(1, "Varkov").execute();

            handle.createUpdate(INSERTAR_PERSONA)
                    .bind(0, "Jairo").bind(1, "Crespo").execute();

        });
    }
}
