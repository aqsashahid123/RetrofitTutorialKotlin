package cod.a1byte.retrofittutorialkotlin

import android.content.Context
import android.databinding.ObservableArrayList
import android.databinding.ObservableBoolean
import android.databinding.ObservableField

class BreedsViewModel(val repository: BreedDataSource, val context: Context) {
    val breeds = ObservableArrayList<Breed>()
    val loadingVisibility = ObservableBoolean(false)
    val message = ObservableField<String>()

    fun load() {
        loadingVisibility.set(true)
        message.set("")
        repository.listAll({ items ->
            breeds.clear()
            breeds.addAll(items)
            if (items.isEmpty()) {
                message.set(context.getString(R.string.breed_empty))
            }
            loadingVisibility.set(false)
        }, {
            message.set(context.getString(R.string.breed_failed))
            loadingVisibility.set(false)
        })
    }
}