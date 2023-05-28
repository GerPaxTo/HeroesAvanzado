package com.gerpax.heroesavanzado.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.gerpax.heroesavanzado.data.local.model.LocalHero

@Dao
interface SuperheroDAO {

    
    @Query("SELECT * FROM superheros")
    suspend fun getAll(): List<LocalHero>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllVararg(vararg users: LocalHero)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllList(users: List<LocalHero>)

    @Delete
    suspend fun delete(user: LocalHero)
}