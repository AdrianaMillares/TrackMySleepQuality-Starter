/*
 * Copyright 2019, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.trackmysleepquality.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Base de datos que guarda la información sobre la noche dormida. Se encarga de manejar la información
 * @param sleepDataBaseDao Conecta la base de datos con DAO
 */
@Database(entities = [SleepNight::class], version = 1, exportSchema = false)
abstract class SleepDatabase : RoomDatabase() {

    abstract val sleepDatabaseDao: SleepDatabaseDao

    /**
     * Definición de un companion object, permite crear funciones en la base de datos
     * @param INSTANCE valor volatil reinicia el valor de la base de datos
     */
    companion object {

        @Volatile
        private var INSTANCE: SleepDatabase? = null

        /**
         * Obtiene la base de datos.
         * @return la última base de datos recuperada
         * @param instance Se refiere a INTANCE previamente declarado
         * @param context Nos da el contexto de la aplicación, lo que nos permite ingresar al árbol de archivos
         */
        fun getInstance(context: Context): SleepDatabase {
            synchronized(this) {

                var instance = INSTANCE

                // Revisa si la instancia se encuentra vacia, en caso de que sea igual a null, se creara una nueva instancia.
                if (instance == null) {
                    instance = Room.databaseBuilder(
                            context.applicationContext,
                            SleepDatabase::class.java,
                            "sleep_history_database"
                    )
                            .fallbackToDestructiveMigration()
                            .build()
                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}
