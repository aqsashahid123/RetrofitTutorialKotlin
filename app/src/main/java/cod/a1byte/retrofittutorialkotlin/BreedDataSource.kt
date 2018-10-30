package cod.a1byte.retrofittutorialkotlin

interface BreedDataSource {
    fun  listAll ( success  : ( List <Breed>) ->  Unit , failure : () ->  Unit )
}