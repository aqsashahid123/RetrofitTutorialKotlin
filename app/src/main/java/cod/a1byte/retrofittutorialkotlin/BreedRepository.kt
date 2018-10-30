package cod.a1byte.retrofittutorialkotlin

class BreedRepository ( private  val  dogCeoDataSource : BreedDataSource) :  BreedDataSource {
    override  fun  listAll ( success : ( List <Breed>) ->  Unit , failure : () ->  Unit ) {
        dogCeoDataSource . listAll (success, failure)
    }

}