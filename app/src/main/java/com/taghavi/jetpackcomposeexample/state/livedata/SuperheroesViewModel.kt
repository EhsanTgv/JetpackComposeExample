package com.taghavi.jetpackcomposeexample.state.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.ViewModel
import com.taghavi.jetpackcomposeexample.core.Person
import com.taghavi.jetpackcomposeexample.core.getSuperheroList
import kotlinx.coroutines.delay

class SuperheroesViewModel : ViewModel() {
    val superheroes: LiveData<List<Person>> = liveData {
        val superheroList = loadSuperheroes()
        emit(superheroList)
    }

    suspend fun loadSuperheroes(): List<Person> {
        delay(2000)
        return getSuperheroList()
    }
}